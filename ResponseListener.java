package com.example.nytimesarticleapp.view.callbacks;


import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;

public interface ResponseListener {

    void onSuccess(ArticleEntity data);
    void onFailure(String message);
}
