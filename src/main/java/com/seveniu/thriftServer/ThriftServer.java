package com.seveniu.thriftServer;

import com.seveniu.TaskQueue;
import com.seveniu.consumer.Consumer;
import com.seveniu.consumer.ConsumerManager;
import com.seveniu.consumer.ConsumerTaskManager;
import com.seveniu.def.TaskStatus;
import com.seveniu.task.SpiderRegulate;
import com.seveniu.task.TaskStatistic;
import com.seveniu.util.Json;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seveniu on 7/3/16.
 * ThriftServer
 */
@Service
public class ThriftServer {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private volatile boolean running;

    @Autowired
    TaskQueue taskQueue;
    @Autowired
    ConsumerManager consumerManager;
    @Value("${thriftServerPort}")
    int port;

    public void startServer() {
        if (running) {
            logger.warn("thrift server has running ");
            return;
        }
        new Thread(() -> {

            try {
                TServerSocket socket = new TServerSocket(port);
                CrawlThrift.Processor processor = new CrawlThrift.Processor<>(new Server());
                TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(socket).processor(processor));
                running = true;
                server.serve();
            } catch (TTransportException e) {
                e.printStackTrace();
                running = false;
            }
        }, "thrift-server-thread").start();
        logger.info("start crawl thrift server at : {}", port);
    }

    private class Server implements CrawlThrift.Iface {


        @Override
        public String reg(ConsumerConfig consumerConfig) throws TException {
            try {
                String uuid = consumerManager.regRemoteConsumer(consumerConfig);
                if (uuid != null) {
                    return uuid;
                }
            } catch (ConnectException e) {
                e.printStackTrace();
            }
            return "";
        }


        @Override
        public TaskStatus addTask(String uuid, TaskInfo taskInfo) throws TException {
            return consumerManager.getConsumerByUUID(uuid).getTaskManager().addTask(taskInfo);
        }

        @Override
        public String getRunningTasks(String uuid) throws TException {
            List<TaskStatistic> taskStatistics;
            try {
                taskStatistics = consumerManager.getConsumerByUUID(uuid).getTaskManager().getRunningTaskInfo();
            } catch (Exception e) {
                logger.error("uuid : {} get Running Task error : {}", uuid, e.getMessage());
                taskStatistics = new ArrayList<>(0);
            }
            return Json.toJson(taskStatistics);
        }

        @Override
        public ResourceInfo getResourceInfo(String uuid) throws TException {
            Consumer consumer = consumerManager.getConsumerByUUID(uuid);
            ConsumerTaskManager taskManager = consumer.getTaskManager();
            return new ResourceInfo(
                    taskManager.getMaxRunning(),
                    taskManager.getMaxWait(),
                    taskManager.getCurRunningSize(),
                    taskQueue.getWaitSize(consumer.getName())
            );
        }


        @Override
        public String getTaskSummary(String uuid) throws TException {
            SpiderRegulate.SpiderInfo spiderInfo = consumerManager.getConsumerByUUID(uuid).getTaskManager().getSpiderInfo();
            return Json.toJson(spiderInfo);
        }

    }

}
