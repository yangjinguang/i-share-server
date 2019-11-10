package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.entity.IItemExtra;
import com.pingyueryou.ishare.entity.IItemLendOrderExtra;
import com.pingyueryou.ishare.entity.PaginationList;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;

import java.util.List;

public interface ItemService {
    void serialize(List<IItem> items);

    IItemExtra detail(Long itemId);

    void lendOrder(Long itemId, Long userId, Long studentId);

    PaginationList<IItemLendOrderExtra> getLendOrdersByUserId(Long userId, List<Integer> statusList, Integer offset, Integer size);

    void lendOrderHandle(Long orderId, boolean agree);
}
