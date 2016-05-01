package com.think.awhealth.model.impl.remote;

import com.think.awhealth.bean.HealthInforData;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.model.IHealthInfoDataSource;
import com.think.awhealth.result.Result;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;


/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class HealthInforRemoteDataSource implements IHealthInfoDataSource {

    private static HealthInforRemoteDataSource INSTANCE;

    private HealthInforRemoteDataSource() {
    }
    public static HealthInforRemoteDataSource getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new HealthInforRemoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<Result<List<HealthInfor>>> getHealthInforsByClassId(int classId, int page) {
        Observable<HealthInforData> healthInforData = sTianGouApi.getHealthInforData(classId, page);
        return healthInforData.flatMap(new Func1<HealthInforData, Observable<Result<List<HealthInfor>>>>() {
            @Override
            public Observable<Result<List<HealthInfor>>> call(HealthInforData healthInforData) {
                List<HealthInfor> heathInfors = healthInforData.getHeathInfors();
                Result<List<HealthInfor>> result = new Result<List<HealthInfor>>(heathInfors);
                result.setSuccess(true);
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
