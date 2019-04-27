package com.example.nytimesarticleapp.depndencyinjection.builder;


import com.example.nytimesarticleapp.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract MainActivity mainActivity();


}