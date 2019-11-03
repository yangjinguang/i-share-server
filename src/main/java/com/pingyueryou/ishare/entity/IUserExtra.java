package com.pingyueryou.ishare.entity;

import com.pingyueryou.ishare.jooq.tables.pojos.IClass;
import com.pingyueryou.ishare.jooq.tables.pojos.IUser;

import java.util.List;

public class IUserExtra extends IUser {
    private List<Integer> roles;
    private List<IClass> classes;

    public IUserExtra() {
    }

    public IUserExtra(IUser value) {
        super(value);
    }

    public IUserExtra(IUser value, List<Integer> roles) {
        super(value);
        this.roles = roles;
    }

    public List<Integer> getRoles() {
        return roles;
    }

    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }

    public List<IClass> getClasses() {
        return classes;
    }

    public void setClasses(List<IClass> classes) {
        this.classes = classes;
    }

    public boolean isAdmin() {
        for (Integer role : this.roles) {
            if (role.equals(Role.ADMIN.getIndex())) {
                return true;
            }
        }
        return false;
    }

    public boolean isTeacher() {
        for (Integer role : this.roles) {
            if (role.equals(Role.TEACHER.getIndex())) {
                return true;
            }
        }
        return false;
    }

    public boolean isParent() {
        for (Integer role : this.roles) {
            if (role.equals(Role.PARENT.getIndex())) {
                return true;
            }
        }
        return false;
    }
}
