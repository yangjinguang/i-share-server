package com.pingyueryou.ishare.entity;

public enum IdAuthOrderStatus {
    NEW(0),
    AGREE(1),
    REJECT(2),
    CANCELED(3);
    private int index;

    IdAuthOrderStatus(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public static IdAuthOrderStatus of(int index) {
        for (IdAuthOrderStatus value : IdAuthOrderStatus.values()) {
            if (value.getIndex() == index) {
                return value;
            }
        }
        return null;
    }
}
