package com.maveri.livegallery.api.model;

import java.util.List;

public class Gif {

    private String type;
    private String id;
    private String slug;
    private String url;
    private String bitly_url;
    private String embed_url;
    private String username;
    private String source;
    private String rating;
    private String content_url;
    private User user;
    private String source_tld;
    private String source_post_url;
    private String update_datetime;
    private String create_datetime;
    private String import_datetime;
    private String trending_datetime;
    private Image images;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Image getImages() {
        return images;
    }
}
