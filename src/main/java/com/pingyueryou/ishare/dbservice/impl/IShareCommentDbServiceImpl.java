package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IShareCommentDbService;
import com.pingyueryou.ishare.entity.IShareCommentExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareComment;
import com.pingyueryou.ishare.jooq.tables.records.IShareCommentRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IShareComment.I_SHARE_COMMENT;
import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

@Service
public class IShareCommentDbServiceImpl implements IShareCommentDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IShareComment create(IShareComment comment) {
        IShareCommentRecord iShareCommentRecord = context.newRecord(I_SHARE_COMMENT, comment);
        iShareCommentRecord.store();
        return iShareCommentRecord.into(IShareComment.class);
    }

    @Override
    public List<IShareCommentExtra> getByShareId(Long shareId) {
        return context.select(I_SHARE_COMMENT.fields())
                .select(I_USER.NICK_NAME.as("user_name"))
                .from(I_SHARE_COMMENT)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_SHARE_COMMENT.USER_ID))
                .where(I_SHARE_COMMENT.SHARE_ID.eq(shareId))
                .fetch()
                .into(IShareCommentExtra.class);
    }

    @Override
    public void delete(Long commentId) {
        context.deleteFrom(I_SHARE_COMMENT)
                .where(I_SHARE_COMMENT.ID.eq(commentId))
                .execute();
    }
}
