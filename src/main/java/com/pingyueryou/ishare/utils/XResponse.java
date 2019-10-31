package com.pingyueryou.ishare.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class XResponse {

    public static Map<String, Object> bodyBuild(HttpStatus status, String message, Object data) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("status", status);
        objectObjectHashMap.put("message", message);
        objectObjectHashMap.put("data", data);
        return objectObjectHashMap;
    }

    public static ResponseEntity ok(Object data) {
        Map<String, Object> body = bodyBuild(HttpStatus.OK, null, data);
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity badRequest(String message) {
        Map<String, Object> body = bodyBuild(HttpStatus.BAD_REQUEST, message, null);
        return ResponseEntity.badRequest().body(body);
    }
}
