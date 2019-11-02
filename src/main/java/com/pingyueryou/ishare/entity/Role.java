package com.pingyueryou.ishare.entity;

public enum Role {
    NORMAL(1, "游客"),
    ADMIN(2, "管理员"),
    TEACHER(3, "教师"),
    PARENT(4, "家长");
    private int index;
    private String desc;

    Role(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public static Role of(int index) {
        for (Role value : Role.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
