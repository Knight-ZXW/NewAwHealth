package com.think.awhealth.model.healthInfo;

import android.support.annotation.NonNull;

import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.model.IHealthInfoDataSource;
import com.think.awhealth.model.impl.local.HealthInforLocalDataSource;
import com.think.awhealth.model.impl.remote.HealthInforRemoteDataSource;
import com.think.awhealth.result.Result;

import java.util.HashMap;
import java.util.List;
import java.util.logging.MemoryHandler;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */
public class HealthInforRepository implements IHealthInfoDataSource{

    private static HealthInforRepository INSTANCE = null;

    private final HealthInforLocalDataSource mHealthInforLocalDataSource;
    private final HealthInforRemoteDataSource mHealthInforRemoteDataSource;

    private HealthInforRepository(@NonNull HealthInforLocalDataSource localDataSource,@NonNull HealthInforRemoteDataSource remoteDataSource){
        mHealthInforLocalDataSource = localDataSource;
        mHealthInforRemoteDataSource = remoteDataSource;
    }

    public static HealthInforRepository getInstance(HealthInforLocalDataSource localDataSource,HealthInforRemoteDataSource remoteDataSource){
        if (INSTANCE == null){
            INSTANCE = new HealthInforRepository(localDataSource,remoteDataSource);
        }
        return INSTANCE;
    }

    public static void destoryInstance(){
        INSTANCE = null;
    }

    @Override
    public Observable<Result<List<HealthInfor>>> getHealthInforsByClassId(int classId, int page) {
        Observable<Result<List<HealthInfor>>> remoteHealthInfor = mHealthInforRemoteDataSource
                .getHealthInforsByClassId(classId, page)
                .doOnNext(new Action1<Result<List<HealthInfor>>>() {
                    @Override
                    public void call(Result<List<HealthInfor>> listResult) {
                        //todo  save HealthInfor toDb
                    }
                });
        Observable<Result<List<HealthInfor>>> localHealthInfor = mHealthInforLocalDataSource
                .getHealthInforsByClassId(classId, page)
                .doOnNext(new Action1<Result<List<HealthInfor>>>() {
                    @Override
                    public void call(Result<List<HealthInfor>> listResult) {
                        //todo 可以在该Repostiory中 设置一个局部变量，在内存中缓存数据
                    }
                });

        return Observable.concat(localHealthInfor,remoteHealthInfor).first();
    }

    @Override
    public Observable<Result<HealthInfor>> getHealthInforDetail(int healthInforId) {
        return null;
    }
}
