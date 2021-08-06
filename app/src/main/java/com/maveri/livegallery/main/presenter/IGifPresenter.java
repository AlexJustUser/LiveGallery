package com.maveri.livegallery.main.presenter;

import android.view.View;

import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.api.model.GifResponse;

import java.util.List;

public interface IGifPresenter {
    void getDefaultGifs(String api_key, Integer limit, Integer offset, String rating, String random_id);
    void getSearchGifs(String api_key, String q, Integer limit, Integer offset, String rating, String lang, String random_id);
    void saveFavouriteGifs(View view, Gif gif);
    void getFavouriteGifs();
    void displayGifs(GifResponse gifResponse);
}
