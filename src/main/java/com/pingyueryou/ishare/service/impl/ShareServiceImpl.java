package com.pingyueryou.ishare.service.impl;

import com.pingyueryou.ishare.dbservice.IShareCommentDbService;
import com.pingyueryou.ishare.dbservice.IShareDbService;
import com.pingyueryou.ishare.dbservice.IShareLikeDbService;
import com.pingyueryou.ishare.dbservice.IShareMediaDbService;
import com.pingyueryou.ishare.entity.*;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareComment;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareLike;
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
    @Autowired
    private IShareLikeDbService iShareLikeDbService;
    @Autowired
    private IShareCommentDbService iShareCommentDbService;


    private void shareExFill(IShareExtra share) {
        share.setItemCoverUrl(qiniuClient.downloadUrl(share.getItemCoverUrl()));
        Long mediaId = share.getMediaId();
        IShareMedia media = iShareMediaDbService.get(mediaId);
        media.setPath(qiniuClient.downloadUrl(media.getPath()));
        share.setMedia(media);
        List<IShareCommentExtra> comments = this.getComment(share.getId());
        List<IShareLikeExtra> likes = this.getLike(share.getId());
        share.setComments(comments);
        share.setLikes(likes);
    }

    @Override
    public IShareExtra detail(Long shareId) {
        IShareExtra share = iShareDbService.get(shareId);
        if (share != null) {
            shareExFill(share);
            return share;
        }
        return null;
    }

    @Override
    public PaginationList<IShareExtra> query(Long classId, Integer page, Integer size) {
        Integer total = iShareDbService.queryCount(classId);
        List<IShareExtra> query = iShareDbService.query(classId, page - 1, size);
        for (IShareExtra share : query) {
            shareExFill(share);
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

    @Override
    public void like(Long shareId, Long userId) {
        IShareLike like = new IShareLike();
        like.setShareId(shareId);
        like.setUserId(userId);
        iShareLikeDbService.create(like);
    }

    @Override
    public List<IShareLikeExtra> getLike(Long shareId) {
        return iShareLikeDbService.getByShareId(shareId);
    }

    @Override
    public void comment(Long shareId, Long userId, String comment) {
        IShareComment shareComment = new IShareComment();
        shareComment.setShareId(shareId);
        shareComment.setUserId(userId);
        shareComment.setComment(comment);
        iShareCommentDbService.create(shareComment);
    }

    @Override
    public List<IShareCommentExtra> getComment(Long shareId) {
        return iShareCommentDbService.getByShareId(shareId);
    }

    @Override
    public List<IShareExtra> popularByItemId(Long itemId) {
        List<IShareExtra> iShareExtras = iShareDbService.popularByItemId(itemId, 0, 10);
        for (IShareExtra iShareExtra : iShareExtras) {
            IShareMedia media = iShareMediaDbService.get(iShareExtra.getMediaId());
            media.setPath(qiniuClient.downloadUrl(media.getPath()));
            iShareExtra.setMedia(media);
        }
        return iShareExtras;
    }
}
