package com.pingyueryou.ishare.entity;

public class Pagination {
    private Integer total;
    private Integer page;
    private Integer size;
    private boolean last;

    public Pagination() {
    }

    public Pagination(Integer total, Integer page, Integer size) {
        this.total = total;
        this.page = page;
        this.size = size;
        this.last = total <= 0 || total <= size || (page - 1) * size >= total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
