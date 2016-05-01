package com.think.awhealth;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.litesuits.orm.LiteOrm;
import com.think.awhealth.retrofit.AwApiManager;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class App extends Application {
    private static final String DB_NAME = "awHealth.db";
    public static App ourInstance = new App();
    public static Context AppContext = null;


    public static App getInstance(){
        return ourInstance;
    }
    public static LiteOrm sDb;
    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = getApplicationContext();
        AwApiManager.init();
        Fresco.initialize(this);
        SDKInitializer.initialize(getApplicationContext());

        sDb = LiteOrm.newCascadeInstance(this,DB_NAME);
        sDb.setDebugged(true);
    }

}
