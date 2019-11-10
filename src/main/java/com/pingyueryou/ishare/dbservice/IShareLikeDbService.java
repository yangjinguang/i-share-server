package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IShareLikeExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareLike;

import java.util.List;

public interface IShareLikeDbService {
    IShareLike create(IShareLike like);

    void deleteByUserIdAndShareId(Long userId, Long shareId);

    List<IShareLikeExtra> getByShareId(Long shareId);
}
