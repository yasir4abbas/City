package com.bolt.city.Domain.Interactor;

import com.bolt.city.Data.Handler.RepositoryHandler;

import rx.Observable;

/**
 * Created by yasir on 31/08/16.
 */
public class RepositoryInteractor {

    public Observable<String> createRepostory(String key, String selection) {
        RepositoryHandler handler = new RepositoryHandler(key, selection);
        return handler.getObservable();
    }

}
