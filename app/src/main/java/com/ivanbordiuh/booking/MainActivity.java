package com.ivanbordiuh.booking;

import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.ivanbordiuh.servantplatform.ServantActivity;

import javax.inject.Inject;

public class MainActivity extends ServantActivity {
    @Inject
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (localBroadcastManager != null) {
            Log.d("OLOLO", "OBANA");
        }
    }
}
