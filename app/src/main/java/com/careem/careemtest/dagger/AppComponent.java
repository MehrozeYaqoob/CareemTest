package com.careem.careemtest.dagger;


import com.careem.careemtest.activity.MainActivity;
import com.careem.careemtest.activity.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mehroze on 12/15/2017.
 */
@SuppressWarnings("ALL")
@Singleton
@Component (modules = {AppModule.class, NetworkModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
}
