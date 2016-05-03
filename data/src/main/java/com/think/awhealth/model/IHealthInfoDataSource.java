package com.think.awhealth.model;

import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.result.Result;

import java.util.List;

import rx.Observable;


/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public interface IHealthInfoDataSource extends BaseDataSource {
    Observable<Result<List<HealthInfor>>> getHealthInforsByClassId(int classId, int page);
    Observable<Result<HealthInfor>> getHealthInforDetail(int healthInforId);
    Observable<Result> collectHealthInfor(int HealthInforId);
}
