package com.ivanbordiuh.servantplatform.configuration.plugin;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ivan.Bordiuh on 15.06.2016.
 */
public class PluginServiceConnection implements ServiceConnection {
    private final ReentrantLock lockServiceConnection = new ReentrantLock();
    private final Condition conditionPluginBound = lockServiceConnection.newCondition();

    private Plugin plugin;

    public Plugin getPlugin() {
        lockServiceConnection.lock();
        try {
            while (plugin == null) {
                conditionPluginBound.await();
                return plugin;
            }
            return plugin;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lockServiceConnection.unlock();
        }
    }

    @Override
    public void onServiceConnected(ComponentName className, IBinder serviceBinder) {
        lockServiceConnection.lock();
        try {
            if ((serviceBinder instanceof PluginBinder)) {
                PluginBinder pluginBinder = (PluginBinder) serviceBinder;
                plugin = pluginBinder.getPlugin();
            }
            conditionPluginBound.signalAll();
        } finally {
            lockServiceConnection.unlock();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        plugin = null;
    }
}
