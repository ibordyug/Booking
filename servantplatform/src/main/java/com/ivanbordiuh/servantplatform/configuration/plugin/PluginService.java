package com.ivanbordiuh.servantplatform.configuration.plugin;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

import com.ivanbordiuh.servantplatform.servant.ServantPlatformApplication;
import com.ivanbordiuh.servantplatform.dagger.component.DaggerServiceComponent;
import com.ivanbordiuh.servantplatform.dagger.component.ServiceComponent;
import com.ivanbordiuh.servantplatform.dagger.module.ServiceModule;

import javax.inject.Inject;

/**
 * Created by Ivan.Bordiuh on 19.06.2016.
 */
public class PluginService extends IntentService {
    private ServiceComponent serviceComponent;

    @Inject
    protected PluginResolver pluginResolver;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public PluginService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        initializeDagger();
        return super.onBind(intent);
    }

    private void initializeDagger() {
        serviceComponent = DaggerServiceComponent.builder()
                .applicationComponent(((ServantPlatformApplication) getApplication()).getApplicationComponent())
                .serviceModule(new ServiceModule(this))
                .build();
        serviceComponent.inject(this);
    }
}
