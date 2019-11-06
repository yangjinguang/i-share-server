package com.pingyueryou.ishare.entity;

public class ItemLendOrderBody {
    private Long itemId;
    private Long studentId;

    public ItemLendOrderBody() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
