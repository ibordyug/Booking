package com.ivanbordiuh.employeeplugin.configuration;

import com.ivanbordiuh.employeeplugin.EmployeeListFragment;
import com.ivanbordiuh.employeeplugin.R;
import com.ivanbordiuh.servantplatform.configuration.configuration.ServantFragmentConfiguration;
import com.ivanbordiuh.servantplatform.configuration.util.DomainType;
import com.ivanbordiuh.servantplatform.servant.ServantFragment;

public class EmployeeListFragmentConfiguration extends ServantFragmentConfiguration {
    @Override
    public int getFragmentLayoutId() {
        return R.layout.fragment_employee_list;
    }

    @Override
    public Class<? extends ServantFragment> getFragmentClass() {
        return EmployeeListFragment.class;
    }

    @Override
    public DomainType getDomainType() {
        return DomainType.EMPLOYEE_ACTIVITY;
    }
}
