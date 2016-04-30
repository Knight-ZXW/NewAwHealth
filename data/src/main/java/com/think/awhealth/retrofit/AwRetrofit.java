package com.think.awhealth.retrofit;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class AwRetrofit {
    final TinaGouApi tinaGouApi;
    final OkHttpClient okHttpClient;

    public AwRetrofit(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
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
