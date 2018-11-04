package com.example.sky0621;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("==========================================================");
        System.out.println("contextInitialized");
        ServletContext context = servletContextEvent.getServletContext();
        String path = context.getRealPath("/WEB-INF/bigquery/");
        System.out.println(path);
        Path pt = Paths.get(path);

        Map<String, String> m = new HashMap<>();
        try(final Stream<Path> pathStream = Files.walk(pt)) {
            pathStream.forEach(p -> {
                String sql = null;
                try {
                    sql = new String(Files.readAllBytes(p));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                m.put(p.getFileName().toString(), sql);
            });
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        BigQueryService.init(m);
        System.out.println("==========================================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("==========================================================");
        System.out.println("contextDestroyed");
        System.out.println("==========================================================");
    }
}
