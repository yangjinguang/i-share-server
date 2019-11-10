package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IShareDbService;
import com.pingyueryou.ishare.entity.IShareExtra;
import com.pingyueryou.ishare.entity.IUserExtra;
import com.pingyueryou.ishare.entity.PaginationList;
import com.pingyueryou.ishare.entity.ShareCreateBody;
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
                                @RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "20") Integer size) {
        PaginationList<IShareExtra> query = shareService.query(classId, page, size);
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
}
