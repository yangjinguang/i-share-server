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
public class IIdAuthOrder implements Serializable {

    private static final long serialVersionUID = -1524504371;

    private Long      id;
    private Long      userId;
    private Integer   role;
    private Long      classId;
    private String    childName;
    private String    relation;
    private Integer   status;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public IIdAuthOrder() {}

    public IIdAuthOrder(IIdAuthOrder value) {
        this.id = value.id;
        this.userId = value.userId;
        this.role = value.role;
        this.classId = value.classId;
        this.childName = value.childName;
        this.relation = value.relation;
        this.status = value.status;
        this.createdAt = value.createdAt;
        this.updatedAt = value.updatedAt;
    }

    public IIdAuthOrder(
        Long      id,
        Long      userId,
        Integer   role,
        Long      classId,
        String    childName,
        String    relation,
        Integer   status,
        Timestamp createdAt,
        Timestamp updatedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.role = role;
        this.classId = classId;
        this.childName = childName;
        this.relation = relation;
        this.status = status;
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

    public Integer getRole() {
        return this.role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Long getClassId() {
        return this.classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getChildName() {
        return this.childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getRelation() {
        return this.relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        StringBuilder sb = new StringBuilder("IIdAuthOrder (");

        sb.append(id);
        sb.append(", ").append(userId);
        sb.append(", ").append(role);
        sb.append(", ").append(classId);
        sb.append(", ").append(childName);
        sb.append(", ").append(relation);
        sb.append(", ").append(status);
        sb.append(", ").append(createdAt);
        sb.append(", ").append(updatedAt);

        sb.append(")");
        return sb.toString();
    }
}
