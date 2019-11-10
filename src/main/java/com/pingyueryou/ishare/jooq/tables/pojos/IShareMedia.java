/*
 * This file is generated by jOOQ.
*/
package com.pingyueryou.ishare.jooq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IShareMedia implements Serializable {

    private static final long serialVersionUID = 473023032;

    private Long      id;
    private String    path;
    private Integer   duration;
    private Integer   size;
    private Integer   width;
    private Integer   height;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public IShareMedia() {}

    public IShareMedia(IShareMedia value) {
        this.id = value.id;
        this.path = value.path;
        this.duration = value.duration;
        this.size = value.size;
        this.width = value.width;
        this.height = value.height;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public IShareMedia(
        Long      id,
        String    path,
        Integer   duration,
        Integer   size,
        Integer   width,
        Integer   height,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.path = path;
        this.duration = duration;
        this.size = size;
        this.width = width;
        this.height = height;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IShareMedia (");

        sb.append(id);
        sb.append(", ").append(path);
        sb.append(", ").append(duration);
        sb.append(", ").append(size);
        sb.append(", ").append(width);
        sb.append(", ").append(height);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
