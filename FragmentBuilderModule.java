package com.example.nytimesarticleapp.depndencyinjection.builder;


import com.example.nytimesarticleapp.view.fragment.ArticleDetailFragment;
import com.example.nytimesarticleapp.view.fragment.ArticleListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract ArticleListFragment contributeArticleListFragment();

    @ContributesAndroidInjector
    abstract ArticleDetailFragment contributeArticleDetailFragment();

}