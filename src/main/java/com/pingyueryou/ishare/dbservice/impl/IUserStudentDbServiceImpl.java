package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IUserStudentDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IUserStudent;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pingyueryou.ishare.jooq.tables.IUserStudent.I_USER_STUDENT;

@Service
public class IUserStudentDbServiceImpl implements IUserStudentDbService {
    @Autowired
    private DSLContext context;

    @Override
    public void create(IUserStudent userStudent) {
        context.newRecord(I_USER_STUDENT, userStudent).store();

    }

    @Override
    public void delete(Long userId, Long studentId) {
        context.deleteFrom(I_USER_STUDENT)
                .where(I_USER_STUDENT.USER_ID.eq(userId))
                .and(I_USER_STUDENT.STUDENT_ID.eq(studentId))
                .execute();
    }
}
