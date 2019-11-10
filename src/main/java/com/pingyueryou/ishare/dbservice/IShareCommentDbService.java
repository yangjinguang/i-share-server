package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IShareCommentExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareComment;

import java.util.List;

public interface IShareCommentDbService {
    IShareComment create(IShareComment comment);

    List<IShareCommentExtra> getByShareId(Long shareId);

    void delete(Long commentId);

}
