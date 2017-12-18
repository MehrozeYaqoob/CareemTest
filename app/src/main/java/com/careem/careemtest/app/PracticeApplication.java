package com.careem.careemtest.app;

import android.app.Application;

import com.careem.careemtest.dagger.AppComponent;
import com.careem.careemtest.dagger.AppModule;
import com.careem.careemtest.dagger.DaggerAppComponent;


/**
 * Created by hp on 12/15/2017.
 */

public class PracticeApplication  extends Application{
    private AppComponent appComponent;

    public AppComponent getAppComponent()
    {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
    public AppComponent initDagger(PracticeApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
