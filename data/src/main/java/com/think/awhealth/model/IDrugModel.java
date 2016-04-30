package com.think.awhealth.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.think.awhealth.bean.entity.Drug;
import com.think.awhealth.result.Result;

import java.util.List;

import retrofit.http.Query;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public interface IDrugModel {
    Result<List<Drug>> searchDrug(@NonNull String keyword, @Nullable String type);
}
