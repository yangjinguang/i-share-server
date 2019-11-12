package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IShareDbService;
import com.pingyueryou.ishare.entity.IShareExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.records.IShareRecord;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IClass.I_CLASS;
import static com.pingyueryou.ishare.jooq.tables.IGrade.I_GRADE;
import static com.pingyueryou.ishare.jooq.tables.IItem.I_ITEM;
import static com.pingyueryou.ishare.jooq.tables.IShare.I_SHARE;
import static com.pingyueryou.ishare.jooq.tables.IShareComment.I_SHARE_COMMENT;
import static com.pingyueryou.ishare.jooq.tables.IShareLike.I_SHARE_LIKE;
import static com.pingyueryou.ishare.jooq.tables.IStudent.I_STUDENT;
import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.name;

@Service
public class IShareDbServiceImpl implements IShareDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IShare get(Long shareId) {
        IShareRecord iShareRecord = context.selectFrom(I_SHARE)
                .where(I_SHARE.ID.eq(shareId))
                .fetchOptional()
                .orElse(null);
        if (iShareRecord != null) {
            return iShareRecord.into(IShare.class);
        }
        return null;
    }

    @Override
    public IShare create(IShare share) {
        IShareRecord iShareRecord = context.newRecord(I_SHARE, share);
        iShareRecord.store();
        return iShareRecord.into(IShare.class);
    }

    @Override
    public IShare update(Long shareId, IShare share) {
        return null;
    }

    @Override
    public Integer queryCount(Long classId) {
        ArrayList<Condition> conditions = new ArrayList<>();
        if (classId != null) {
            conditions.add(I_STUDENT.CLASS_ID.eq(classId));
        }
        return context.selectCount().from(I_SHARE)
                .leftJoin(I_STUDENT)
                .on(I_STUDENT.ID.eq(I_SHARE.STUDENT_ID))
                .where(conditions)
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public List<IShareExtra> query(Long classId, Integer offset, Integer size) {
        ArrayList<Condition> conditions = new ArrayList<>();
        if (classId != null) {
            conditions.add(I_STUDENT.CLASS_ID.eq(classId));
        }
        return context.select(I_SHARE.fields())
                .select(I_USER.NICK_NAME.as("upload_user_name"))
                .select(I_USER.AVATAR_URL.as("upload_user_avatar_url"))
                .select(I_STUDENT.NAME.as("student_name"))
                .select(I_CLASS.NAME.as("student_class_name"))
                .select(I_GRADE.NAME.as("student_grade_name"))
                .select(I_ITEM.TITLE.as("item_title"))
                .select(I_ITEM.COVER_URL.as("item_cover_url"))
                .from(I_SHARE)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_SHARE.UPLOAD_USER_ID))
                .leftJoin(I_STUDENT)
                .on(I_STUDENT.ID.eq(I_SHARE.STUDENT_ID))
                .leftJoin(I_ITEM)
                .on(I_ITEM.ID.eq(I_SHARE.ITEM_ID))
                .leftJoin(I_CLASS)
                .on(I_STUDENT.CLASS_ID.eq(I_CLASS.ID))
                .leftJoin(I_GRADE)
                .on(I_GRADE.ID.eq(I_CLASS.GRADE_ID))
                .where(conditions)
                .orderBy(I_ITEM.CREATED_AT.desc())
                .offset(offset)
                .limit(size)
                .fetch()
                .into(IShareExtra.class);
    }

    @Override
    public List<IShareExtra> popularByItemId(Long itemId, Integer offset, Integer size) {
        return context.select(context.selectCount()
                .from(I_SHARE_LIKE)
                .where(I_SHARE_LIKE.SHARE_ID.eq(I_SHARE.ID))
                .asField()
                .add(context.selectCount()
                        .from(I_SHARE_COMMENT)
                        .where(I_SHARE_COMMENT.SHARE_ID.eq(I_SHARE.ID))
                        .asField())
                .as("count"))
                .select(I_SHARE.fields())
                .select(I_USER.NICK_NAME.as("upload_user_name"))
                .select(I_USER.AVATAR_URL.as("upload_user_avatar_url"))
                .select(I_STUDENT.NAME.as("student_name"))
                .select(I_CLASS.NAME.as("student_class_name"))
                .select(I_GRADE.NAME.as("student_grade_name"))
                .select(I_ITEM.TITLE.as("item_title"))
                .select(I_ITEM.COVER_URL.as("item_cover_url"))
                .from(I_SHARE)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_SHARE.UPLOAD_USER_ID))
                .leftJoin(I_STUDENT)
                .on(I_STUDENT.ID.eq(I_SHARE.STUDENT_ID))
                .leftJoin(I_ITEM)
                .on(I_ITEM.ID.eq(I_SHARE.ITEM_ID))
                .leftJoin(I_CLASS)
                .on(I_STUDENT.CLASS_ID.eq(I_CLASS.ID))
                .leftJoin(I_GRADE)
                .on(I_GRADE.ID.eq(I_CLASS.GRADE_ID))
                .where(I_SHARE.ITEM_ID.eq(itemId))
                .orderBy(field(name("count")).desc())
                .offset(offset)
                .limit(size)
                .fetch()
                .into(IShareExtra.class);
    }
}
