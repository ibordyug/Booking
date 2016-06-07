package com.ivanbordiuh.servantplatform.dagger.module;

import android.support.v4.content.LocalBroadcastManager;

import com.ivanbordiuh.servantplatform.ServantPlatformApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
@Module
public class ApplicationModule {
    private ServantPlatformApplication servantApplication;

    public ApplicationModule(ServantPlatformApplication servantApplication) {
        this.servantApplication = servantApplication;
    }

    @Provides
    LocalBroadcastManager provideLocalBroadcastManager() {
        return LocalBroadcastManager.getInstance(servantApplication);
    }
}
