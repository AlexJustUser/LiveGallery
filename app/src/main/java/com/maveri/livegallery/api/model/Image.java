package com.maveri.livegallery.api.model;

import com.google.gson.internal.LinkedHashTreeMap;

public class Image {

    private LinkedHashTreeMap fixed_height;

    public void setFixed_height(LinkedHashTreeMap fixed_height) {
        this.fixed_height = fixed_height;
    }

    public LinkedHashTreeMap getFixed_height() {
        return fixed_height;
    }
}
