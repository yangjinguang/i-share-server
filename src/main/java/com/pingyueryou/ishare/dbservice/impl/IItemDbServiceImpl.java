package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.entity.IItemCreateData;
import com.pingyueryou.ishare.entity.IItemExtra;
import com.pingyueryou.ishare.entity.ItemStatus;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTagItem;
import com.pingyueryou.ishare.jooq.tables.records.IItemRecord;
import com.pingyueryou.ishare.jooq.tables.records.IItemTagRecord;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IItem.I_ITEM;
import static com.pingyueryou.ishare.jooq.tables.IItemTag.I_ITEM_TAG;
import static com.pingyueryou.ishare.jooq.tables.IItemTagItem.I_ITEM_TAG_ITEM;
import static com.pingyueryou.ishare.jooq.tables.IUser.I_USER;

@Service
public class IItemDbServiceImpl implements IItemDbService {
    @Autowired
    private DSLContext context;

    @Override
    public IItem create(IItem item) {
        IItemRecord iItemRecord = context.newRecord(I_ITEM, item);
        iItemRecord.store();
        return iItemRecord.into(IItem.class);
    }

    private IItem iItemGen(IItemCreateData createData) {
        IItem iItem = new IItem();
        iItem.setClassId(createData.getClassId());
        iItem.setCoverUrl(createData.getCoverUrl());
        iItem.setDesc(createData.getDesc());
        iItem.setTitle(createData.getTitle());
        iItem.setType(createData.getType());
        iItem.setUploadUserId(createData.getUploadUserId());
        return iItem;
    }

    @Override
    public IItem create(IItemCreateData createData) {
        IItem iItem = iItemGen(createData);
        IItem iItem1 = create(iItem);
        bindTags(iItem1.getId(), createData.getTagIds());
        return null;
    }

    @Override
    public IItem update(Long itemId, IItemCreateData createData) {
        IItemRecord iItemRecord = context.selectFrom(I_ITEM)
                .where(I_ITEM.ID.eq(itemId))
                .fetchOptional()
                .orElseThrow(NoDataFoundException::new);
        Long classId = createData.getClassId();
        if (classId != null) {
            iItemRecord.setClassId(classId);
        }
        String title = createData.getTitle();
        if (!XStringUtils.isEmpty(title)) {
            iItemRecord.setTitle(title);
        }
        String coverUrl = createData.getCoverUrl();
        if (!XStringUtils.isEmpty(coverUrl)) {
            iItemRecord.setCoverUrl(coverUrl);
        }
        String desc = createData.getDesc();
        if (!XStringUtils.isEmpty(desc)) {
            iItemRecord.setDesc(desc);
        }
        Integer type = createData.getType();
        if (type != null) {
            iItemRecord.setType(type);
        }
        iItemRecord.update();
        clearTags(itemId);
        bindTags(itemId, createData.getTagIds());
        return null;
    }

    @Override
    public void delete(Long itemId) {
        context.deleteFrom(I_ITEM)
                .where(I_ITEM.ID.eq(itemId))
                .execute();
    }

    @Override
    public IItemTag createTag(IItemTag tag) {
        IItemTagRecord iItemTagRecord = context.newRecord(I_ITEM_TAG, tag);
        iItemTagRecord.store();
        return iItemTagRecord.into(IItemTag.class);
    }

    private void clearTags(Long itemId) {
        context.deleteFrom(I_ITEM_TAG_ITEM)
                .where(I_ITEM_TAG_ITEM.ITEM_ID.eq(itemId))
                .execute();
    }

    private void bindTag(Long itemId, Long tagId) {
        IItemTagItem iItemTagItem = new IItemTagItem();
        iItemTagItem.setItemId(itemId);
        iItemTagItem.setTagId(tagId);
        context.newRecord(I_ITEM_TAG_ITEM, iItemTagItem).store();
    }

    @Override
    public void bindTags(Long itemId, List<Long> tagIds) {
        if (tagIds == null) {
            return;
        }
        for (Long tagId : tagIds) {
            bindTag(itemId, tagId);
        }
    }

    @Override
    public Integer countTags() {
        return context.selectCount().from(I_ITEM_TAG)
                .fetchOne()
                .into(Integer.class);
    }

    @Override
    public List<IItemTag> getTags() {
        return context.selectFrom(I_ITEM_TAG)
                .fetch()
                .into(IItemTag.class);
    }

