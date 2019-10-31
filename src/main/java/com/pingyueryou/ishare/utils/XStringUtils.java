package com.pingyueryou.ishare.utils;

import com.alibaba.fastjson.JSONObject;

public class XStringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static JSONObject toJson(String str) {
        return JSONObject.parseObject(str);
    }
}
