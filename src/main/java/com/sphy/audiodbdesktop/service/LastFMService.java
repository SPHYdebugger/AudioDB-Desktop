package com.sphy.audiodbdesktop.service;


import com.google.gson.GsonBuilder;
import com.sphy.audiodbdesktop.model.ArtistInformation;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.gson.Gson;

import java.util.List;

public class LastFMService {

    private String BASE_URL = "https://ws.audioscrobbler.com/";
    private ArtistAPI artistAPI;

    public LastFMService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gsonParser = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonParser))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        artistAPI = retrofit.create(ArtistAPI.class);
    }

    public Observable<List<ArtistInformation>> getArtistInformation(String artist) {
        return this.artistAPI.getInformation(artist)
                .subscribeOn(Schedulers.io());
    }

    public Observable<String> getTagNames(String artist) {
        return this.artistAPI.getInformation(artist)
                .flatMapIterable(artistInformation -> artistInformation)
                .flatMap(artistInformation -> Observable.fromIterable(artistInformation.getTags()))
                .map(tag -> tag.getName());
    }
}
