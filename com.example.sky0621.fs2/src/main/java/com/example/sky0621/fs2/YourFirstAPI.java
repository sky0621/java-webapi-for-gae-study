package com.example.sky0621.fs2;

import com.example.sky0621.fs2.worker.MyWorker01Param;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;

import java.io.IOException;
import java.util.logging.Logger;

import static com.example.sky0621.fs2.enums.OrderEnum.*;

/**
 * Add your first API methods in this class, or you may create another class. In that case, please
 * update your web.xml accordingly.
 **/
@Api(name = "fs2",
        version = "v1")
public class YourFirstAPI {
    private static final Logger LOG = Logger.getLogger(YourFirstAPI.class.getName());

    @ApiMethod(
            name = "tryTaskQueue",
            path = "queue",
            httpMethod = ApiMethod.HttpMethod.POST
    )
    public void tryTaskQueue(Order o) throws IOException {
        LOG.info("===== START =====");

        switch (valueOf(o.getOrder())) {
            case NAMED_QUEUE_1:
                LOG.info("NAMED_QUEUE_1");
                Queue q01 = QueueFactory.getQueue(NAMED_QUEUE_1.getQueueName());
                for (String workerUrl : NAMED_QUEUE_1.getWorkerUrls()) {
                    MyWorker01Param p = new MyWorker01Param();
                    p.setWorkerId("W01-a");
                    p.setMemo("This is a worker01.");
                    LOG.info("before add queue");
                    q01.add(TaskOptions.Builder.withUrl(workerUrl).param("json", p.toJson()));
                    LOG.info("after add queue");
                }
            default:
                LOG.info("default");
                Queue qDef = QueueFactory.getDefaultQueue();
                MyWorker01Param p = new MyWorker01Param();
                p.setWorkerId("W-def");
                p.setMemo("This is a default worker.");
                qDef.add(TaskOptions.Builder.withUrl(NAMED_QUEUE_DEFAULT.getQueueName()).param("json", p.toJson()));
        }
    }

}
