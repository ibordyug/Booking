package com.ivanbordiuh.servantplatform.dagger.module;

import com.ivanbordiuh.servantplatform.configuration.plugin.PluginService;

import dagger.Module;

/**
 * Created by Ivan.Bordiuh on 19.06.2016.
 */
@Module
public class ServiceModule {
    private PluginService pluginService;

    public ServiceModule(PluginService pluginService) {
        this.pluginService = pluginService;
    }
}
