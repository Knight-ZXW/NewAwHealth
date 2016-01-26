package com.think.awhealth.api;

import android.view.ViewGroup;

import com.squareup.okhttp.OkHttpClient;

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

    public AwRetrofit() {
        OkHttpClient client = new OkHttpClient();
//            client.interceptors()
//                    .add(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
//                            Request request = chain.request();
//                            String format = String.format("Interceptor:Sending request url=%s%n connection=%s%n headers=%s",
//                                    request.url(), chain.connection(), request.headers());
//                            Log.w("logger", format);
//                            Response response = chain.proceed(request);
//                            String string = response.body().string();
//                            Log.w("logger",string);
//                            return response;
//                        }
//                    });
        client.setReadTimeout(12, TimeUnit.SECONDS);
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("http://www.tngou.net/api/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Retrofit ZousRetrofit = builder.build();
        this.tinaGouApi = ZousRetrofit.create(TinaGouApi.class);
    }

    public TinaGouApi getTianGouApi() {
        return tinaGouApi;
    }

}
