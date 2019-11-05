package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.entity.IClassExtra;
import com.pingyueryou.ishare.entity.IItemExtra;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;
import com.pingyueryou.ishare.service.ItemService;
import com.pingyueryou.ishare.service.QiniuClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private IItemDbService iItemDbService;
    @Autowired
    private IClassDbService iClassDbService;
    @Autowired
    private QiniuClient qiniuClient;

    @Override
    public void serialize(List<IItem> items) {
        for (IItem item : items) {
            item.setCoverUrl(qiniuClient.downloadUrl(item.getCoverUrl()));
        }
    }

    @Override
    public IItemExtra detail(Long itemId) {
        IItemExtra iItem = iItemDbService.get(itemId);
        if (iItem == null) {
            return null;
        }
        iItem.setCoverUrl(qiniuClient.downloadUrl(iItem.getCoverUrl()));
        IClassExtra iClass = iClassDbService.get(iItem.getClassId());
        iItem.setiClass(iClass);
        List<IItemTag> tags = iItemDbService.getTagsByItemId(iItem.getId());
        iItem.setTags(tags);
        return iItem;
    }
}
