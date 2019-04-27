package com.example.nytimesarticleapp.model.localdbdata;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.nytimesarticleapp.model.localdbdata.dao.ArticleDao;
import com.example.nytimesarticleapp.model.localdbdata.entity.ArticleEntity;


@Database(entities = {ArticleEntity.class}, version = 2)
public abstract class ArticleDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}