package com.maveri.livegallery.api.model;

public class User {

    private String avatar_url;
    private String banner_url;
    private String profile_url;
    private String username;

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    private String display_name;


}