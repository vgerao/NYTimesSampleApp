package com.example.nytimesarticleapp.model.remotedata.response;

import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularArticleResponse {

    @SerializedName("results")
    private List<ArticleEntity> popularArticles;


    public List<ArticleEntity> getPopularArticles() {
        return popularArticles;
    }

    public void setPopularArticles(List<ArticleEntity> popularArticles) {
        this.popularArticles = popularArticles;
    }

}
