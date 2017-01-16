package com.ivanbordiuh.servantplatform.configuration.plugin;

import android.content.Context;
import android.util.Log;

import com.ivanbordiuh.servantplatform.configuration.configuration.ServantActivityConfiguration;
import com.ivanbordiuh.servantplatform.configuration.configuration.ServantFragmentConfiguration;
import com.ivanbordiuh.servantplatform.configuration.util.DomainType;

import java.util.HashMap;
import java.util.Map;

public class PluginResolver {
    private final String LOG_TAG = PluginResolver.class.getSimpleName();
    //TODO replace with inject
    Context context;
    Map<DomainType, Class<? extends ServantActivityConfiguration>> activityConfigurationMap = new HashMap<>();
    Map<DomainType, Class<? extends ServantFragmentConfiguration>> fragmentConfigurationMap = new HashMap<>();

    public PluginResolver(Context context) {
        this.context = context;
    }

    public void initialize() {
        new PluginHelper(context).loadPlugins();
    }

    public PluginResolver addActivityConfiguration(DomainType domainType, Class<? extends ServantActivityConfiguration> activityConfiguration) {
        activityConfigurationMap.put(domainType, activityConfiguration);
        return this;
    }

    public PluginResolver addFragmentConfiguration(DomainType domainType, Class<? extends ServantFragmentConfiguration> fragmantConfiguration) {
        fragmentConfigurationMap.put(domainType, fragmantConfiguration);
        return this;
    }

    public ServantActivityConfiguration getEntryPointActivityConfiguration() {
        try {
            return activityConfigurationMap.get(DomainType.ENTRY_POINT).newInstance();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Can't get entry point configuration " + e.toString());
            return null;
        }
    }
}
