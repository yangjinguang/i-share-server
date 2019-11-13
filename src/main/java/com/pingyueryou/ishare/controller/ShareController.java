package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IShareDbService;
import com.pingyueryou.ishare.entity.*;
import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;
import com.pingyueryou.ishare.service.ShareService;
import com.pingyueryou.ishare.service.UserService;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/share")
public class ShareController {
    @Autowired
    private UserService userService;
    @Autowired
    private IShareDbService iShareDbService;
    @Autowired
    private ShareService shareService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity query(@RequestParam(value = "classId", required = false) Long classId,
                                @RequestParam(value = "userId", required = false) Long userId,
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "20") Integer size) {
        PaginationList<IShareExtra> query = shareService.query(classId, userId, page, size);
        return XResponse.ok(query);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody ShareCreateBody body) {
        IUserExtra currentUser = userService.getCurrentUser();
        Long userId = currentUser.getId();
        Long studentId = body.getStudentId();
        Long itemId = body.getItemId();
        if (userId == null || studentId == null || itemId == null) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IShareMedia media = body.getMedia();
        String path = media.getPath();
        if (XStringUtils.isEmpty(path)) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IShare iShare = shareService.create(itemId, studentId, userId, media, body.getDesc());
        return XResponse.ok(iShare);
    }

    @RequestMapping(path = "{shareId}", method = RequestMethod.GET)
    public ResponseEntity detail(@PathVariable(value = "shareId") Long shareId) {
        IShareExtra detail = shareService.detail(shareId);
        return XResponse.ok(detail);
    }

    @RequestMapping(path = "{shareId}/like", method = RequestMethod.PUT)
    public ResponseEntity like(@PathVariable(value = "shareId") Long shareId) {
        IUserExtra currentUser = userService.getCurrentUser();
        shareService.like(shareId, currentUser.getId());
        return XResponse.ok("success");
    }

    @RequestMapping(path = "{shareId}/like", method = RequestMethod.GET)
    public ResponseEntity getLikes(@PathVariable(value = "shareId") Long shareId) {
        List<IShareLikeExtra> likes = shareService.getLike(shareId);
        return XResponse.ok(likes);
    }

    @RequestMapping(path = "{shareId}/comment", method = RequestMethod.PUT)
    public ResponseEntity comment(@PathVariable(value = "shareId") Long shareId, @RequestBody ShareCommentBody body) {
        IUserExtra currentUser = userService.getCurrentUser();
        shareService.comment(shareId, currentUser.getId(), body.getComment());
        return XResponse.ok("success");
    }

    @RequestMapping(path = "{shareId}/comment", method = RequestMethod.GET)
    public ResponseEntity getComments(@PathVariable(value = "shareId") Long shareId) {
        List<IShareCommentExtra> comments = shareService.getComment(shareId);
        return XResponse.ok(comments);
    }
}
