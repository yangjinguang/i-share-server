package com.pingyueryou.ishare.entity;

public enum IdAuthOrderStatus {
    NEW(1),
    AGREE(2),
    REJECT(3),
    CANCELED(4);
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
