package com.ivanbordiuh.servantplatform.servant;

import android.app.Application;
import android.support.v4.content.LocalBroadcastManager;

import com.activeandroid.ActiveAndroid;
import com.ivanbordiuh.servantplatform.configuration.plugin.PluginResolver;
import com.ivanbordiuh.servantplatform.dagger.component.ApplicationComponent;
import com.ivanbordiuh.servantplatform.dagger.component.DaggerApplicationComponent;
import com.ivanbordiuh.servantplatform.dagger.module.ApplicationModule;

import javax.inject.Inject;


public class ServantPlatformApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Inject
    LocalBroadcastManager localBroadcastManager;
    @Inject
    PluginResolver pluginResolver;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeDagger();
        pluginResolver.initialize();
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