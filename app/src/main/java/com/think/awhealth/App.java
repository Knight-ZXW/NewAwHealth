package com.think.awhealth;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.litesuits.orm.LiteOrm;
import com.think.awhealth.bean.entity.User;
import com.think.awhealth.retrofit.AwApiManager;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class App extends Application {
    private static final String DB_NAME = "awHealth.db";
    public static App ourInstance = new App();
    public static Context AppContext = null;

    public static final String application ="97de9491745d0aeefb362b4f404cc790";
    public static App getInstance(){
        return ourInstance;
    }
    public static LiteOrm sDb;
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,application);
        AppContext = getApplicationContext();
        AwApiManager.init();
        Fresco.initialize(this);
        SDKInitializer.initialize(getApplicationContext());
        sDb = LiteOrm.newCascadeInstance(this,DB_NAME);
        sDb.setDebugged(true);
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.signUp(AppContext, new SaveListener() {
            @Override
            public void onSuccess() {
                Log.w("signUp","sign Up Success");
            }

            @Override
            public void onFailure(int i, String s) {

                Log.w("signUp","sign Up Field");
            }
        });
        user.login(AppContext, new SaveListener() {
            @Override
            public void onSuccess() {
                Log.w("login","login Success");

            }

            @Override
            public void onFailure(int i, String s) {
                Log.w("login","login onFailure"+s);

            }
        });
        BmobUser currentUser = User.getCurrentUser(AppContext);
        Log.w("sign","currentUser"+currentUser);
    }

}
