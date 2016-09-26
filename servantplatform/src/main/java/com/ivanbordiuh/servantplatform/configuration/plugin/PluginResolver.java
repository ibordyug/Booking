package com.ivanbordiuh.servantplatform.configuration.plugin;

import android.content.Context;

import com.ivanbordiuh.servantplatform.configuration.configuration.FragmentConfiguration;
import com.ivanbordiuh.servantplatform.configuration.util.DomainType;
import com.ivanbordiuh.servantplatform.servant.ServantActivity;
import com.ivanbordiuh.servantplatform.servant.ServantFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan.Bordiuh on 19.06.2016.
 */
public class PluginResolver {
    //TODO replace with inject
    Context context;
    Map<Class<? extends ServantActivity>, Integer> activityConfigurationMap = new HashMap<>();
    Map<DomainType, FragmentConfiguration> fragmentConfigurationMap = new HashMap<>();

    public PluginResolver(Context context) {
        this.context = context;
    }

    public void initialize() {
        new PluginHelper(context).loadPlugins();
    }

    public PluginResolver addActivityConfiguration(Class<? extends ServantActivity> activityClass, int layoutId) {
        return this;
    }

    public PluginResolver addFragmentConfiguration(Class<? extends ServantFragment> fragmentClass, int layoutId, int parentId, DomainType... domainTypes) {
        FragmentConfiguration fragmentConfiguration = new FragmentConfiguration();
        fragmentConfiguration.setFragment(fragmentClass);
        fragmentConfiguration.setLayout(layoutId);
        fragmentConfiguration.setParentId(parentId);
        fragmentConfiguration.setDomainType(domainTypes);
        fragmentConfigurationMap.put(domainTypes[0], fragmentConfiguration);
        return this;
    }
}
