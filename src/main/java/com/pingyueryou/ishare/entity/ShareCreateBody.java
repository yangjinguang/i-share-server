package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;

public class ShareCreateBody {
    private Long itemId;
    private Long studentId;
    private IShareMedia media;
    private String desc;

    public ShareCreateBody() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public IShareMedia getMedia() {
        return media;
    }

    public void setMedia(IShareMedia media) {
        this.media = media;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
