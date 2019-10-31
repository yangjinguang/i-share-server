package com.pingyueryou.ishare.entity;

public enum Gender {
    MALE(1),
    FEMALE(2);
    private int index;

    Gender(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static Gender of(int index) {
        for (Gender value : Gender.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
