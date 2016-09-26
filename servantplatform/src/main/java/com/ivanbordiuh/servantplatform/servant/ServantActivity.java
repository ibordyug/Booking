package com.ivanbordiuh.servantplatform.servant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.ivanbordiuh.servantplatform.R;
import com.ivanbordiuh.servantplatform.dagger.component.ActivityComponent;
import com.ivanbordiuh.servantplatform.dagger.component.DaggerActivityComponent;
import com.ivanbordiuh.servantplatform.dagger.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
public class ServantActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Inject
    public LocalBroadcastManager localBroadcastManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_servant);
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