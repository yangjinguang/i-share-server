package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IStudent;

public class IStudentExtra extends IStudent {
    private String className;
    private String gradeName;

    public IStudentExtra() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
