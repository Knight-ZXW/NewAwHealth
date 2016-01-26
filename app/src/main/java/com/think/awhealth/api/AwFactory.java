package com.think.awhealth.api;

/**
 * Created by XiuWuZhuo on 2016/1/24.
 * Emial:nimdanoob@163.com
 */
public class AwFactory {
    public static final Object key = new Object();
    public static TinaGouApi tinaGouApi;
    public static TinaGouApi getSingleTinaGouApi() {
        if (tinaGouApi == null){
            synchronized (key){
                if (tinaGouApi == null){
                    tinaGouApi = new AwRetrofit().getTianGouApi();
                }
            }
        }
        return tinaGouApi;
    }
}
