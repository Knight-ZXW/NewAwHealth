package com.think.awhealth.model;

import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.model.impl.BaseModelImpl;
import com.think.awhealth.result.Result;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;


/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public interface IHealthInfoModel extends BaseModel {
    Observable<Result<List<HealthInfor>>> getHealthInforsByClassId(int classId, int page);
    Observable<Result<HealthInfor>> getHealthInforDetail(int healthInforId);
}
