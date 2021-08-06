package com.maveri.livegallery.favourite.presenter;

import com.maveri.livegallery.api.model.Gif;

import java.util.List;

public interface IFavouriteGifsPresenter {
    void getFavouriteGifs();
    void displayFavouriteGifs(List<String> gifs_url);
}
