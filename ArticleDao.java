package com.example.nytimesarticleapp.model.localdbdata.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM articles")
    LiveData<List<ArticleEntity>> loadPopularArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveArticles(List<ArticleEntity> articleEntities);

}