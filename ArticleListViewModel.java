package com.example.nytimesarticleapp.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;
import com.example.nytimesarticleapp.model.remotedata.repo.ArticleRepository;
import com.example.nytimesarticleapp.model.remotedata.services.Resource;

import java.util.List;

import javax.inject.Inject;

public class ArticleListViewModel extends ViewModel {
    private final LiveData<Resource<List<ArticleEntity>>> popularArticles;

    @Inject
    public ArticleListViewModel(ArticleRepository articleRepository) {
        popularArticles = articleRepository.loadPopularArticles();
    }

    public LiveData<Resource<List<ArticleEntity>>> getPopularArticles() {
        return popularArticles;
    }
}
