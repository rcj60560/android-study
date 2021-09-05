package com.luocj.androidstudy;

import android.app.Application;

import com.luocj.common.utils.Utils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
