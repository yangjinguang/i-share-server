package com.pingyueryou.ishare.utils;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    GRADE_NOT_FOUND(1000, HttpStatus.BAD_REQUEST, "年级不存在"),
    CLASS_NOT_FOUND(1001, HttpStatus.BAD_REQUEST, "班级不存在"),
    CLASS_NAME_EMPTY(1002, HttpStatus.BAD_REQUEST, "名称不能为空"),

    SERVICE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "service error"),

    PARAM_ERROR(505, HttpStatus.BAD_REQUEST, "params error");


    private int code;
    private HttpStatus status;
    private String description;

    ErrorCode(int code, HttpStatus status, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDescription() {

        return description;
    }

    public static ErrorCode forNumber(int value) {
        switch (value) {
            case 500:
                return SERVICE_ERROR;
            case 505:
                return PARAM_ERROR;
            default:
                return null;
        }
    }


    public String getValue() {
        return description;
    }
}
