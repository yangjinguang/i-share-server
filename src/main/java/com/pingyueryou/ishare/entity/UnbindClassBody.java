package com.pingyueryou.ishare.entity;

public class UnbindClassBody {
    private Long classId;
    private Long userId;

    public UnbindClassBody() {
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
