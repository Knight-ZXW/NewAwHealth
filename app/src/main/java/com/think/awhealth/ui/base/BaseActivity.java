package com.think.awhealth.ui.base;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.think.awhealth.R;
import com.think.awhealth.api.AwFactory;
import com.think.awhealth.api.TinaGouApi;
import com.think.awhealth.util.NetWorkUtils;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    public static final TinaGouApi sTianGouIO = AwFactory.getSingleTinaGouApi();
    protected CompositeSubscription mCompositeSubscription;

    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        return mCompositeSubscription;
    }

    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(s);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }

    protected void showError(Throwable throwable) {
        throwable.printStackTrace();
        int messageResId;
        if (NetWorkUtils.getNetWorkTypeName(this) == NetWorkUtils.NETWORK_TYPE_DISCONNECT) {
            messageResId = R.string.network_state_disconnect;
        } else {
            messageResId = R.string.network_bad;
        }
        Snackbar.make(getWindow().getDecorView(), messageResId,
                Snackbar.LENGTH_LONG).setAction(R.string.retry, v -> {
            loadData();
        }).show();
    }


    /**
     * 空实现
     */
    protected void loadData() {
    }

    protected void setFirstShowingFragment(Fragment fragment) {
        if (fragment == null) {
            throw new IllegalStateException("fragment must be not null");
        }
        if (findViewById(R.id.id_fragmentContainer) == null) {
            throw new IllegalStateException("是否有一个id 为 id_fragmentContainer 的布局作为容器？");
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_fragmentContainer, fragment)
                .commit();
    }

}
