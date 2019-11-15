package com.pingyueryou.ishare.entity;

public class UnbindStudentBody {
    private Long studentId;
    private Long userId;

    public UnbindStudentBody() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
