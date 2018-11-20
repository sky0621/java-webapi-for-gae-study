package com.example.sky0621.fs2.enums;

import com.example.sky0621.fs2.consts.WorkerUrlPattern;

import java.util.Arrays;

public enum OrderEnum {
    NAMED_QUEUE_DEFAULT(0, null, new String[]{WorkerUrlPattern.DEFAULT}),
    NAMED_QUEUE_1(1, "myqueue01", new String[]{WorkerUrlPattern.NAMED1}),
    ;

    private int order;
    private String queueName;
    private String[] workerUrls;

    OrderEnum() {
    }

    OrderEnum(int order, String queueName, String[] workerUrls) {
        this.order = order;
        this.queueName = queueName;
        this.workerUrls = workerUrls;
    }

    public int getOrder() {
        return order;
    }

    public String getQueueName() {
        return queueName;
    }

    public String[] getWorkerUrls() {
        return workerUrls;
    }

    public static OrderEnum valueOf(int order) {
        return Arrays.stream(OrderEnum.values()).filter(e -> e.getOrder() == order).findFirst().orElse(null);
    }

    public static String[] getUrlsByOrder(int order) {
        return Arrays.stream(OrderEnum.values()).filter(e -> e.getOrder() == order).findFirst().map(e -> e.getWorkerUrls()).orElse(null);
    }

}
