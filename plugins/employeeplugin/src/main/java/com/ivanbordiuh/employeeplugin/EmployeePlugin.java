package com.ivanbordiuh.employeeplugin;

import android.content.Intent;
import android.os.IBinder;

import com.ivanbordiuh.servantplatform.configuration.plugin.Plugin;
import com.ivanbordiuh.servantplatform.configuration.plugin.PluginBinder;
import com.ivanbordiuh.servantplatform.configuration.plugin.PluginService;
import com.ivanbordiuh.servantplatform.configuration.util.DomainType;

/**
 * Created by Ivan.Bordiuh on 08.06.2016.
 */
public class EmployeePlugin extends PluginService implements Plugin {
    private LocalBinder localBinder = new LocalBinder();

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public EmployeePlugin() {
        super(EmployeePlugin.class.getSimpleName());
    }

    @Override
    public void registerPluginConfiguration() {
        pluginResolver
                .addActivityConfiguration(EmployeeActivity.class, R.layout.activity_empoyee_plugin)
                .addFragmentConfiguration(EmployeeFragment.class, R.layout.fragment_employee, R.id.content_holder, DomainType.ROOT_FRAGMENT);
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