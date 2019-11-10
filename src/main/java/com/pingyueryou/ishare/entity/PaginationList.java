package com.pingyueryou.ishare.entity;

import java.util.List;

public class PaginationList<T> {
    private Pagination pagination;
    private List<T> list;

    public PaginationList() {
    }

    public PaginationList(Pagination pagination, List<T> list) {
        this.pagination = pagination;
        this.list = list;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
