package com.careem.careemtest.dagger;

import android.app.Application;
import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mehroze on 12/15/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
@Module
public class AppModule {
    private final Application mApplication;

    public AppModule(Application application)
    {
        mApplication = application;
    }

    @Provides @Singleton
    public Context provideContext()
    {
        return mApplication;
    }

}
