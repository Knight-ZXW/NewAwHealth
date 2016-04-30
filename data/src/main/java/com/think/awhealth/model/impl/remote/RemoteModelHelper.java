package com.think.awhealth.model.impl.remote;

import java.util.List;

import javax.xml.transform.Transformer;

import rx.Observable;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class RemoteModelHelper {
    public static Transformer verifyResult(Object object) {
    return null;
    }


    public static boolean notNull(Object object) {
        if (object != null) return true;
        else return false;
    }

    public static boolean notEmpty(List data) {
        if (notNull(data) && data.size() != 0) return true;
        return false;
    }
}
