package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;

import java.util.List;

public interface UserService {
    IUser updateByOpenId(String openId, IUser iUser);

    IUserExtra getCurrentUser();

    List<Long> getClassIds(Long userId);

    void addRole(Long userId,Integer role);
    void rmRole(Long userId,Integer role);

    void joinClass(Long userId, Long classId);

    void leaveClass(Long userId, Long classId);

    void bindStudent(Long userId, Long studentId);

    void unbindStudent(Long userId, Long studentId);
}
