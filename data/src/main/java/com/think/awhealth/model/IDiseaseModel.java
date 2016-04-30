package com.think.awhealth.model;

import android.support.annotation.NonNull;

import com.think.awhealth.bean.entity.Disease;
import com.think.awhealth.result.Result;

import rx.Observable;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public interface IDiseaseModel {
    Observable<Result<Disease>>queryDiseaseByName(@NonNull String name);

}
