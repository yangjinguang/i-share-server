package com.pingyueryou.ishare.entity;

public class IdAuthHandleBody {
    private Long orderId;
    private boolean agree;
    private Long studentId;

    public IdAuthHandleBody() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
