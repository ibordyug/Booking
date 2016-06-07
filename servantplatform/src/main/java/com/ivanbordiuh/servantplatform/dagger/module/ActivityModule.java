package com.ivanbordiuh.servantplatform.dagger.module;

import com.ivanbordiuh.servantplatform.ServantActivity;

import dagger.Module;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
@Module
public class ActivityModule {
    private ServantActivity servantActivity;

    public ActivityModule(ServantActivity servantActivity) {
        this.servantActivity = servantActivity;
    }
}
