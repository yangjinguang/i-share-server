package com.pingyueryou.ishare.entity;

public class ItemLendOrderStatusBody {
    private Long orderId;
    private Boolean agree;

    public ItemLendOrderStatusBody() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean getAgree() {
        return agree;
    }

    public void setAgree(Boolean agree) {
        this.agree = agree;
    }
}
