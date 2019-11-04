package com.pingyueryou.ishare.entity;

public enum ItemStatus {
    NORMAL(1),
    IN_LEND(2),
    LEND(3),
    IN_BACK(4),
    BACK(5),
    DISABLED(6);

    private int index;

    ItemStatus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static ItemStatus of(int index) {
        for (ItemStatus value : ItemStatus.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
