package com.seveniu.task;

import com.seveniu.thriftServer.TaskInfo;
import us.codecraft.webmagic.Spider;

/**
 * Created by seveniu on 5/17/16.
 * SpiderTask
 */
public interface SpiderTask extends Runnable {
    void start();

    Spider.Status getStatus();

    void stop();

    TaskInfo taskInfo();

    String getId();

}
