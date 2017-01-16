package com.ivanbordiuh.servantplatform.dagger.component;

import com.ivanbordiuh.servantplatform.configuration.plugin.PluginService;
import com.ivanbordiuh.servantplatform.dagger.component.api.ServiceComponentApi;
import com.ivanbordiuh.servantplatform.dagger.component.scope.FragmentScope;
import com.ivanbordiuh.servantplatform.dagger.module.ServiceModule;

import dagger.Component;

@FragmentScope
@Component(modules = ServiceModule.class, dependencies = ApplicationComponent.class)
public interface ServiceComponent extends ServiceComponentApi{
    void inject(PluginService pluginService);
}
