package com.ivanbordiuh.servantplatform.dagger.component.api;

import android.support.v4.content.LocalBroadcastManager;

import com.ivanbordiuh.servantplatform.configuration.plugin.PluginResolver;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
public interface ApplicationComponentApi {
    LocalBroadcastManager provideLocalBroadcastManager();

    PluginResolver providePluginResolver();
}
