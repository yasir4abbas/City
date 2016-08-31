package com.bolt.city.Presentation.Presenter;

import android.util.Log;

import com.bolt.city.Domain.Interactor.RepositoryInteractor;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by yasir on 31/08/16.
 */
public class KeyPresenter {

    public static String LOG_TAG = KeyPresenter.class.getSimpleName();
    Observable<String> observable;

    public KeyPresenter() {
    }

    public void getUserCredentials(String key) {
        //TODO: create a repository
        RepositoryInteractor interactor = new RepositoryInteractor();
        observable = interactor.createRepostory(key, "basic");
        execute();
    }

    private void execute() {
        observable.map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                OkHttpClient client = new OkHttpClient();

                Request request = new Request.Builder()
                        .url(s)
                        .build();

                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    return response.body().string();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                return "";
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new KeyObserver());
    }


    class KeyObserver implements Observer<String> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d(LOG_TAG, e + "");
        }

        @Override
        public void onNext(String s) {
            Log.d(LOG_TAG, s);
        }
    }
}
