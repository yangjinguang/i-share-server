package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;

import java.util.List;

public interface IStudentDbService {
    IStudent create(IStudent student);

    IStudent get(Long studentId);

    List<IStudent> getByClassId(Long classId);

    IStudent update(Long studentId, IStudent iStudent);

    void delete(Long studentId);
}
