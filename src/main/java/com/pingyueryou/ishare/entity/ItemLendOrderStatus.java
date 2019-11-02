package com.pingyueryou.ishare.entity;

public enum ItemLendOrderStatus {
    NEW(0),
    AGREE(1),
    REJECT(2),
    CANCELED(3);
    private int index;

    ItemLendOrderStatus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static ItemLendOrderStatus of(int index) {
        for (ItemLendOrderStatus value : ItemLendOrderStatus.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
