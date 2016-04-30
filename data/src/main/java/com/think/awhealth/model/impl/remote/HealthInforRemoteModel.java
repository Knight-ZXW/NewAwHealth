package com.think.awhealth.model.impl.remote;

import com.think.awhealth.bean.HealthInforData;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.model.IHealthInfoModel;
import com.think.awhealth.result.Result;
import com.think.awhealth.retrofit.AwRetrofit;

import java.util.List;
import java.util.Map;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;


/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class HealthInforRemoteModel implements IHealthInfoModel {


    @Override
    public Observable<Result<List<HealthInfor>>> getHealthInforsByClassId(int classId, int page) {
        Observable<HealthInforData> healthInforData = sTianGouApi.getHealthInforData(classId, page);
        return healthInforData.flatMap(new Func1<HealthInforData, Observable<Result<List<HealthInfor>>>>() {
            @Override
            public Observable<Result<List<HealthInfor>>> call(HealthInforData healthInforData) {
                List<HealthInfor> heathInfors = healthInforData.getHeathInfors();
                Result<List<HealthInfor>> result = new Result<List<HealthInfor>>(heathInfors);
                return Observable.just(result);
            }
        });
    }

    @Override
    public Observable<Result<HealthInfor>> getHealthInforDetail(int healthInforId) {
        sTianGouApi.getHealthInforDetail(healthInforId);
        return null;
    }


}
