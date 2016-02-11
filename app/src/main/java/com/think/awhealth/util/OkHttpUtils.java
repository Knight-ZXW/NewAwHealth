package com.think.awhealth.util;

import android.os.Environment;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.think.awhealth.App;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by XiuWuZhuo on 2016/1/26.
 * Emial:nimdanoob@163.com
 */
public class OkHttpUtils {
    private static OkHttpClient okHttpClient;

    private OkHttpUtils() {
    }

    public static void initOkHttpClient() {
        synchronized (OkHttpUtils.class) {
            okHttpClient = new OkHttpClient();
            File cacheFile;
            Log.w("logger", Environment.getExternalStorageState() + "=" + Environment.MEDIA_MOUNTED);

//            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//                cacheFile = new File(context.getExternalCacheDir().getAbsolutePath(),"externalcache");
//                Log.w("logger","jin1");
//            } else {
//                cacheFile = new File(context.getCacheDir().getAbsolutePath(),"cache");
//                Log.w("logger","jin2");
//            }
//            if (!cacheFile.exists()){
//                boolean mkdirs = cacheFile.mkdirs();
//                Log.w("logger","创建文件夹"+mkdirs);
//            }
            cacheFile = App.getInstance().getExternalCacheDir();
            okHttpClient.setCache(new Cache(cacheFile, 1024 * 1024 * 10));

            okHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
            okHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);
        }

    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static final String NOCACHE = "no-cache";
    private static final String ONLY_IF_CACHE = "only-if-cached";
    public static final int maxStale = 60 * 60;

    public static Interceptor getCacheControlInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                String cachestrategy = "";
                Log.w("logger", request.url().getPath());
                if (request.url().getPath().equals("/api/user")) {
                    cachestrategy = ONLY_IF_CACHE;
                } else {
                    cachestrategy = ONLY_IF_CACHE;
                }
                request.newBuilder()
                        .header("Cache-Control", cachestrategy);
                Log.w("logger", "缓存策略" + cachestrategy);
                String format = String.format("MyInterceptor:Sending request url=%s%n connection=%s%n headers=%s",
                        request.url(), chain.connection(), request.headers());
                Log.w("logger", format);
                Response response = chain.proceed(request);
                Log.w("looger","response:"+response.message());
                Log.w("logger", "Response 1 cache response:    " + response.cacheResponse());
                Log.w("logger", "Response 1 network response:  " + response.networkResponse());
                return response.newBuilder().header("Cache-Control", "public, max-age=86400").build();
            }
        };
    }


}
