package com.ivanbordiuh.booking;

import android.os.Bundle;
import android.util.Log;

import com.ivanbordiuh.servantplatform.ServantActivity;

public class MainActivity extends ServantActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
