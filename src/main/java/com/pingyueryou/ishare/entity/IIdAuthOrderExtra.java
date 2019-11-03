package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IIdAuthOrder;

public class IIdAuthOrderExtra extends IIdAuthOrder {
    private String nickName;
    private IClassExtra iClass;

    public IIdAuthOrderExtra() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public IClassExtra getiClass() {
        return iClass;
    }

    public void setiClass(IClassExtra iClass) {
        this.iClass = iClass;
    }
}
