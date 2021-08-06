package com.maveri.livegallery.main.ui;

import android.view.View;

import com.google.gson.internal.LinkedHashTreeMap;
import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.api.model.GifResponse;

import java.util.List;

public interface MainView {
    void displayMapsList(GifResponse gifResponse, List<String> favouriteGifsList);
    void checkFavouriteGif(View view, Gif gif);
}
