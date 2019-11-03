package com.pingyueryou.ishare.dbservice.impl;

import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;
import com.pingyueryou.ishare.jooq.tables.records.IItemRecord;
import com.pingyueryou.ishare.jooq.tables.records.IItemTagRecord;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.jooq.DSLContext;
import org.jooq.exception.NoDataFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pingyueryou.ishare.jooq.tables.IItem.I_ITEM;
import static com.pingyueryou.ishare.jooq.tables.IItemTag.I_ITEM_TAG;

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

    @Override
    public IItemTag createTag(IItemTag tag) {
        IItemTagRecord iItemTagRecord = context.newRecord(I_ITEM_TAG, tag);
        iItemTagRecord.store();
        return iItemTagRecord.into(IItemTag.class);
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
}
