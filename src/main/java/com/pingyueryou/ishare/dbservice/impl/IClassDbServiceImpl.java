package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IGrade;
import com.pingyueryou.ishare.jooq.tables.pojos.IUserClass;
import com.pingyueryou.ishare.jooq.tables.records.IClassRecord;
import com.pingyueryou.ishare.jooq.tables.records.IGradeRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IClass.I_CLASS;
import static com.pingyueryou.ishare.jooq.tables.IGrade.I_GRADE;
import static com.pingyueryou.ishare.jooq.tables.IUserClass.I_USER_CLASS;

@Service
public class IClassDbServiceImpl implements IClassDbService {
    @Autowired
    private DSLContext context;

    @Override

    public IClass create(IClass iClass) {
        IClassRecord iClassRecord = context.newRecord(I_CLASS, iClass);
        iClassRecord.store();
        return iClassRecord.into(IClass.class);
    }

    @Override
    public IGrade createGrade(IGrade iGrade) {
        IGradeRecord iGradeRecord = context.newRecord(I_GRADE, iGrade);
        iGradeRecord.store();
        return iGradeRecord.into(IGrade.class);
    }

    @Override
    public IClass get(Long classId) {
        IClassRecord iClassRecord = context.selectFrom(I_CLASS)
                .where(I_CLASS.ID.eq(classId))
                .fetchOptional()
                .orElse(null);
        if (iClassRecord != null) {
            return iClassRecord.into(IClass.class);
        }
        return null;
    }

    @Override
    public IGrade getGrade(Long gradeId) {
        IGradeRecord iGradeRecord = context.selectFrom(I_GRADE)
                .where(I_GRADE.ID.eq(gradeId))
                .fetchOptional()
                .orElse(null);
        if (iGradeRecord != null) {
            return iGradeRecord.into(IGrade.class);
        }
        return null;
    }

    @Override
    public List<IClass> getByGradeId(Long gradeId) {
        return context.selectFrom(I_CLASS)
                .where(I_CLASS.GRADE_ID.eq(gradeId))
                .orderBy(I_CLASS.ORDER)
                .fetch()
                .into(IClass.class);
    }

    @Override
    public List<IGrade> getAllGrade() {
        return context.selectFrom(I_GRADE)
                .orderBy(I_GRADE.ORDER)
                .fetch()
                .into(IGrade.class);
    }

    @Override
    public void delete(Long classId) {
        context.deleteFrom(I_CLASS)
                .where(I_CLASS.ID.eq(classId))
                .execute();
    }

    @Override
    public void deleteGrade(Long gradeId) {
        context.deleteFrom(I_GRADE)
                .where(I_GRADE.ID.eq(gradeId))
                .execute();
    }

    @Override
    public List<IClass> getByUserId(Long userId) {
        return context.select(I_CLASS.fields())
                .from(I_USER_CLASS)
                .leftJoin(I_CLASS)
                .on(I_CLASS.ID.eq(I_USER_CLASS.CLASS_ID))
                .where(I_USER_CLASS.USER_ID.eq(userId))
                .fetch()
                .into(IClass.class);
    }

    @Override
    public void createUserClass(IUserClass userClass) {
        context.newRecord(I_USER_CLASS, userClass).store();
    }

    @Override
    public void deleteUserClass(Long userId, Long classId) {
        context.deleteFrom(I_USER_CLASS)
                .where(I_USER_CLASS.USER_ID.eq(userId))
                .and(I_USER_CLASS.CLASS_ID.eq(classId))
                .execute();

    }
}
