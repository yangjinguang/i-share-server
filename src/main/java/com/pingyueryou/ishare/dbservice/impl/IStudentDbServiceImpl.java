package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IStudentDbService;
import com.pingyueryou.ishare.entity.IStudentExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;
import com.pingyueryou.ishare.jooq.tables.records.IStudentRecord;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.jooq.DSLContext;
import org.jooq.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IClass.I_CLASS;
import static com.pingyueryou.ishare.jooq.tables.IGrade.I_GRADE;
import static com.pingyueryou.ishare.jooq.tables.IStudent.I_STUDENT;
import static com.pingyueryou.ishare.jooq.tables.IUserStudent.I_USER_STUDENT;

@Service
public class IStudentDbServiceImpl implements IStudentDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IStudent create(IStudent student) {
        IStudentRecord iStudentRecord = context.newRecord(I_STUDENT, student);
        iStudentRecord.store();
        return iStudentRecord.into(IStudent.class);
    }

    @Override
    public IStudent get(Long studentId) {
        IStudentRecord iStudentRecord = context.selectFrom(I_STUDENT)
                .where(I_STUDENT.ID.eq(studentId))
                .fetchOptional()
                .orElse(null);
        if (iStudentRecord != null) {
            return iStudentRecord.into(IStudent.class);
        }
        return null;
    }

    @Override
    public List<IStudent> getByClassId(Long classId) {
        return context.selectFrom(I_STUDENT)
                .where(I_STUDENT.CLASS_ID.eq(classId))
                .fetch()
                .into(IStudent.class);
    }

    @Override
    public IStudent update(Long studentId, IStudent iStudent) {
        IStudentRecord iStudentRecord = context.selectFrom(I_STUDENT)
                .where(I_STUDENT.ID.eq(studentId))
                .fetchOptional()
                .orElseThrow(NoDataFoundException::new);
        Long classId = iStudent.getClassId();
        if (classId != null) {
            iStudentRecord.setClassId(classId);
        }
        String name = iStudent.getName();
        if (!XStringUtils.isEmpty(name)) {
            iStudentRecord.setName(name);
        }
        iStudentRecord.update();
        return iStudentRecord.into(IStudent.class);
    }

    @Override
    public void delete(Long studentId) {
        context.deleteFrom(I_STUDENT)
                .where(I_STUDENT.ID.eq(studentId))
                .execute();
    }

    @Override
    public List<IStudentExtra> getByUserId(Long userId) {
        return context.select(I_STUDENT.fields())
                .select(I_CLASS.NAME.as("class_name"))
                .select(I_GRADE.NAME.as("grade_name"))
                .from(I_USER_STUDENT)
                .leftJoin(I_STUDENT)
                .on(I_STUDENT.ID.eq(I_USER_STUDENT.STUDENT_ID))
                .leftJoin(I_CLASS)
                .on(I_CLASS.ID.eq(I_STUDENT.CLASS_ID))
                .leftJoin(I_GRADE)
                .on(I_GRADE.ID.eq(I_CLASS.GRADE_ID))
                .where(I_USER_STUDENT.USER_ID.eq(userId))
                .fetch()
                .into(IStudentExtra.class);
    }

    @Override
    public Integer countByUserId(Long userId) {
        return context.selectCount().from(I_USER_STUDENT)
                .where(I_USER_STUDENT.USER_ID.eq(userId))
                .fetchOne()
                .into(Integer.class);
    }
}
