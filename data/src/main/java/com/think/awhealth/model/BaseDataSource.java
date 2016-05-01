package com.think.awhealth.model;

import com.think.awhealth.retrofit.AwApiManager;
import com.think.awhealth.retrofit.TinaGouApi;

import javax.xml.transform.Transformer;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public interface BaseDataSource {
//    public static int SUCCESS = 0x1;
//    public static int NETWORK_FAILED =0x2;
//    void setTaskResultTag(int tag);
//    int getTaskResultTag();
    public static final TinaGouApi sTianGouApi = AwApiManager.getTianGouApi();

}
