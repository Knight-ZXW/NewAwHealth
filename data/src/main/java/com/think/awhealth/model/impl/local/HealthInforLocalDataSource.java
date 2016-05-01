package com.think.awhealth.model.impl.local;

import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.model.IHealthInfoDataSource;
import com.think.awhealth.model.impl.remote.HealthInforRemoteDataSource;
import com.think.awhealth.result.Result;

import java.util.List;

import rx.Observable;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class HealthInforLocalDataSource implements IHealthInfoDataSource {

    private static HealthInforLocalDataSource INSTANCE;

    private HealthInforLocalDataSource() {
    }
    public static HealthInforLocalDataSource getINSTANCE(){
        if (INSTANCE == null){
            INSTANCE = new HealthInforLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<Result<List<HealthInfor>>> getHealthInforsByClassId(int classId, int page) {
        return Observable.empty();
    }

    @Override
    public Observable<Result<HealthInfor>> getHealthInforDetail(int healthInforId) {
        return Observable.empty();
    }
}
