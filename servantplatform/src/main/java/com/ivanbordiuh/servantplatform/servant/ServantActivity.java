package com.ivanbordiuh.servantplatform.servant;

import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.ivanbordiuh.servantplatform.configuration.plugin.PluginResolver;
import com.ivanbordiuh.servantplatform.dagger.component.ActivityComponent;
import com.ivanbordiuh.servantplatform.dagger.component.DaggerActivityComponent;
import com.ivanbordiuh.servantplatform.dagger.module.ActivityModule;

import javax.inject.Inject;

public class ServantActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Inject
    public LocalBroadcastManager localBroadcastManager;

    @Inject
    public PluginResolver pluginResolver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
    }


    private void initializeDagger() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(((ServantPlatformApplication) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
        activityComponent.inject(this);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }


}