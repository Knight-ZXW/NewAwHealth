package com.think.awhealth.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.think.awhealth.api.AwFactory;
import com.think.awhealth.api.TinaGouApi;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by XiuWuZhuo on 2016/1/25.
 * Emial:nimdanoob@163.com
 */
public class BaseFragment extends Fragment{
    public static final TinaGouApi sTianGouApi = AwFactory.getSingleTinaGouApi();
    private CompositeSubscription mCompositeSubscription;

    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        return this.mCompositeSubscription;
    }


    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }

        this.mCompositeSubscription.add(s);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this,view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
        if (this.mCompositeSubscription != null){
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
