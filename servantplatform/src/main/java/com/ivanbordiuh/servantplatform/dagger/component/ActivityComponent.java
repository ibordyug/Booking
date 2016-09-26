package com.ivanbordiuh.servantplatform.dagger.component;

import com.ivanbordiuh.servantplatform.servant.ServantActivity;
import com.ivanbordiuh.servantplatform.dagger.component.api.ActivityComponentApi;
import com.ivanbordiuh.servantplatform.dagger.module.ActivityModule;

import dagger.Component;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent extends ActivityComponentApi {
    void inject(ServantActivity servantActivity);
}
