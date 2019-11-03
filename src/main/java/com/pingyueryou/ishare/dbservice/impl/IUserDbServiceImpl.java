package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.jooq.tables.pojos.IUserRole;
import com.pingyueryou.ishare.jooq.tables.records.IUserRecord;
import com.pingyueryou.ishare.dbservice.IUserDbService;
import com.pingyueryou.ishare.jooq.tables.records.IUserRoleRecord;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.jooq.DSLContext;
import org.jooq.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;
import static com.pingyueryou.ishare.jooq.tables.IUserRole.I_USER_ROLE;

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
    public IUserExtra getByOpenId(String openId) {
        IUserRecord iUserRecord = context.selectFrom(I_USER)
                .where(I_USER.OPEN_ID.eq(openId))
                .fetchOptional()
                .orElse(null);
        if (iUserRecord != null) {
            IUser user = iUserRecord.into(IUser.class);
            List<IUserRole> iUserRoles = context.selectFrom(I_USER_ROLE)
                    .where(I_USER_ROLE.USER_ID.eq(iUserRecord.getId()))
                    .fetch()
                    .into(IUserRole.class);
            ArrayList<Integer> roles = new ArrayList<>();
            for (IUserRole iUserRole : iUserRoles) {
                roles.add(iUserRole.getRole());
            }
            return new IUserExtra(user, roles);
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

    @Override
    public void addRole(Long userId, Integer role) {
        IUserRole iUserRole = new IUserRole();
        iUserRole.setUserId(userId);
        iUserRole.setRole(role);
        context.newRecord(I_USER_ROLE, iUserRole).store();
    }

    @Override
    public void rmRole(Long userId, Integer role) {
        context.deleteFrom(I_USER_ROLE)
                .where(I_USER_ROLE.ROLE.eq(role))
                .and(I_USER_ROLE.USER_ID.eq(userId))
                .execute();
    }

}
