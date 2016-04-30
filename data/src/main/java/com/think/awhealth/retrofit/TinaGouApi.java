package com.think.awhealth.retrofit;

import com.think.awhealth.bean.DrugSearchData;
import com.think.awhealth.bean.HealthInforData;
import com.think.awhealth.bean.QuestoinsData;
import com.think.awhealth.bean.entity.Disease;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.bean.entity.QuestionDetail;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public interface TinaGouApi {
    @GET("info/list")
    Observable<HealthInforData> getHealthInforData(@Query("id") int classifyId, @Query("page") int page);
    @GET("info/show")
    Observable<HealthInfor> getHealthInforDetail(@Query("id") int id);
    @GET("search?name=drug")
    Observable<DrugSearchData> getDrugData(@Query("keyword") String keyword, @Query("type") String type);
    @GET("disease/name?")
    Observable<Disease> getDiseaseByName(@Query("name") String name);
    @GET("ask/list?")
    Observable<QuestoinsData> getQuestionsById(@Query("id") int id, @Query("rows") int row);
    @GET("ask/show?")
    Observable<QuestionDetail> getQuestionDetailByQId(@Query("id") int id);
}
