package com.think.awhealth.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.think.awhealth.api.AwFactory;

import java.io.File;
import java.io.IOException;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by XiuWuZhuo on 2016/1/27.
 * Emial:nimdanoob@163.com
 */
public class AppUtils {
    public static void shwoErrorMessage() {

    }

    public static Html.ImageGetter getHtmlImageGetter() {
        return new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                return null;

            }
        };
    }

    public static long getFileCacheSizeIfConfigIsDefault(Context context){
        try {
            long tianGouApiCaCheSize = AwFactory.getTianGouApiOkHttpClient().getCache().getSize();
            //如果Fresco 用的是默认配置，则缓存文件的文件名是确定的
            File cacheDir = new File(context.getCacheDir().getAbsolutePath()+"/image_cache");
            long frescoCacheSize = FileUtils.getFileOrDirectorySize(cacheDir);
            ImagePipeline imagePipeline = Fresco.getImagePipeline();
            return tianGouApiCaCheSize+frescoCacheSize;
        } catch (IOException e) {
            e.printStackTrace();
            Log.w("logger","cache error"+e.getStackTrace()+"\n,Message"+e.getMessage());
        }
        return 0;
    }
    public static void ClearAllCache(){
        try {
            AwFactory.getTianGouApiOkHttpClient().getCache().delete();
            Fresco.getImagePipeline().clearCaches();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用IO 线程去读取线程，避免文件很多阻塞住UI线程
     * @param context 用来获取缓存的文件路径
     * @return
     */
    public static Observable getRxFileCacheSize(Context context){
        return Observable.defer(()->Observable.just(getFileCacheSizeIfConfigIsDefault(context)))
                .subscribeOn(Schedulers.io());
    }
}
