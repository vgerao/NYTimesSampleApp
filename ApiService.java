package com.example.nytimesarticleapp.model.remotedata.services;

import com.example.nytimesarticleapp.model.remotedata.response.PopularArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=IZn3xOQhpthJxLwCExJ4eYfxtIQbxPnl")
    Call<PopularArticleResponse> loadPopularArticles();
}