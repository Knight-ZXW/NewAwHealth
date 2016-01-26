package com.think.awhealth.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.think.awhealth.api.AwFactory;
import com.think.awhealth.api.TinaGouApi;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public abstract class BaseActivity extends AppCompatActivity{

    public static final TinaGouApi sTianGouIO = AwFactory.getSingleTinaGouApi();
    private CompositeSubscription mCompositeSubscription;

    public CompositeSubscription getCompositeSubscription(){
        if (this.mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }
        return mCompositeSubscription;
    }

    public void addSubscription(Subscription s){
        if (this.mCompositeSubscription == null){
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null){
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
