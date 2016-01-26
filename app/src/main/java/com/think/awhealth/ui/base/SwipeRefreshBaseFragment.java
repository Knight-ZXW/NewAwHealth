package com.think.awhealth.ui.base;

import android.os.Bundle;
import android.view.View;

import com.think.awhealth.R;
import com.think.awhealth.widget.MultiSwipeRefreshLayout;

/**
 * Created by XiuWuZhuo on 2016/1/25.
 * Emial:nimdanoob@163.com
 */
public abstract class SwipeRefreshBaseFragment extends BaseFragment{
    private boolean mIsRequestDataRefresh = false;
    public MultiSwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trySetupRefresh(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void trySetupRefresh(View root) {
        mSwipeRefreshLayout = (MultiSwipeRefreshLayout) root.findViewById(R.id.swipe_refresh_layout);
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setColorSchemeResources(R.color.refresh_progress_3,
                    R.color.refresh_progress_2, R.color.refresh_progress_1);
            mSwipeRefreshLayout.setOnRefreshListener(() -> requestDataRefresh());
        }
    }

    private void  requestDataRefresh(){
        mIsRequestDataRefresh = true;
    };

    public void setRefreshing(boolean refreshing) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!refreshing) {
            mIsRequestDataRefresh = false;
            // 防止刷新消失太快，让子弹飞一会儿
            mSwipeRefreshLayout.postDelayed(
                    () -> mSwipeRefreshLayout.setRefreshing(false), 1000);
        }
        else {
            mIsRequestDataRefresh =true;
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }


    public void setProgressViewOffset(boolean scale, int start, int end) {
        mSwipeRefreshLayout.setProgressViewOffset(scale, start, end);
    }


    public void setSwipeableChildren(MultiSwipeRefreshLayout.CanChildScrollUpCallback canChildScrollUpCallback) {
        mSwipeRefreshLayout.setCanChildScrollUpCallback(canChildScrollUpCallback);
    }

    public boolean isRequestDataRefresh(){
        return mIsRequestDataRefresh;
    }


}
