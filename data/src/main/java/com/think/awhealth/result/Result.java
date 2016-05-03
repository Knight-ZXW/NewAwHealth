package com.think.awhealth.result;

/**
 * Created by Zousfu on 2016/4/30.
 * Email:nimdanoob@163.com
 */
public class Result<T> {
    boolean success;

    public enum REASON {NETWORK_FAILED, DB_ACTION_FAILED}

    public static int NETWORK_FAILED = 0x1;
    public static int DB_ACTION_FAILED = 0x2;

    T resultData;
    REASON reason;

    public Result() {
    }

    public Result(T resultData) {
        this.resultData = resultData;
        setSuccess(true);
    }

    public T getData() {
        return resultData;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    ;

    public Result setReason(REASON reason) {
        this.reason = reason;
        return this;
    }

}
