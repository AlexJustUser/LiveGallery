package com.maveri.livegallery.api.model;

public class GifResponse {

    private Gif[] data;
    private Pagination pagination;
    private Meta meta;

    public void setData(Gif[] data) {
        this.data = data;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Gif[] getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public Meta getMeta() {
        return meta;
    }

}
