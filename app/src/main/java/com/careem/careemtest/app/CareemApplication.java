package com.careem.careemtest.app;

import android.app.Application;

import com.careem.careemtest.dagger.AppComponent;
import com.careem.careemtest.dagger.AppModule;
import com.careem.careemtest.dagger.DaggerAppComponent;


/**
 * Created by Mehroze on 12/15/2017.
 */

@SuppressWarnings("ALL")
public class CareemApplication extends Application{
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
    private AppComponent initDagger(CareemApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
