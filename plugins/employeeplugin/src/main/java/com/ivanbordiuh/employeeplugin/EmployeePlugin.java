package com.ivanbordiuh.employeeplugin;

import android.content.Intent;
import android.os.IBinder;

import com.ivanbordiuh.employeeplugin.configuration.EmployeeActivityConfiguration;
import com.ivanbordiuh.servantplatform.configuration.plugin.Plugin;
import com.ivanbordiuh.servantplatform.configuration.plugin.PluginBinder;
import com.ivanbordiuh.servantplatform.configuration.plugin.PluginService;
import com.ivanbordiuh.servantplatform.configuration.util.DomainType;

public class EmployeePlugin extends PluginService implements Plugin {
    private LocalBinder localBinder = new LocalBinder();

    public EmployeePlugin() {
        super(EmployeePlugin.class.getSimpleName());
    }

    @Override
    public void registerPluginConfiguration() {
        pluginResolver
                .addActivityConfiguration(DomainType.ENTRY_POINT, EmployeeActivityConfiguration.class);
                //.addFragmentConfiguration(EmployeeFragment.class, R.layout.fragment_employee, R.id.content_holder);
    }

    @Override
    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        return localBinder;
    }

    public class LocalBinder extends PluginBinder {

        @Override
        public Plugin getPlugin() {
            return EmployeePlugin.this;
        }
    }
}