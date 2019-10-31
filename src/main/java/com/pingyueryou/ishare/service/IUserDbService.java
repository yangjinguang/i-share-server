package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.jooq.tables.pojos.IUser;

public interface IUserDbService {
    IUser create(IUser iUser);

    IUser getByOpenId(String openId);

    IUser updateByOpenId(String openId,IUser iUser);
}
