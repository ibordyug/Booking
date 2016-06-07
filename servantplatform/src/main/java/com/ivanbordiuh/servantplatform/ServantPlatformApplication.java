package com.ivanbordiuh.servantplatform;

import android.app.Application;
import android.support.v4.content.LocalBroadcastManager;
import com.activeandroid.ActiveAndroid;
import com.ivanbordiuh.servantplatform.dagger.component.ApplicationComponent;
import com.ivanbordiuh.servantplatform.dagger.component.DaggerApplicationComponent;
import com.ivanbordiuh.servantplatform.dagger.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
public class ServantPlatformApplication extends Application {
    @Inject
    LocalBroadcastManager localBroadcastManager;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDagger();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ActiveAndroid.dispose();
    }

    private void initializeDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}