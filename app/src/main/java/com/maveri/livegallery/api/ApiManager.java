package com.maveri.livegallery.api;

import android.util.Log;

import com.maveri.livegallery.api.model.GifResponse;
import com.maveri.livegallery.main.presenter.IGifPresenter;

import java.util.concurrent.TimeUnit;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ApiManager {
    private Subscription subscription;
    private static final String TAG = ApiManager.class.getSimpleName();

    public void getDefaultGifs(String api_key, Integer limit, Integer offset, String rating, String random_id, final IGifPresenter presenter) {
        try {
            subscription = ApiWorker.getApiService()
                    .getDefaultGifs(api_key, limit, offset, rating, random_id)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<GifResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "In onCompleted()");
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            Log.d(TAG, "In onError()");
                        }

                        @Override
                        public void onNext(GifResponse gifResponse) {
                            Log.d(TAG, "In onNext()");
                            presenter.displayGifs(gifResponse);

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getSearchGifs(String api_key, String q, Integer limit, Integer offset, String rating, String lang, String random_id, final IGifPresenter presenter) {
        try {
            subscription = ApiWorker.getApiService()
                    .getSearchGifs(api_key, q, limit, offset, rating, lang, random_id)
                    .debounce(500, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<GifResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "In onCompleted()");
                        }

                        @Override
                        public void onError(Throwable e) {
                            e.printStackTrace();
                            Log.d(TAG, "In onError()");
                        }

                        @Override
                        public void onNext(GifResponse gifResponse) {
                            Log.d(TAG, "In onNext()");
                            presenter.displayGifs(gifResponse);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
