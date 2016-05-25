package com.seveniu.spider.pipeline;

import com.seveniu.common.json.Json;
import com.seveniu.node.Node;
import com.seveniu.parse.FieldResult;
import com.seveniu.parse.PageResult;
import com.seveniu.spider.MySpider;
import com.seveniu.spider.pageProcessor.MyPageProcessor;
import com.seveniu.template.def.FieldHtmlType;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * Created with IntelliJ IDEA.
 * User: niu
 * Date: 2014/6/11
 * Time: 12:03
 * Project: dhlz-spider
 */
public class MyPipeLine implements Pipeline {


    @Override
    public void process(ResultItems resultItems, Task task) {

        if (resultItems.getAll().size() > 0) {

            Node node = resultItems.get(MyPageProcessor.CONTEXT_NODE);
            MySpider mySpider = (MySpider) task;

            // 处理图片
            if (mySpider.getImageProcess() != null) {
                for (PageResult pageResult : node.getPages()) {
                    for (FieldResult fieldResult : pageResult.getFieldResults()) {
                        if (fieldResult.getFieldHtmlType() == FieldHtmlType.HTML_TEXT.getId()) {
                            String result = mySpider.getImageProcess().process(fieldResult.getResult(), mySpider.getSite());
                            fieldResult.setResult(result);
                        }
                    }
                }
            }

            // out 输出
            mySpider.getConsumer().out(Json.toJson(node));
        }
    }


}
