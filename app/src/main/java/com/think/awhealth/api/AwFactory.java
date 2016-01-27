package com.think.awhealth.api;

import com.squareup.okhttp.OkHttpClient;

/**
 * Created by XiuWuZhuo on 2016/1/24.
 * Emial:nimdanoob@163.com
 */
public class AwFactory {
    public static final Object key = new Object();
    public static TinaGouApi tianGouApi;
    public static OkHttpClient tianGouOkHttpClient;
    private static AwRetrofit awRetrofit;

    public static TinaGouApi getSingleTinaGouApi() {
        if (tianGouApi == null){
            synchronized (key){
                if (tianGouApi == null){
                    awRetrofit = new AwRetrofit();
                    tianGouApi = awRetrofit.getTianGouApi();
                    tianGouOkHttpClient = awRetrofit.getOkHttpClient();
                }
            }
        }
        return tianGouApi;
    }
    public static OkHttpClient getTianGouApiOkHttpClient(){
        return tianGouOkHttpClient;
    }

}
