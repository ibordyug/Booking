package com.ivanbordiuh.servantplatform.configuration.plugin;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.content.LocalBroadcastManager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan.Bordiuh on 19.06.2016.
 */
public class PluginHelper {
    //TODO replace with inject
    private Context context;

    public PluginHelper(Context context) {
        this.context = context;
    }

    public void loadPlugins() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Plugin> plugins = findPlugins();
                for (Plugin plugin : plugins) {
                    plugin.registerPluginConfiguration();
                }
                //TODO add action to constants
                LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("componentsareregistered"));
            }
        }).start();

    }

    private List<Plugin> findPlugins() {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("12345");
        List<ResolveInfo> resolveInfos = packageManager.queryIntentServices(intent, PackageManager.GET_RESOLVED_FILTER);
        Iterator<ResolveInfo> resolveInfoIterator = resolveInfos.iterator();
        LinkedList<Plugin> plugins = new LinkedList<>();
        while (resolveInfoIterator.hasNext()) {
            ResolveInfo resolveInfo = resolveInfoIterator.next();
            String servicePackageName = resolveInfo.serviceInfo.packageName;
            String serviceName = resolveInfo.serviceInfo.name;
            Plugin plugin = resolve(servicePackageName, serviceName);
            if (plugin != null) {
                plugins.add(plugin);
            }
        }
        return plugins;
    }

    private Plugin resolve(final String servicePackageName, final String serviceName) {
        Plugin plugin = null;

        PluginServiceConnection serviceConnection = bindToService(servicePackageName, serviceName);
        if (serviceConnection != null) {
            plugin = serviceConnection.getPlugin();
            context.unbindService(serviceConnection);
        }
        return plugin;
    }

    private PluginServiceConnection bindToService(String servicePackageName, String serviceName) {
        try {
            Intent bindServiceIntent = new Intent();
            bindServiceIntent.setClassName(servicePackageName, serviceName);
            PluginServiceConnection serviceConnection = makeServiceConnection();
            boolean bound = context.bindService(bindServiceIntent, serviceConnection, Context.BIND_AUTO_CREATE);
            if (bound) {
                return serviceConnection;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private PluginServiceConnection makeServiceConnection() {
        return new PluginServiceConnection();
    }
}
