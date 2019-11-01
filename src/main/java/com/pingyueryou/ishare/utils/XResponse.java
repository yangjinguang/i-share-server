package com.pingyueryou.ishare.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class XResponse {

    public static Map<String, Object> bodyBuild(int code, String message, Object data) {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("code", code);
        objectObjectHashMap.put("message", message);
        objectObjectHashMap.put("data", data);
        return objectObjectHashMap;
    }

    public static ResponseEntity ok(Object data) {
        Map<String, Object> body = bodyBuild(200, null, data);
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity badRequest(String message) {
        Map<String, Object> body = bodyBuild(400, message, null);
        return ResponseEntity.badRequest().body(body);
    }

    public static ResponseEntity errorCode(ErrorCode code) {
        Map<String, Object> body = bodyBuild(code.getCode(), code.getDescription(), null);
        return ResponseEntity.status(code.getStatus()).body(body);
    }
}
