package com.think.awhealth.ui.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;

import com.think.awhealth.R;
import com.think.awhealth.widget.MultiSwipeRefreshLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by XiuWuZhuo on 2016/1/23.
 * Emial:nimdanoob@163.com
 */
public abstract class SwipeRefreshBaseActivity extends ToolBarActivity{
    @InjectView(R.id.swipe_refresh_layout) public MultiSwipeRefreshLayout mSwipeRefreshLayout;
    private boolean mIsRequestDataRefresh = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        trySetupSwipeRefresh();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void trySetupSwipeRefresh() {
        if (mSwipeRefreshLayout != null){
            mSwipeRefreshLayout.setColorSchemeColors(R.color.refresh_progress_1,R.color.refresh_progress_2,R.color.refresh_progress_3);
            mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    requestDataRefresh();
                }
            });
        }
    }

    private void requestDataRefresh() {
        mIsRequestDataRefresh = true;
    }

    public void setRequestDataRefresh(boolean requestDataRefresh){
        if (mSwipeRefreshLayout ==null){
            return;
        }
        //怕数据加载太快，没有refreshing的动画，我艹
        if (!requestDataRefresh){
            mIsRequestDataRefresh = false;
            mSwipeRefreshLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mSwipeRefreshLayout != null){
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }
            },1000);
        } else {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }
    public void setProgressViewOffset(boolean scale,int start,int end){
        mSwipeRefreshLayout.setProgressViewOffset(scale,start,end);
    }

    public void  setSwipeCanChildScrollUpCallback(MultiSwipeRefreshLayout.CanChildScrollUpCallback canChildScrollUpCallback){
        mSwipeRefreshLayout.setCanChildScrollUpCallback(canChildScrollUpCallback);
    }

    public boolean isRequestDataRefresh(){
        return mIsRequestDataRefresh;
    }


}
