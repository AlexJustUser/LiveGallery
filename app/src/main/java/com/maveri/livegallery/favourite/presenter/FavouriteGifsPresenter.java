package com.maveri.livegallery.favourite.presenter;

import android.content.Context;

import com.maveri.livegallery.api.ApiManager;
import com.maveri.livegallery.api.model.Gif;
import com.maveri.livegallery.db.DBService;
import com.maveri.livegallery.db.model.GifRealmModel;
import com.maveri.livegallery.favourite.ui.FavouriteView;
import com.maveri.livegallery.main.presenter.IGifPresenter;
import com.maveri.livegallery.main.ui.MainView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class FavouriteGifsPresenter implements IFavouriteGifsPresenter {

    private ApiManager apiManager;
    private FavouriteView view;
    private Context context;
    private DBService dBService;
    private GifRealmModel gifRealmModel;

    public FavouriteGifsPresenter(FavouriteView view, Context context) {
        this.apiManager = new ApiManager();
        this.view = view;
        this.context = context;
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
                    displayFavouriteGifs(gifs_url);
                });
    }

    @Override
    public void displayFavouriteGifs(List<String> gifs_url) {
       view.displayFavouriteGifs(gifs_url);
    }
}
