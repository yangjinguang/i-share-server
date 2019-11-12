package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.dbservice.IClassDbService;
import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.dbservice.IItemLendOrderDbService;
import com.pingyueryou.ishare.entity.*;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;
import com.pingyueryou.ishare.service.ItemService;
import com.pingyueryou.ishare.service.QiniuClient;
import com.pingyueryou.ishare.service.ShareService;
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
    @Autowired
    private IItemLendOrderDbService iItemLendOrderDbService;
    @Autowired
    private ShareService shareService;

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
        iItem.setiClass(iClassDbService.get(iItem.getClassId()));
        iItem.setTags(iItemDbService.getTagsByItemId(iItem.getId()));
        iItem.setPopularShares(shareService.popularByItemId(itemId));
        return iItem;
    }

    @Override
    public void lendOrder(Long itemId, Long userId, Long studentId) {
        IItemExtra item = iItemDbService.get(itemId);
        IItemLendOrder order = new IItemLendOrder();
        order.setItemId(itemId);
        order.setUserId(userId);
        order.setClassId(item.getClassId());
        order.setStudentId(studentId);
        iItemLendOrderDbService.create(order);
        iItemDbService.changeStatus(itemId, ItemStatus.IN_LEND);
    }

    @Override
    public PaginationList<IItemLendOrderExtra> getLendOrdersByUserId(Long userId, List<Integer> statusList, Integer page, Integer size) {
        Integer offset = page - 1;
        Integer total = iItemLendOrderDbService.countByUserId(userId, statusList);
        List<IItemLendOrderExtra> orders = iItemLendOrderDbService.queryByUserId(userId, statusList, offset, size);
        for (IItemLendOrderExtra order : orders) {
            order.setItemCoverUrl(qiniuClient.downloadUrl(order.getItemCoverUrl()));
        }
        PaginationList<IItemLendOrderExtra> paginationList = new PaginationList<>();
        paginationList.setPagination(new Pagination(total, page, size));
        paginationList.setList(orders);
        return paginationList;
    }

    @Override
    public void lendOrderHandle(Long orderId, boolean agree) {
        IItemLendOrderExtra order = iItemLendOrderDbService.get(orderId);
        Integer status = order.getStatus();
        if (status.equals(ItemLendOrderStatus.NEW.getIndex())) {
            iItemLendOrderDbService.changeStatus(orderId, agree ? ItemLendOrderStatus.AGREE : ItemLendOrderStatus.REJECT);
            if (agree) {
                iItemDbService.changeStatus(order.getItemId(), ItemStatus.LEND);
            }
        } else if (status.equals(ItemLendOrderStatus.IN_RETURN.getIndex())) {
            iItemLendOrderDbService.changeStatus(orderId, agree ? ItemLendOrderStatus.RETURNED : ItemLendOrderStatus.IN_RETURN);
            if (agree) {
                iItemDbService.changeStatus(order.getItemId(), ItemStatus.NORMAL);
            }
        }
    }
}
