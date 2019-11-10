package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.dbservice.IShareDbService;
import com.pingyueryou.ishare.dbservice.IShareMediaDbService;
import com.pingyueryou.ishare.entity.IShareExtra;
import com.pingyueryou.ishare.entity.Pagination;
import com.pingyueryou.ishare.entity.PaginationList;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;
import com.pingyueryou.ishare.service.QiniuClient;
import com.pingyueryou.ishare.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private IShareDbService iShareDbService;
    @Autowired
    private IShareMediaDbService iShareMediaDbService;
    @Autowired
    private QiniuClient qiniuClient;

    @Override
    public PaginationList<IShareExtra> query(Long classId, Integer page, Integer size) {
        Integer total = iShareDbService.queryCount(classId);
        List<IShareExtra> query = iShareDbService.query(classId, page - 1, size);
        for (IShareExtra share : query) {
            share.setItemCoverUrl(qiniuClient.downloadUrl(share.getItemCoverUrl()));
            Long mediaId = share.getMediaId();
            IShareMedia media = iShareMediaDbService.get(mediaId);
            media.setPath(qiniuClient.downloadUrl(media.getPath()));
            share.setMedia(media);
        }
        PaginationList<IShareExtra> list = new PaginationList<>();
        list.setPagination(new Pagination(total, page, size));
        list.setList(query);
        return list;
    }

    @Override
    public IShare create(Long itemId, Long studentId, Long userId, IShareMedia media, String desc) {
        IShareMedia iShareMedia = iShareMediaDbService.create(media);
        IShare iShare = new IShare();
        iShare.setUploadUserId(userId);
        iShare.setItemId(itemId);
        iShare.setStudentId(studentId);
        iShare.setMediaId(iShareMedia.getId());
        iShare.setDesc(desc);
        return iShareDbService.create(iShare);
    }
}
