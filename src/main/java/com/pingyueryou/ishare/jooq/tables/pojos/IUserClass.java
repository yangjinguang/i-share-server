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
public class IUserClass implements Serializable {

    private static final long serialVersionUID = -1925016954;

    private Long      id;
    private Long      userId;
    private Long      classId;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public IUserClass() {}

    public IUserClass(IUserClass value) {
        this.id = value.id;
        this.userId = value.userId;
        this.classId = value.classId;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public IUserClass(
        Long      id,
        Long      userId,
        Long      classId,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.classId = classId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClassId() {
        return this.classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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
        StringBuilder sb = new StringBuilder("IUserClass (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(classId);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
