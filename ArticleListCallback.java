package com.example.nytimesarticleapp.view.callbacks;


import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;

public interface ArticleListCallback {
    void onArticleClicked(ArticleEntity articleEntity);
}

