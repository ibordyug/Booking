package com.ivanbordiuh.servantplatform.dagger.module;

import android.support.v4.content.LocalBroadcastManager;

import com.ivanbordiuh.servantplatform.servant.ServantPlatformApplication;
import com.ivanbordiuh.servantplatform.configuration.plugin.PluginResolver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

    @Provides
    @Singleton
    PluginResolver providePluginResolver() {
        return new PluginResolver(servantApplication);
    }
}
