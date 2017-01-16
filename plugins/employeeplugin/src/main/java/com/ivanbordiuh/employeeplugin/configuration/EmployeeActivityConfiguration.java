package com.ivanbordiuh.employeeplugin.configuration;


import com.ivanbordiuh.employeeplugin.EmployeeActivity;
import com.ivanbordiuh.employeeplugin.R;
import com.ivanbordiuh.servantplatform.configuration.configuration.ServantActivityConfiguration;
import com.ivanbordiuh.servantplatform.configuration.util.DomainType;
import com.ivanbordiuh.servantplatform.servant.ServantActivity;

public class EmployeeActivityConfiguration extends ServantActivityConfiguration {
    @Override
    public DomainType getDomainType() {
        return DomainType.EMPLOYEE_ACTIVITY;
    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_empoyee_plugin;
    }

    @Override
    public Class<? extends ServantActivity> getActivityClass() {
        return EmployeeActivity.class;
    }
}
