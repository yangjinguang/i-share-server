package com.pingyueryou.ishare.utils;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    GRADE_NOT_FOUND(1000, HttpStatus.BAD_REQUEST, "年级不存在"),
    CLASS_NOT_FOUND(1001, HttpStatus.BAD_REQUEST, "班级不存在"),
    CLASS_NAME_EMPTY(1002, HttpStatus.BAD_REQUEST, "名称不能为空"),


    LEND_CANCEL_STATUS_NOT_MATCH(2000, HttpStatus.BAD_REQUEST, "状态不符合条件"),

    SERVICE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR, "服务器错误"),
    FORBIDDEN(500, HttpStatus.FORBIDDEN, "没有权限"),
    PARAM_ERROR(505, HttpStatus.BAD_REQUEST, "参数错误，请检查");


    private int code;
    private HttpStatus status;
    private String description;

    ErrorCode(int code, HttpStatus status, String description) {
        this.code = code;
        this.status = status;
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
