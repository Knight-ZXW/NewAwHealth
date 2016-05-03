package com.think.awhealth.model.dataSource.remote;

import android.support.annotation.NonNull;

import com.think.awhealth.bean.entity.Disease;
import com.think.awhealth.model.IDiseaseModel;
import com.think.awhealth.result.Result;

import rx.Observable;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class DiseaseRemoteModel implements IDiseaseModel{
    @Override
    public Observable<Result<Disease>> queryDiseaseByName(@NonNull String name) {
        return null;
    }
}
