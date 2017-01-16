package com.ivanbordiuh.servantplatform.dagger.component.api;

import android.support.v4.content.LocalBroadcastManager;

import com.ivanbordiuh.servantplatform.configuration.plugin.PluginResolver;

import javax.inject.Singleton;

public interface ApplicationComponentApi {
    LocalBroadcastManager provideLocalBroadcastManager();

    PluginResolver providePluginResolver();
}
