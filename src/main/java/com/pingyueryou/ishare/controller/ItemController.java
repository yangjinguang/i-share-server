package com.pingyueryou.ishare.controller;

import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.utils.XResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody IItem item) {
        return XResponse.ok("success");
    }
}
