package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.jooq.tables.records.IUserRecord;
import com.pingyueryou.ishare.dbservice.IUserDbService;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.jooq.DSLContext;
import org.jooq.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

@Service
public class IUserDbServiceImpl implements IUserDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IUser create(IUser iUser) {
        IUserRecord iUserRecord = context.newRecord(I_USER, iUser);
        iUserRecord.store();
        return iUserRecord.into(IUser.class);
    }

    @Override
    public IUser getByOpenId(String openId) {
        IUserRecord iUserRecord = context.selectFrom(I_USER)
                .where(I_USER.OPEN_ID.eq(openId))
                .fetchOptional()
                .orElse(null);
        if (iUserRecord != null) {
            return iUserRecord.into(IUser.class);
        }
        return null;
    }

    @Override
    public IUser updateByOpenId(String openId, IUser iUser) {
        IUserRecord iUserRecord = context.selectFrom(I_USER)
                .where(I_USER.OPEN_ID.eq(openId))
                .fetchOptional()
                .orElseThrow(NoDataFoundException::new);
        String nickName = iUser.getNickName();
        if (!XStringUtils.isEmpty(nickName)) {
            iUserRecord.setNickName(nickName);
        }
        String avatarUrl = iUser.getAvatarUrl();
        if (!XStringUtils.isEmpty(avatarUrl)) {
            iUserRecord.setAvatarUrl(avatarUrl);
        }
        Integer gender = iUser.getGender();
        if (gender != null) {
            iUserRecord.setGender(gender);
        }
        iUserRecord.update();
        return iUserRecord.into(IUser.class);
    }
}
