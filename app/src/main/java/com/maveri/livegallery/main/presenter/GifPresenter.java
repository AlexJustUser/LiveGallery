package com.maveri.livegallery.main.presenter;

import android.content.Context;
import android.view.View;

import com.maveri.livegallery.api.ApiManager;
import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.api.model.GifResponse;
import com.maveri.livegallery.db.DBService;
import com.maveri.livegallery.db.model.GifRealmModel;
import com.maveri.livegallery.main.ui.MainView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class GifPresenter implements IGifPresenter{

    private ApiManager apiManager;
    private MainView view;
    private Context context;
    private DBService dBService;
    private GifRealmModel gifRealmModel;

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
    public void displayGifs(GifResponse gifResponse) {
        view.displayMapsList(gifResponse);
    }

    @Override
    public void saveFavouriteGifs(View view, Gif gif) {
        Realm.init(context);
        dBService = new DBService();

        gifRealmModel = new GifRealmModel();
        gifRealmModel.setGifUrl(gif.getImages().getFixed_height().toString().split(",")[3].substring(5));

        dBService.save(gifRealmModel, GifRealmModel.class)
                .subscribe(taskRealModel1 -> {
                this.view.checkFavouriteGif(view, gif);
                });
    }

    @Override
    public void getFavouriteGifs() {
        Realm.init(context);
        dBService = new DBService();

        dBService.getAll(GifRealmModel.class)
                .subscribe(gifRealmModels -> {
                    List<String> gifs_url = new ArrayList<String>();

                    for (GifRealmModel model: gifRealmModels) {
                        gifs_url.add(model.getGifUrl());
                    }
                    //displayFavouriteGifs(gifs_url);
                });
    }

}
