package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemTag;

import java.util.List;

public class IItemExtra extends IItem {
    private String uploadUserName;
    private IClassExtra iClass;
    private List<IItemTag> tags;

    public IItemExtra() {
    }

    public IItemExtra(IItem value) {
        super(value);
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    public IClassExtra getiClass() {
        return iClass;
    }

    public void setiClass(IClassExtra iClass) {
        this.iClass = iClass;
    }

    public List<IItemTag> getTags() {
        return tags;
    }

    public void setTags(List<IItemTag> tags) {
        this.tags = tags;
    }
}
