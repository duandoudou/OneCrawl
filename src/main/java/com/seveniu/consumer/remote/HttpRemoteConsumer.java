package com.seveniu.consumer.remote;

import com.fasterxml.jackson.core.type.TypeReference;
import com.seveniu.common.json.Json;
import com.seveniu.consumer.Consumer;
import com.seveniu.consumer.TaskInfo;
import com.seveniu.node.Node;
import com.seveniu.task.TaskStatistic;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seveniu on 5/24/16.
 * RemoteConsumer
 */
public class HttpRemoteConsumer extends Consumer {

    private RemoteConsumerConfig remoteConsumerConfig;

    private RemoteRequest remoteRequest;

    public HttpRemoteConsumer(RemoteConsumerConfig remoteConsumerConfig) {
        super(remoteConsumerConfig.getName());
        this.remoteConsumerConfig = remoteConsumerConfig;
        this.remoteRequest = new RemoteRequest();
    }

    @Override
    public boolean has(String url) {
        if (status == STATUS.STOP) {
            return true;
        }
        return Boolean.valueOf(remoteRequest.send(remoteConsumerConfig.getDuplicateUrl(), url));
    }

    @Override
    public void out(Node node) {
        if (status == STATUS.STOP) {
            return;
        }
        remoteRequest.send(remoteConsumerConfig.getDoneUrl(), Json.toJson(node));
    }

    @Override
    public List<TaskInfo> receiveTasks() {
        if (status == STATUS.STOP) {
            return new ArrayList<>(0);
        }
        return Json.toObject(remoteRequest.send(remoteConsumerConfig.getTaskUrl(), null), new TypeReference<List<TaskInfo>>() {
        });
    }

    @Override
    public void statistic(TaskStatistic statistic) {
        if (status == STATUS.STOP) {
            return;
        }
        remoteRequest.send(remoteConsumerConfig.getStatisticUrl(), Json.toJson(statistic));
    }

    @Override
    public void stop0() {
        try {
            remoteRequest.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.warn("close http request error : {}", e.getMessage());
        }
    }


    private class RemoteRequest {
        CloseableHttpClient httpClient;

        public RemoteRequest() {
            this.httpClient = HttpClients.createDefault();
        }

        private void close() throws IOException {
            httpClient.close();
        }

        public String send(String url, String body) {
            InputStream inputStream = null;
            CloseableHttpResponse response = null;
            try {
                HttpPost post = new HttpPost(url);
                if (body != null) {
                    post.setEntity(new StringEntity(body));
                }
                response = httpClient.execute(post);
                HttpEntity entity = response.getEntity();
                inputStream = entity.getContent();
                return IOUtils.toString(inputStream, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (response != null) {
                        response.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }
}