    @Override
    public List<IItemTag> getTagsByItemId(Long itemId) {
        return context.select(I_ITEM_TAG.fields())
                .from(I_ITEM_TAG_ITEM)
                .leftJoin(I_ITEM_TAG)
                .on(I_ITEM_TAG.ID.eq(I_ITEM_TAG_ITEM.TAG_ID))
                .where(I_ITEM_TAG_ITEM.ITEM_ID.eq(itemId))
                .fetch()
                .into(IItemTag.class);
    }

    @Override
    public IItemTag getTag(Long tagId) {
        IItemTagRecord iItemTagRecord = context.selectFrom(I_ITEM_TAG)
                .where(I_ITEM_TAG.ID.eq(tagId))
                .fetchOptional()
                .orElse(null);
        if (iItemTagRecord != null) {
            return iItemTagRecord.into(IItemTag.class);
        }
        return null;
    }

    @Override
    public IItemTag updateTag(Long tagId, IItemTag tag) {
        IItemTagRecord iItemTagRecord = context.selectFrom(I_ITEM_TAG)
                .where(I_ITEM_TAG.ID.eq(tagId))
                .fetchOptional()
                .orElseThrow(NoDataFoundException::new);
        String name = tag.getName();
        if (!XStringUtils.isEmpty(name)) {
            iItemTagRecord.setName(name);
        }
        iItemTagRecord.update();
        return iItemTagRecord.into(IItemTag.class);
    }

    @Override
    public void deleteTag(Long tagId) {
        context.deleteFrom(I_ITEM_TAG)
                .where(I_ITEM_TAG.ID.eq(tagId))
                .execute();
    }

    @Override
    public Integer count(List<Long> classIds, Long tagId) {
        ArrayList<Condition> conditions = new ArrayList<>();
        if (classIds != null) {
            conditions.add(I_ITEM.CLASS_ID.in(classIds));
        }
        if (tagId != null) {
            conditions.add(I_ITEM_TAG_ITEM.TAG_ID.eq(tagId));
            return context.selectCount()
                    .from(I_ITEM_TAG_ITEM)
                    .leftJoin(I_ITEM)
                    .on(I_ITEM.ID.eq(I_ITEM_TAG_ITEM.ITEM_ID))
                    .where(conditions)
                    .fetchOne()
                    .into(Integer.class);
        } else {
            return context.selectCount()
                    .from(I_ITEM)
                    .where(conditions)
                    .fetchOne()
                    .into(Integer.class);
        }
    }

    @Override
    public List<IItem> query(List<Long> classIds, Long tagId, Integer offset, Integer size) {
        ArrayList<Condition> conditions = new ArrayList<>();
        if (classIds != null) {
            conditions.add(I_ITEM.CLASS_ID.in(classIds));
        }
        if (tagId != null) {
            conditions.add(I_ITEM_TAG_ITEM.TAG_ID.eq(tagId));
            return context.select(I_ITEM.fields())
                    .from(I_ITEM_TAG_ITEM)
                    .leftJoin(I_ITEM)
                    .on(I_ITEM.ID.eq(I_ITEM_TAG_ITEM.ITEM_ID))
                    .where(conditions)
                    .offset(offset)
                    .limit(size)
                    .fetch()
                    .into(IItem.class);
        } else {
            return context.selectFrom(I_ITEM)
                    .where(conditions)
                    .offset(offset)
                    .limit(size)
                    .fetch()
                    .into(IItem.class);
        }
    }

    @Override
    public IItemExtra get(Long itemId) {
        Record iItemRecord = context.select(I_ITEM.fields())
                .select(I_USER.NICK_NAME.as("upload_user_name"))
                .from(I_ITEM)
                .leftJoin(I_USER)
                .on(I_USER.ID.eq(I_ITEM.UPLOAD_USER_ID))
                .where(I_ITEM.ID.eq(itemId))
                .fetchOptional()
                .orElse(null);
        if (iItemRecord != null) {
            return iItemRecord.into(IItemExtra.class);
        }
        return null;
    }

    @Override
    public List<IItem> search(String s) {
        return context.selectFrom(I_ITEM)
                .where(I_ITEM.TITLE.like("%" + s + "%"))
                .limit(20)
                .fetch()
                .into(IItem.class);
    }

    @Override
    public void changeStatus(Long itemId, ItemStatus status) {
        context.update(I_ITEM)
                .set(I_ITEM.STATUS, status.getIndex())
                .where(I_ITEM.ID.eq(itemId))
                .execute();
    }
}
