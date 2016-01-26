package com.think.awhealth;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.Logger;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Logger.init("MyLogTag");
    }

}
