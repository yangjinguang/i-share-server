package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.IUserStudentDbService;
import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;
import com.pingyueryou.ishare.dbservice.IUserDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IUserClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IUserStudent;
import com.pingyueryou.ishare.security.UserEntity;
import com.pingyueryou.ishare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDbService iUserDbService;
    @Autowired
    private IClassDbService iClassDbService;
    @Autowired
    private IUserStudentDbService iUserStudentDbService;

    @Override
    public IUser updateByOpenId(String openId, IUser iUser) {
        IUser findUser = iUserDbService.getByOpenId(openId);
        if (findUser != null) {
            return iUserDbService.updateByOpenId(openId, iUser);
        } else {
            return iUserDbService.create(iUser);
        }
    }

    @Override
    public IUserExtra getCurrentUser() {
        UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userEntity.getUser();
    }

    @Override
    public List<Long> getClassIds(Long userId) {
        List<IClass> classes = iClassDbService.getByUserId(userId);
        ArrayList<Long> classIds = new ArrayList<>();
        for (IClass aClass : classes) {
            classIds.add(aClass.getId());
        }
        return classIds;
    }

    @Override
    public void addRole(Long userId, Integer role) {
        iUserDbService.addRole(userId, role);
    }

    @Override
    public void rmRole(Long userId, Integer role) {
        iUserDbService.rmRole(userId, role);
    }

    @Override
    public void joinClass(Long userId, Long classId) {
        IUserClass iUserClass = new IUserClass();
        iUserClass.setUserId(userId);
        iUserClass.setClassId(classId);
        try {
            iClassDbService.createUserClass(iUserClass);
        } catch (DuplicateKeyException ignore) {
        }

    }

    @Override
    public void leaveClass(Long userId, Long classId) {
        iClassDbService.deleteUserClass(userId, classId);
    }

    @Override
    public void bindStudent(Long userId, Long studentId) {
        IUserStudent iUserStudent = new IUserStudent();
        iUserStudent.setUserId(userId);
        iUserStudent.setStudentId(studentId);
        try {
            iUserStudentDbService.create(iUserStudent);
        } catch (DuplicateKeyException ignore) {
        }

    }

    @Override
    public void unbindStudent(Long userId, Long studentId) {
        iUserStudentDbService.delete(userId, studentId);
    }
}
