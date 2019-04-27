package com.example.nytimesarticleapp.model.remotedata.repo;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.nytimesarticleapp.model.localdbdata.dao.ArticleDao;
import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;
import com.example.nytimesarticleapp.model.remotedata.response.PopularArticleResponse;
import com.example.nytimesarticleapp.model.remotedata.services.ApiService;
import com.example.nytimesarticleapp.model.remotedata.services.NetworkBoundResource;
import com.example.nytimesarticleapp.model.remotedata.services.Resource;
import com.example.nytimesarticleapp.view.callbacks.ResponseListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

/**
 * The article repository which has access to local and remote data fetching services
 */
public class ArticleRepository {

    private final ArticleDao articleDao;
    private final ApiService apiService;

    @Inject
    ArticleRepository(ArticleDao dao, ApiService service) {
        this.articleDao = dao;
        this.apiService = service;
    }

    /**
     * This method fetches the popular articles from the service.
     */
    public LiveData<Resource<List<ArticleEntity>>> loadPopularArticles() {
        return new NetworkBoundResource<List<ArticleEntity>, PopularArticleResponse>() {

            @Override
            protected void saveCallResult(PopularArticleResponse item) {
                if(null != item)
                    articleDao.saveArticles(item.getPopularArticles());
            }

            @NonNull
            @Override
            protected LiveData<List<ArticleEntity>> loadFromDb() {
                return articleDao.loadPopularArticles();
            }

            @NonNull
            @Override
            protected Call<PopularArticleResponse> createCall() {
                return apiService.loadPopularArticles();
            }
        }.getAsLiveData();
    }


    /**
     * This method fetches the HTML comntent from the url and parses it and fills the model
     * @param url url to be fetched
     * @param responseListener callback
     */
    @SuppressLint("CheckResult")
    public void loadArticleDetails(String url, ResponseListener responseListener) {
        ArticleEntity articleDetails = new ArticleEntity();
        Observable.fromCallable(() -> {
            Document document = Jsoup.connect(url).get();
            articleDetails.setTitle(document.title());
            articleDetails.setContent(document.select("p").text());
            return false;
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> responseListener.onSuccess(articleDetails),
                 (error -> responseListener.onFailure(error.getMessage())));

    }

}
