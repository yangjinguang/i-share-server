package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IGrade;

import java.util.List;

public class IGradeExtra extends IGrade {
    private List<IClass> classes;

    public IGradeExtra() {
    }

    public IGradeExtra(IGrade value) {
        super(value);
    }

    public IGradeExtra(IGrade value, List<IClass> classes) {
        super(value);
        this.classes = classes;
    }

    public List<IClass> getClasses() {
        return classes;
    }

    public void setClasses(List<IClass> classes) {
        this.classes = classes;
    }
}
