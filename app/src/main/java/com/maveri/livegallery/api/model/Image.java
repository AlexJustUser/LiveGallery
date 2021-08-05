package com.maveri.livegallery.api.model;

public class Image {
    private String url;
    private String width;
    private String height;
    private String size;
    private String mp4;
    private String mp4_size;
    private String webp;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMp4(String mp4) {
        this.mp4 = mp4;
    }

    public void setMp4_size(String mp4_size) {
        this.mp4_size = mp4_size;
    }

    public void setWebp(String webp) {
        this.webp = webp;
    }

    public void setWebp_size(String webp_size) {
        this.webp_size = webp_size;
    }

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public String getSize() {
        return size;
    }

    public String getMp4() {
        return mp4;
    }

    public String getMp4_size() {
        return mp4_size;
    }

    public String getWebp() {
        return webp;
    }

    public String getWebp_size() {
        return webp_size;
    }

    private String webp_size;
}
