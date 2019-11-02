package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IGrade;
import com.pingyueryou.ishare.jooq.tables.pojos.IUserClass;

import java.util.List;

public interface IClassDbService {
    IClass create(IClass iClass);

    IGrade createGrade(IGrade iGrade);

    IClass get(Long classId);

    IGrade getGrade(Long gradeId);

    List<IClass> getByGradeId(Long gradeId);

    List<IGrade> getAllGrade();

    void delete(Long classId);

    void deleteGrade(Long gradeId);

    List<IClass> getByUserId(Long userId);

    void createUserClass(IUserClass userClass);

    void deleteUserClass(Long userId, Long classId);
}
