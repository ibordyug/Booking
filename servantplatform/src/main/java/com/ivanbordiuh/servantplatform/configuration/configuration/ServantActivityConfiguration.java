package com.ivanbordiuh.servantplatform.configuration.configuration;


import com.ivanbordiuh.servantplatform.configuration.util.DomainType;
import com.ivanbordiuh.servantplatform.servant.ServantActivity;

public abstract class ServantActivityConfiguration {

    public abstract DomainType getDomainType();

    public abstract int getLayoutResource();

    public abstract Class<? extends ServantActivity> getActivityClass();
}
