package com.maveri.livegallery.api.model;

public class Pagination {
    Integer offset;
    Integer total_count;
    Integer count;

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public Integer getCount() {
        return count;
    }
}
