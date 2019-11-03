package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;

import java.util.List;

public interface IItemDbService {
    IItem create(IItem item);

    IItemTag createTag(IItemTag tag);

    Integer countTags();

    List<IItemTag> getTags();

    IItemTag getTag(Long tagId);

    IItemTag updateTag(Long tagId, IItemTag tag);

    void deleteTag(Long tagId);
}
