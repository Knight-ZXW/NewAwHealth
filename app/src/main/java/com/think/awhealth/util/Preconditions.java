package com.think.awhealth.util;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */
public class Preconditions {
    public static <T> T checkNotNull(T reference){
        if (reference == null){
            throw  new NullPointerException();
        }
        return reference;
    }
}
