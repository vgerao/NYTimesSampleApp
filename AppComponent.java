package com.example.nytimesarticleapp.depndencyinjection.component;
import android.app.Application;

import com.example.nytimesarticleapp.NYTimesApplication;
import com.example.nytimesarticleapp.depndencyinjection.builder.ActivityBuilderModule;
import com.example.nytimesarticleapp.depndencyinjection.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * The main application component which initializes all the dependent modules
 */
@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(NYTimesApplication nyTimesApp);
}