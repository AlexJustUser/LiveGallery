package com.maveri.livegallery.main.ui;

import android.view.View;

import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.api.model.GifResponse;

public interface MainView {
    void displayMapsList(GifResponse gifResponse);
    void checkFavouriteGif(View view, Gif gif);
}
