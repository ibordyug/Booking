package com.ivanbordiuh.employeeplugin;

import android.os.Bundle;

import com.ivanbordiuh.servantplatform.servant.ServantActivity;

public class EmployeeActivity extends ServantActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empoyee_plugin);
    }
}