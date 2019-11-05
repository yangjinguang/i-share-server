package com.pingyueryou.ishare.service;

import com.pingyueryou.ishare.entity.IItemExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;

import java.util.List;

public interface ItemService {
    void serialize(List<IItem> items);

    IItemExtra detail(Long itemId);
}
