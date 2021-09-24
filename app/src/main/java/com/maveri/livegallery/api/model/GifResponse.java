package com.maveri.livegallery.api.model;

public class GifResponse {

    private Gif[] data;
    private Pagination pagination;
    private Meta meta;

    public Gif[] getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
