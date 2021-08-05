package com.maveri.livegallery.presenter;

import com.maveri.livegallery.api.model.GifResponse;

public interface IGifPresenter {
    void getDefaultGifs(String api_key, Integer limit, Integer offset, String rating, String random_id);
    void getSearchGifs(String api_key, String q, Integer limit, Integer offset, String rating, String lang, String random_id);
    void displayDefaultGifs(GifResponse gifResponse);
}
