package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.entity.IShareExtra;
import com.pingyueryou.ishare.entity.PaginationList;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;

public interface ShareService {
    PaginationList<IShareExtra> query(Long classId, Integer page, Integer size);

    IShare create(Long itemId, Long studentId, Long userId, IShareMedia media, String desc);
}
