package com.example.nytimesarticleapp.depndencyinjection.module;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.nytimesarticleapp.common.Constants;
import com.example.nytimesarticleapp.model.localdbdata.ArticleDatabase;
import com.example.nytimesarticleapp.model.localdbdata.dao.ArticleDao;
import com.example.nytimesarticleapp.model.remotedata.services.ApiService;
import com.example.nytimesarticleapp.model.remotedata.services.RequestInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(Constants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(new RequestInterceptor());
        okHttpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    ArticleDatabase provideArticleDatabase(Application application) {
        return Room.databaseBuilder(application, ArticleDatabase.class, "articles.db").build();
    }

    @Provides
    @Singleton
    ArticleDao provideArticleDao(ArticleDatabase articleDatabase) {
        return articleDatabase.articleDao();
    }

}
