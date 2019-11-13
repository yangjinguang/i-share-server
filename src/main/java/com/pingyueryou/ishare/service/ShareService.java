package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.entity.IShareCommentExtra;
import com.pingyueryou.ishare.entity.IShareExtra;
import com.pingyueryou.ishare.entity.IShareLikeExtra;
import com.pingyueryou.ishare.entity.PaginationList;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;

import java.util.List;

public interface ShareService {
    IShareExtra detail(Long shareId);
    PaginationList<IShareExtra> query(Long classId,Long userId, Integer page, Integer size);

    IShare create(Long itemId, Long studentId, Long userId, IShareMedia media, String desc);

    void like(Long shareId, Long userId);

    List<IShareLikeExtra> getLike(Long shareId);

    void comment(Long shareId, Long userId, String comment);

    List<IShareCommentExtra> getComment(Long shareId);

    List<IShareExtra> popularByItemId(Long itemId);
}
