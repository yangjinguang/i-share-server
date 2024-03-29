package com.pingyueryou.ishare.dbservice;

import com.pingyueryou.ishare.entity.IItemCreateData;
import com.pingyueryou.ishare.entity.IItemExtra;
import com.pingyueryou.ishare.entity.ItemStatus;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;

import java.util.List;

public interface IItemDbService {
    IItem create(IItem item);

    IItem create(IItemCreateData createData);

    IItem update(Long itemId, IItemCreateData createData);

    void delete(Long itemId);

    IItemTag createTag(IItemTag tag);

    void bindTags(Long itemId, List<Long> tagIds);

    Integer countTags();

    List<IItemTag> getTags();

    List<IItemTag> getTagsByItemId(Long itemId);

    IItemTag getTag(Long tagId);

    IItemTag updateTag(Long tagId, IItemTag tag);

    void deleteTag(Long tagId);

    Integer count(List<Long> classIds, Long tag);

    List<IItem> query(List<Long> classIds, Long tag, Integer offset, Integer size);

    IItemExtra get(Long itemId);

    List<IItem> search(String s);

    void changeStatus(Long itemId, ItemStatus status);
}
