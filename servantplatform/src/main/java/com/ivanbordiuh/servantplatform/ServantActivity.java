package com.ivanbordiuh.servantplatform;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ivanbordiuh.servantplatform.dagger.component.ActivityComponent;
import com.ivanbordiuh.servantplatform.dagger.component.DaggerActivityComponent;
import com.ivanbordiuh.servantplatform.dagger.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by Ivan.Bordiuh on 07.06.2016.
 */
public class ServantActivity extends AppCompatActivity {
    @Inject
    public LocalBroadcastManager localBroadcastManager;

    private ActivityComponent activityComponent;

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

    public ActivityComponent getActivityComponent(){
        return activityComponent;
    }
}
