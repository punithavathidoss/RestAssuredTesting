package com.demo.resources;

import java.util.HashMap;
import java.util.Map;

public class Payload {

    public static Map<String, String> createUser(String name, String job) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("job", job);
        return map;
    }

    public static Map<String, String> updateUser(String name, String job, String role) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("job", job);
        map.put("role", role);
        return map;
    }
}
