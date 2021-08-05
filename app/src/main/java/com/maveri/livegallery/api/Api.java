package com.maveri.livegallery.api;

import com.maveri.livegallery.api.model.GifResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface Api {

    @GET("trending")
    Observable<GifResponse> getDefaultGifs(@Query("api_key") String api_key, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("rating") String rating, @Query("random_id") String random_id);

    @GET("search")
    Observable<GifResponse> getSearchGifs(@Query("api_key") String api_key, @Query("q") String q, @Query("limit") Integer limit, @Query("offset") Integer offset, @Query("rating") String rating, @Query("lang") String lang, @Query("random_id") String random_id);

}
