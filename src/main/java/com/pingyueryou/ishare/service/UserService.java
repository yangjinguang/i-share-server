package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.jooq.tables.pojos.IUser;

public interface UserService {
    IUser updateByOpenId(String openId, IUser iUser);
}
