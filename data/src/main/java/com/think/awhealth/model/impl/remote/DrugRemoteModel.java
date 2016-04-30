package com.think.awhealth.model.impl.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.think.awhealth.bean.entity.Drug;
import com.think.awhealth.model.IDrugModel;
import com.think.awhealth.result.Result;

import java.util.List;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class DrugRemoteModel implements IDrugModel{
    @Override
    public Result<List<Drug>> searchDrug(@NonNull String keyword, @Nullable String type) {
        return null;
    }
}
