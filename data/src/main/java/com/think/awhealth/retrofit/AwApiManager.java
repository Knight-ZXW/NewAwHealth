package com.think.awhealth.retrofit;

import android.os.Environment;
import android.util.Log;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.File;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class AwApiManager implements IAwApiManger {
    public static final Object key = new Object();
    public static TinaGouApi tianGouApi;
    public static OkHttpClient tianGouOkHttpClient;
    private static AwRetrofit awRetrofit;
    //todo 初始化，这个应该在application中调用
    public static void init(){
        if (tianGouApi == null){
            synchronized (key){
                if (tianGouApi == null){
                    //todo init HttpClient
                    tianGouOkHttpClient = new OkHttpClient();
                    File cacheFile;
                    Log.w("logger", Environment.getExternalStorageState() + "=" + Environment.MEDIA_MOUNTED);
                    cacheFile = Environment.getExternalStorageDirectory();
//        cacheFile = App.getInstance().getExternalCacheDir();
                    tianGouOkHttpClient.setCache(new Cache(cacheFile, 1024 * 1024 * 10));

                    tianGouOkHttpClient.setReadTimeout(10, TimeUnit.SECONDS);
                    tianGouOkHttpClient.setWriteTimeout(10, TimeUnit.SECONDS);

                    awRetrofit = new AwRetrofit(tianGouOkHttpClient);
                    tianGouApi = awRetrofit.getTianGouApi();
                    tianGouOkHttpClient = awRetrofit.getOkHttpClient();
                }
            }
        }
    }
    public  static TinaGouApi getSingleTinaGouApi() {

        return tianGouApi;
    }
    public static TinaGouApi getTianGouApi() {
        return tianGouApi;
    }

    public static OkHttpClient getOkHttpClient(){
        return tianGouOkHttpClient;
    }
}
