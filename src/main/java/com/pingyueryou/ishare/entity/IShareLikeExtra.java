package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IShareLike;

public class IShareLikeExtra extends IShareLike {
    private String userName;

    public IShareLikeExtra() {
    }

    public IShareLikeExtra(IShareLike value) {
        super(value);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
