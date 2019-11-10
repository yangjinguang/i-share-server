package com.pingyueryou.ishare.entity;


import com.pingyueryou.ishare.jooq.tables.pojos.IShare;
import com.pingyueryou.ishare.jooq.tables.pojos.IShareMedia;

public class IShareExtra extends IShare {
    private String uploadUserName;
    private String uploadUserAvatarUrl;
    private String studentName;
    private String studentGradeName;
    private String studentClassName;
    private String itemTitle;
    private String itemCoverUrl;
    private IShareMedia media;

    public IShareExtra() {
    }

    public IShareExtra(IShare value) {
        super(value);
    }

    public String getUploadUserName() {
        return uploadUserName;
    }

    public void setUploadUserName(String uploadUserName) {
        this.uploadUserName = uploadUserName;
    }

    public String getUploadUserAvatarUrl() {
        return uploadUserAvatarUrl;
    }

    public void setUploadUserAvatarUrl(String uploadUserAvatarUrl) {
        this.uploadUserAvatarUrl = uploadUserAvatarUrl;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGradeName() {
        return studentGradeName;
    }

    public void setStudentGradeName(String studentGradeName) {
        this.studentGradeName = studentGradeName;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemCoverUrl() {
        return itemCoverUrl;
    }

    public void setItemCoverUrl(String itemCoverUrl) {
        this.itemCoverUrl = itemCoverUrl;
    }

    public IShareMedia getMedia() {
        return media;
    }

    public void setMedia(IShareMedia media) {
        this.media = media;
    }
}
