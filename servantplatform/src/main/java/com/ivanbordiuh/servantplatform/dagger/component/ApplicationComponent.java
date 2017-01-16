package com.ivanbordiuh.servantplatform.dagger.component;

import com.ivanbordiuh.servantplatform.servant.ServantPlatformApplication;
import com.ivanbordiuh.servantplatform.dagger.component.api.ApplicationComponentApi;
import com.ivanbordiuh.servantplatform.dagger.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent extends ApplicationComponentApi {
    void inject(ServantPlatformApplication servantPlatformApplication);
}
