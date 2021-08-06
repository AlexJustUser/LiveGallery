package com.maveri.livegallery.db.model;

import com.maveri.livegallery.api.model.Gif;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GifRealmModel extends RealmObject {

    @PrimaryKey
    private long id;
    private String gifUrl;

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}