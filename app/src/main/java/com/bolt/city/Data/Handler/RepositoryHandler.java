package com.bolt.city.Data.Handler;

import rx.Observable;

/**
 * Created by yasir on 31/08/16.
 */
public class RepositoryHandler {
    //TODO: create URL
    //TODO: send an observable of string

    private Observable<String> mObservable;

    public RepositoryHandler(String key, String selection) {
        mObservable = Observable.just("https://api.torn.com/user/?selections=" + selection + "&key=" + key);
    }


    public Observable<String> getObservable() {
        return mObservable;
    }
}
