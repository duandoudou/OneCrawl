package com.seveniu.spider.pageProcessor;

import com.seveniu.common.json.Json;
import com.seveniu.customer.Consumer;
import com.seveniu.node.Node;
import com.seveniu.parse.PageResult;
import com.seveniu.parse.ParseHtml;
import com.seveniu.parse.ParseResult;
import com.seveniu.task.TaskStatistic;
import com.seveniu.template.PagesTemplate;
import com.seveniu.template.def.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by seveniu on 5/12/16.
 * MyPageProcessor
 */
public class MyPageProcessor implements PageProcessor {
    public static final String CONTEXT_NODE = "node";
    public static final String TASK = "task";
    private static final String SERIAL_NUM = "serialNum";
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PagesTemplate pagesTemplate;
    private TaskStatistic statistic;
    private Consumer consumer;

    public MyPageProcessor(Consumer consumer, PagesTemplate pagesTemplate, TaskStatistic statistic) {
        this.consumer = consumer;
        this.pagesTemplate = pagesTemplate;
        this.statistic = statistic;
    }

    @Override
    public void process(Page page) {
        String url = page.getUrl().get();
        // 统计
        statistic.addSuccessUrlCount(1);


        // 获取页面序号
        Integer serialNum = (Integer) page.getRequest().getExtra(SERIAL_NUM);
        if (serialNum == null) {
            serialNum = 0;
            page.getRequest().putExtra(SERIAL_NUM, serialNum);
        }
        Template template = pagesTemplate.getTemplate(serialNum);
        if (template == null) {
            return;
        }

        //根据序号找到对应模板,解析页面
        ParseResult parseResult = ParseHtml.parseHtml(url, page.getHtml(), template);
        if (parseResult.getParseError() != null) {
            statistic.addParseErrorCount(1);
            logger.warn("parse html error : {}", Json.toJson(parseResult.getParseError()));
            return;
        } else {
            statistic.addDoneUrlCount(1);
        }


        Node contextNode = (Node) page.getRequest().getExtra(CONTEXT_NODE);
        // 处理解析的结果
        // 内容
        if (parseResult.getFieldResults() != null && parseResult.getFieldResults().size() > 0) {
            // 有文本字段,就获取 node 添加内容
            if (contextNode == null) {
                contextNode = new Node(url);
                page.getRequest().putExtra(CONTEXT_NODE, contextNode);
                statistic.addCreateNodeCount(1);
            }
            contextNode.addPageResult(new PageResult(url, parseResult.getFieldResults()));
        }

        // 下一页链接
        if (parseResult.hasNextPageLinks()) {
            for (String next : parseResult.getNextPageLinks()) {
                page.addTargetRequest(new Request(next).putExtra(CONTEXT_NODE, contextNode).putExtra(SERIAL_NUM, serialNum));
            }
            // 统计
            statistic.addCreateUrlCount(parseResult.getNextPageLinks().size());
        }

        // 跳转链接
        if (parseResult.hasLinks()) {
            for (String targetLink : parseResult.getTargetLinks()) {
                if (contextNode == null && consumer.has(targetLink)) { //
                    logger.debug("url is repeat : {} ", targetLink);
                    statistic.addRepeatUrlCount(1);
                } else {
                    page.addTargetRequest(new Request(targetLink).putExtra(CONTEXT_NODE, contextNode).putExtra(SERIAL_NUM, serialNum + 1));
                }
            }
            // 统计
            statistic.addCreateUrlCount(parseResult.getTargetLinks().size());
        }

        // 没有 跳转链接 也没有 下一页链接, 则完成 node
        if (!parseResult.hasLinks() && !parseResult.hasNextPageLinks()) {
            statistic.addDoneNodeCount(1);
            page.putField(CONTEXT_NODE, contextNode);
        }

    }


    @Override
    public Site getSite() {
        return Site.me()
                .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.71 Safari/537.36")
                .setRetryTimes(3);
    }

}
