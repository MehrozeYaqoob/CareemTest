package com.careem.careemtest.dagger;

import android.content.Context;

import com.careem.careemtest.activity.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mehroze on 12/18/2017.
 */
@SuppressWarnings({ "DefaultFileTemplate"})

@Module
class PresenterModule {


    @Provides @Singleton
    MainPresenter provideMainPresenter(Context context){
        return new MainPresenter(context);
    }

}
