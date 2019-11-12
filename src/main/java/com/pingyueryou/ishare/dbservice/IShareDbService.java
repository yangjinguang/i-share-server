package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IShareExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;

import java.util.List;

public interface IShareDbService {
    IShareExtra get(Long shareId);

    IShare create(IShare share);

    IShare update(Long shareId, IShare share);

    Integer queryCount(Long classId);

    List<IShareExtra> query(Long classId, Integer offset, Integer size);

    List<IShareExtra> popularByItemId(Long itemId, Integer offset, Integer size);
}
