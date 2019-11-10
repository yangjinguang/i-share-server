package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IShareLikeDbService;
import com.pingyueryou.ishare.entity.IShareLikeExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareLike;
import com.pingyueryou.ishare.jooq.tables.records.IShareLikeRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IShareLike.I_SHARE_LIKE;
import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

@Service
public class IShareLikeDbServiceImpl implements IShareLikeDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IShareLike create(IShareLike like) {
        IShareLikeRecord iShareLikeRecord = context.newRecord(I_SHARE_LIKE, like);
        iShareLikeRecord.store();
        return iShareLikeRecord.into(IShareLike.class);
    }

    @Override
    public void deleteByUserIdAndShareId(Long userId, Long shareId) {
        context.deleteFrom(I_SHARE_LIKE)
                .where(I_SHARE_LIKE.USER_ID.eq(userId))
                .and(I_SHARE_LIKE.SHARE_ID.eq(shareId))
                .execute();
    }

    @Override
    public List<IShareLikeExtra> getByShareId(Long shareId) {
        return context.select(I_SHARE_LIKE.fields())
                .select(I_USER.NICK_NAME.as("user_name"))
                .from(I_SHARE_LIKE)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_SHARE_LIKE.USER_ID))
                .where(I_SHARE_LIKE.SHARE_ID.eq(shareId))
                .fetch()
                .into(IShareLikeExtra.class);
    }
}
