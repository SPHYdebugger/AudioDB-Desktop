package com.sphy.audiodbdesktop.service;


import com.sphy.audiodbdesktop.model.ArtistInformation;

import retrofit2.http.GET;
import retrofit2.http.Path;
import io.reactivex.Observable;
import java.util.List;


public interface ArtistAPI {

    @GET("/2.0/?method=artist.getinfo&artist={artist}&api_key=875c7d914c654e588d1a6670988b9680&format=json")
    Observable<List<ArtistInformation>> getInformation(@Path("artist") String artist);
}
