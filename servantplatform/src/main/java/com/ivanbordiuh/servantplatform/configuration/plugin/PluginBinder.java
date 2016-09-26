package com.ivanbordiuh.servantplatform.configuration.plugin;

import android.os.Binder;

/**
 * Created by Ivan.Bordiuh on 16.06.2016.
 */
abstract public class PluginBinder extends Binder {
    public abstract Plugin getPlugin();
}
