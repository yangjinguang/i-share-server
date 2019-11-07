package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IItem;
import com.pingyueryou.ishare.jooq.tables.pojos.IItemLendOrder;
import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;

public class IItemLendOrderExtra extends IItemLendOrder {
    private String userName;
    private IItemExtra iItem;
    private IClassExtra iClass;
    private IStudent iStudent;
    private IClassExtra studentClass;

    public IItemLendOrderExtra() {
    }

    public IItemLendOrderExtra(IItemLendOrder value) {
        super(value);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public IItemExtra getiItem() {
        return iItem;
    }

    public void setiItem(IItemExtra iItem) {
        this.iItem = iItem;
    }

    public IClassExtra getiClass() {
        return iClass;
    }

    public void setiClass(IClassExtra iClass) {
        this.iClass = iClass;
    }

    public IStudent getiStudent() {
        return iStudent;
    }

    public void setiStudent(IStudent iStudent) {
        this.iStudent = iStudent;
    }

    public IClassExtra getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(IClassExtra studentClass) {
        this.studentClass = studentClass;
    }
}
