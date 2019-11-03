package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.dbservice.IItemDbService;
import com.pingyueryou.ishare.entity.Pagination;
import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;
import com.pingyueryou.ishare.utils.ErrorCode;
import com.pingyueryou.ishare.utils.XResponse;
import com.pingyueryou.ishare.utils.XStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private IItemDbService iItemDbService;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody IItem item) {
        return XResponse.ok("success");
    }

    @RequestMapping(path = "/tag", method = RequestMethod.POST)
    public ResponseEntity createTag(@RequestBody IItemTag tag) {
        String name = tag.getName();
        if (XStringUtils.isEmpty(name)) {
            return XResponse.errorCode(ErrorCode.PARAM_ERROR);
        }
        IItemTag tag1 = iItemDbService.createTag(tag);
        return XResponse.ok(tag1);
    }

    @RequestMapping(path = "/tag", method = RequestMethod.GET)
    public ResponseEntity getTags() {
        List<IItemTag> tags = iItemDbService.getTags();
        return XResponse.ok(tags);
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.GET)
    public ResponseEntity getTag(@PathVariable(value = "tagId") Long tagId) {
        IItemTag tag = iItemDbService.getTag(tagId);
        return XResponse.ok(tag);
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.PUT)
    public ResponseEntity updateTag(@PathVariable(value = "tagId") Long tagId,
                                    @RequestBody IItemTag tag) {
        IItemTag iItemTag = iItemDbService.updateTag(tagId, tag);
        return XResponse.ok(iItemTag);
    }

    @RequestMapping(path = "/tag/{tagId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTag(@PathVariable(value = "tagId") Long tagId) {
        iItemDbService.deleteTag(tagId);
        return XResponse.ok("success");
    }
}
