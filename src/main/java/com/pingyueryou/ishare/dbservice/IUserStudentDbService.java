package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IUserStudent;

public interface IUserStudentDbService {
    void create(IUserStudent userStudent);

    void delete(Long userId, Long studentId);
}
