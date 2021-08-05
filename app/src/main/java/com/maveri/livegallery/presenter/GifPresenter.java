package com.maveri.livegallery.presenter;

import android.content.Context;

import com.maveri.livegallery.api.ApiManager;
import com.maveri.livegallery.api.model.GifResponse;
import com.maveri.livegallery.ui.MainView;

public class GifPresenter implements IGifPresenter{

    private ApiManager apiManager;
    private MainView view;
    private Context context;

    public GifPresenter(MainView view, Context context) {
        this.apiManager = new ApiManager();
        this.view = view;
        this.context = context;
    }

    @Override
    public void getDefaultGifs(String api_key, Integer limit, Integer offset, String rating, String random_id) {
        apiManager.getDefaultGifs(api_key, limit, offset, rating, random_id, this);
    }

    @Override
    public void getSearchGifs(String api_key, String q, Integer limit, Integer offset, String rating, String lang, String random_id) {
        apiManager.getSearchGifs(api_key, q, limit, offset, rating, lang, random_id, this);
    }

    @Override
    public void displayDefaultGifs(GifResponse gifResponse) {
        view.displayMapsList(gifResponse);
    }
}
