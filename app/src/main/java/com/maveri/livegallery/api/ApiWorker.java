package com.maveri.livegallery.api;

import com.maveri.livegallery.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiWorker {

    private static Retrofit retrofit=null;

    public static Api getApiService(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build();
        }
        return retrofit.create(Api.class);
    }
}
