package com.think.awhealth.api;

import com.think.awhealth.data.HealthInforData;
import com.think.awhealth.data.entity.HealthInfor;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public interface TinaGouApi {
    @GET("info/list")
    abstract Observable<HealthInforData> getHealthInforData(@Query("id")int classifyId,@Query("page")int page);
    @GET("info/show")
    Observable<HealthInfor> getHealthInforDetail(@Query("id")int itemId);
}
