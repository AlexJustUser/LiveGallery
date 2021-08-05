package com.maveri.livegallery.db.model;

import com.maveri.livegallery.api.model.Gif;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class GifRealmModel extends RealmObject {

    @PrimaryKey
    private long id;

    private Gif gif;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGif(Gif gif) {
        this.gif = gif;
    }

    public Gif getGif() {
        return gif;
    }
}