package com.ivanbordiuh.booking;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.ivanbordiuh.servantplatform.servant.ServantActivity;

public class MainActivity extends ServantActivity {
    private PluginsAreLoadedReceiver pluginsAreLoadedReceiver = new PluginsAreLoadedReceiver();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager.registerReceiver(pluginsAreLoadedReceiver, new IntentFilter("componentsareregistered"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        localBroadcastManager.unregisterReceiver(pluginsAreLoadedReceiver);
    }

    private class PluginsAreLoadedReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            startActivity(new Intent(MainActivity.this, ServantActivity.class));
        }
    }
}
