package com.example.sky0621;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.utils.SystemProperty;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Properties properties = System.getProperties();

        response.setContentType("text/plain");
        response.getWriter().println("Hello App Engine - Standard using "
                + SystemProperty.version.get() + " Java " + properties.get("java.specification.version"));
        response.getWriter().println(SystemProperty.environment.value());
    }

    public static String getInfo() {
        return "Version: " + System.getProperty("java.version")
                + " OS: " + System.getProperty("os.name")
                + " User: " + System.getProperty("user.name");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");

        DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
        Entity e = new Entity(KeyFactory.createKey("book", Integer.parseInt(id)));
        e.setProperty("bookName", name);
        ds.put(e);

        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println(BigQueryService.getSql("TEST_001.sql"));
        System.out.println("======================================================");
        System.out.println("======================================================");
        System.out.println(BigQueryService.getSql("TEST_002.sql"));
        System.out.println("======================================================");
        System.out.println("======================================================");
    }

}
