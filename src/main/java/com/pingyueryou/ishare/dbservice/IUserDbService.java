package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;

public interface IUserDbService {
    IUser create(IUser iUser);

    IUserExtra getByOpenId(String openId);

    IUser updateByOpenId(String openId, IUser iUser);


    void addRole(Long userId, Integer role);

    void rmRole(Long userId, Integer role);
}
