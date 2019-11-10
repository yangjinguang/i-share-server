package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IShareComment;

public class IShareCommentExtra extends IShareComment {
    private String userName;

    public IShareCommentExtra() {
    }

    public IShareCommentExtra(IShareComment value) {
        super(value);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
