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
public class IItemTagItem implements Serializable {

    private static final long serialVersionUID = -529587292;

    private Long      id;
    private Long      itemId;
    private Long      tagId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public IItemTagItem() {}

    public IItemTagItem(IItemTagItem value) {
        this.id = value.id;
        this.itemId = value.itemId;
        this.tagId = value.tagId;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public IItemTagItem(
        Long      id,
        Long      itemId,
        Long      tagId,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.itemId = itemId;
        this.tagId = tagId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getTagId() {
        return this.tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
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
        StringBuilder sb = new StringBuilder("IItemTagItem (");

        sb.append(id);
        sb.append(", ").append(itemId);
        sb.append(", ").append(tagId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
