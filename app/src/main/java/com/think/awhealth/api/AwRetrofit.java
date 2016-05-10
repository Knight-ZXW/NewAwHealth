package com.think.awhealth.api;

import android.os.Environment;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.think.awhealth.util.OkHttpUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public class AwRetrofit {
    final TinaGouApi tinaGouApi;
    final OkHttpClient okHttpClient;
    public AwRetrofit() {
        okHttpClient = new OkHttpClient();
        File cacheFile;
        Log.w("logger", Environment.getExternalStorageState() + "=" + Environment.MEDIA_MOUNTED);
        cacheFile = Environment.getExternalStorageDirectory();
//        cacheFile = App.getInstance().getExternalCacheDir();
        okHttpClient.setCache(new Cache(cacheFile, 1024 * 1024 * 10));
        okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
        okHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
        okHttpClient.networkInterceptors().add(OkHttpUtils.getCacheControlInterceptor());

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://www.tngou.net/api/")
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Retrofit ZousRetrofit = builder.build();
        this.tinaGouApi = ZousRetrofit.create(TinaGouApi.class);
    }

    public TinaGouApi getTianGouApi() {
        return tinaGouApi;
    }

    public OkHttpClient getOkHttpClient(){
        return okHttpClient;
    }

}
