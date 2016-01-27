package com.think.awhealth;

import android.app.Application;
import android.graphics.Bitmap;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.litesuits.orm.LiteOrm;
import com.orhanobut.logger.Logger;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class App extends Application {
    private static final String DB_NAME = "awHealth.db";
    public static App ourInstance = new App();
    public static App getInstance(){
        return ourInstance;
    }
    public static LiteOrm sDb;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        sDb = LiteOrm.newCascadeInstance(this,DB_NAME);
        sDb.setDebugged(true);
        Logger.init("MyLogTag");
        BaseBitmapDataSubscriber baseBitmapDataSubscriber = new BaseBitmapDataSubscriber() {
            @Override
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {

            }

            @Override
            protected void onNewResultImpl(Bitmap bitmap) {

            }
        };
    }

}
