package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IUser;

public interface IUserDbService {
    IUser create(IUser iUser);

    IUser getByOpenId(String openId);

    IUser updateByOpenId(String openId,IUser iUser);
}
