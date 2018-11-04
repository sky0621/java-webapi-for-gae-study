package com.example.sky0621;

import java.util.Collections;
import java.util.Map;

public class BigQueryService {
    private static Map<String, String> sqlMap;

    public static void init(Map<String, String> m) {
        sqlMap = Collections.unmodifiableMap(m);
    }

    public static String getSql(String key) {
        return sqlMap.get(key);
    }
}
