package com.think.awhealth.base;

import android.support.annotation.UiThread;

/**
 * Created by Zousfu on 2016/5/1.
 * Email:nimdanoob@163.com
 */
public interface BaseLceView<P> extends BaseView<P>{
    @Override
    void setPresenter(P presenter);

    @UiThread
    public void showLoading(boolean pullToRefresh);


    @UiThread void showError(Throwable e,boolean pullToRefresh);


}
