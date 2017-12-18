package com.careem.careemtest.dagger;

import android.content.Context;

import com.careem.careemtest.activity.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hp on 12/18/2017.
 */
@Module
public class PresenterModule {


    @Provides @Singleton
    MainPresenter provideMainPresenter(Context context){
        return new MainPresenter(context);
    }

}
