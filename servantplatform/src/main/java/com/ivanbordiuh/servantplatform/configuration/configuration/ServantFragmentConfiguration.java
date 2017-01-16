package com.ivanbordiuh.servantplatform.configuration.configuration;

import com.ivanbordiuh.servantplatform.configuration.util.DomainType;
import com.ivanbordiuh.servantplatform.servant.ServantFragment;

public abstract class ServantFragmentConfiguration {
    public abstract int getFragmentLayoutId();

    public abstract Class<? extends ServantFragment> getFragmentClass();

    public abstract DomainType getDomainType();
}
