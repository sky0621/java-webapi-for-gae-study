package com.example.sky0621.fs2.worker;

import com.example.sky0621.fs2.consts.WorkerUrlPattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(
        name = "MyWorker01",
        urlPatterns = WorkerUrlPattern.NAMED1
)
public class MyWorker01 extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(MyWorker01.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = req.getParameter("json");
        LOG.info(json);

        MyWorker01Param p = new MyWorker01Param();
        p.toObject(json);
        LOG.info(String.format("[workerId] %s", p.getWorkerId()));
        LOG.info(String.format("[memo] %s", p.getMemo()));

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info(String.format("finished"));
        super.doPost(req, resp);
    }

}
