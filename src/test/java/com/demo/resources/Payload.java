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
    
    public static Map<String, String> createUserLocal(String firstName, String lastName, int SubjectId) {
        Map<String, String> data = new HashMap<>();
        data.put("firstName", firstName);
        data.put("lastName", lastName);
        data.put("SubjectId", SubjectId);
        return data;
    }
    
    public static Map<String, String> updateUserLocal(String firstName, String lastName, int SubjectId) {
        Map<String, String> data = new HashMap<>();
        data.put("firstName", firstName);
        data.put("lastName", lastName);
        data.put("SubjectId", SubjectId);
        return data;
    }
}
