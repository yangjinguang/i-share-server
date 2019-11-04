package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IItem;

import java.util.List;

public class IItemCreateData extends IItem {
    private List<Long> tagIds;

    public IItemCreateData() {
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }
}
