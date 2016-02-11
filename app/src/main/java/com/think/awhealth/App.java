package com.think.awhealth;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.litesuits.orm.LiteOrm;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class App extends Application {
    private static final String DB_NAME = "awHealth.db";
    public static App ourInstance = new App();
    private RefWatcher mRefWatcher;

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }

    public static App getInstance(){
        return ourInstance;
    }
    public static LiteOrm sDb;
    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        mRefWatcher = LeakCanary.install(this);
        ImagePipeline imagePipeline = Fresco.getImagePipeline();

        sDb = LiteOrm.newCascadeInstance(this,DB_NAME);
        sDb.setDebugged(true);
        Logger.init("MyLogTag");
    }

}
