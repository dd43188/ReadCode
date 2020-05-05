package com.water.readcode;

import android.app.Application;

/**
 * Created by 38164 on 2020/5/5.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        HookManager.init();
    }
}
