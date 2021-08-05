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
    private String title;

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBitly_url(String bitly_url) {
        this.bitly_url = bitly_url;
    }

    public void setEmbed_url(String embed_url) {
        this.embed_url = embed_url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setSource_tld(String source_tld) {
        this.source_tld = source_tld;
    }

    public void setSource_post_url(String source_post_url) {
        this.source_post_url = source_post_url;
    }

    public void setUpdate_datetime(String update_datetime) {
        this.update_datetime = update_datetime;
    }

    public void setCreate_datetime(String create_datetime) {
        this.create_datetime = create_datetime;
    }

    public void setImport_datetime(String import_datetime) {
        this.import_datetime = import_datetime;
    }

    public void setTrending_datetime(String trending_datetime) {
        this.trending_datetime = trending_datetime;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getUrl() {
        return url;
    }

    public String getBitly_url() {
        return bitly_url;
    }

    public String getEmbed_url() {
        return embed_url;
    }

    public String getUsername() {
        return username;
    }

    public String getSource() {
        return source;
    }

    public String getRating() {
        return rating;
    }

    public String getContent_url() {
        return content_url;
    }

    public User getUser() {
        return user;
    }

    public String getSource_tld() {
        return source_tld;
    }

    public String getSource_post_url() {
        return source_post_url;
    }

    public String getUpdate_datetime() {
        return update_datetime;
    }

    public String getCreate_datetime() {
        return create_datetime;
    }

    public String getImport_datetime() {
        return import_datetime;
    }

    public String getTrending_datetime() {
        return trending_datetime;
    }

    public Image getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }
}
