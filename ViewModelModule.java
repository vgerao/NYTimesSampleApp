package com.example.nytimesarticleapp.depndencyinjection.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.nytimesarticleapp.viewmodel.ArticleDetailsViewModel;
import com.example.nytimesarticleapp.viewmodel.ArticleListViewModel;
import com.example.nytimesarticleapp.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticleListViewModel.class)
    abstract ViewModel bindsArticleListViewModel(ArticleListViewModel articleListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailsViewModel.class)
    abstract ViewModel bindsArticleDetailsiewModel(ArticleDetailsViewModel articleDetailsViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
