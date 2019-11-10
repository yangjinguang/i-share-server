package com.pingyueryou.ishare.entity;

public enum ItemLendOrderStatus {
    NEW(1),
    AGREE(2),
    REJECT(3),
    CANCELED(4),
    IN_RETURN(5),
    RETURNED(6),
    OVERDUE(7),
    DELETED(8);
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
