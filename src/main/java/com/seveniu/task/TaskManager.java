package com.seveniu.task;

import com.seveniu.customer.Consumer;
import com.seveniu.customer.ConsumerManager;
import com.seveniu.spider.MySpider;
import com.seveniu.spider.SpiderFactory;
import com.seveniu.spider.SpiderType;
import com.seveniu.spider.imgParse.ImageProcess;
import com.seveniu.template.PagesTemplate;
import org.apache.commons.lang3.StringUtils;
import org.crsh.cli.impl.descriptor.IllegalParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by seveniu on 5/12/16.
 * TaskManager
 */
@Component
public class TaskManager {
    private static final int THREAD_THRESHOLD = 200;
    private Logger logger = LoggerFactory.getLogger(TaskManager.class);
    @Autowired
    ConsumerManager consumerManager;

    private LinkedBlockingQueue<SpiderTask> waitTaskQueue = new LinkedBlockingQueue<>();
    private LinkedBlockingQueue<SpiderTask> runningTask = new LinkedBlockingQueue<>();
    private AtomicInteger curThread = new AtomicInteger(0);

    public TaskManager() {
        execTask();
        checkTaskStatus();
        StringUtils.isNotEmpty("");
    }


    public void addTask(SpiderType spiderType, String consumerName, String templateId, String templates, SpiderConfig spiderConfig, ImageProcess imageProcess) throws IllegalParameterException {
        if (hasRun(templateId)) {
            logger.info("template : {}  has running");
            return;
        }
        if (hasWait(templateId)) {
            logger.info("template : {}  has wait");
            return;
        }
        PagesTemplate pagesTemplate = PagesTemplate.fromJson(templates);
        if (pagesTemplate == null) {
            logger.error("consumer {} 's template {} is error", consumerName, templateId);
        } else {
            Consumer consumer = consumerManager.getCustomer(consumerName);
            if (consumer == null) {
                logger.warn("consumer {} is not registered", consumerName);
                return;
            }

            String id = generateTaskId(consumerName, templateId);
            MySpider mySpider = SpiderFactory.getSpider(id, spiderType, spiderConfig, templateId, consumer, pagesTemplate);

            waitTaskQueue.add(mySpider);
        }
    }

    private boolean hasWait(String templateId) {
        for (SpiderTask spiderTask : waitTaskQueue) {
            if (spiderTask.getTemplateId().equals(templateId)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasRun(String templateId) {
        for (SpiderTask spiderTask : runningTask) {
            if (spiderTask.getTemplateId().equals(templateId)) {
                return true;
            }
        }

        return false;
    }

    private void checkTaskStatus() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Iterator<SpiderTask> iterator = runningTask.iterator();
                        while (iterator.hasNext()) {
                            SpiderTask task = iterator.next();
                            if (task.getStatus() == Spider.Status.Stopped) {
                                iterator.remove();
                                curThread.addAndGet(0 - task.spiderConfig().getThreadNum());
                            }
                        }
                        TimeUnit.SECONDS.sleep(5);
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("check thread is error : {}", e.getMessage());
                        break;
                    }
                }
            }
        }, "taskManager-check-task-thread").start();
    }

    private void execTask() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        SpiderTask task = waitTaskQueue.take();
                        while (curThread.get() < THREAD_THRESHOLD) {
                            curThread.addAndGet(THREAD_THRESHOLD);
                            runningTask.add(task);
                            task.start();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        logger.error("exec thread is error : {}", e.getMessage());
                        break;
                    }
                }
            }
        }, "taskManager-exec-task-thread").start();
    }

    private String generateTaskId(String customer, String templateId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return sdf.format(date) + "-" + customer + "-" + templateId;
    }

}
