package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.service.IUserDbService;
import com.pingyueryou.ishare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDbService iUserDbService;

    @Override
    public IUser updateByOpenId(String openId, IUser iUser) {
        IUser findUser = iUserDbService.getByOpenId(openId);
        if (findUser != null) {
            return iUserDbService.updateByOpenId(openId, iUser);
        } else {
            return iUserDbService.create(iUser);
        }
    }
}
