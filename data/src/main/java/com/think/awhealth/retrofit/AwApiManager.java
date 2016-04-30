package com.think.awhealth.retrofit;

import com.squareup.okhttp.OkHttpClient;

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
    public void init(){
        getSingleTinaGouApi();
    }
    public AwRetrofit getSingleTinaGouApi() {
        if (tianGouApi == null){
            synchronized (key){
                if (tianGouApi == null){
                    //todo init HttpClient
                    awRetrofit = new AwRetrofit(null);
                    tianGouApi = awRetrofit.getTianGouApi();
                    tianGouOkHttpClient = awRetrofit.getOkHttpClient();
                }
            }
        }
        return null;
    }
    public static TinaGouApi getTianGouApi() {
        return tianGouApi;
    }

    public static OkHttpClient getOkHttpClient(){
        return tianGouOkHttpClient;
    }
}
