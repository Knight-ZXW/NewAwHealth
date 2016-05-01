package com.think.awhealth.ui.base;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.think.awhealth.R;
import com.think.awhealth.util.NetWorkUtils;
import com.think.awhealth.widget.MultiSwipeRefreshLayout;

import butterknife.InjectView;

/**
 * Created by XiuWuZhuo on 2016/1/25.
 * Emial:nimdanoob@163.com
 */
public abstract class SwipeRefreshBaseFragment extends BaseFragment{

    @InjectView(R.id.id_recyclerView)
    protected RecyclerView mRecyclerView;

    /**
     * 是否正在请求刷新数据
     */
    private boolean mIsRequestDataRefresh = false;
    public MultiSwipeRefreshLayout mSwipeRefreshLayout;
    protected RecyclerView.Adapter<?> mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = provideRecyclerAdapter();
        mLayoutManager = provideLayoutManager();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(getOnBottomListener(mLayoutManager));
        trySetupRefresh(view);
        scrollToBottom();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    protected abstract RecyclerView.Adapter<?> provideRecyclerAdapter();
    protected abstract RecyclerView.LayoutManager provideLayoutManager();
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
        mSwipeRefreshLayout.setRefreshing(true);
        scrollToBottom();
    };

    RecyclerView.OnScrollListener getOnBottomListener(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
            return new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == RecyclerView.SCROLL_STATE_IDLE && !mSwipeRefreshLayout.isRefreshing()
                            && ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() + 1 == mAdapter.getItemCount()) {
                        scrollToBottom();
                        //todo load data
                    }

                }
            };
        } else {
            return null;
        }
    }


    public void setRefreshing(boolean refreshing) {
        if (mSwipeRefreshLayout == null) {
            return;
        }
        if (!refreshing) {
            mIsRequestDataRefresh = false;
            // 防止刷新消失太快，让子弹飞一会儿
            mSwipeRefreshLayout.postDelayed(
                    () -> mSwipeRefreshLayout.setRefreshing(false), 1000);
        } else {
            requestDataRefresh();
        }
    }

    abstract protected void scrollToBottom();

     protected void catchError(Throwable throwable){
         setRefreshing(false);
         throwable.printStackTrace();
         int messageResId;
         if (NetWorkUtils.getNetWorkTypeName(getActivity()) == NetWorkUtils.NETWORK_TYPE_DISCONNECT) {
             messageResId =R.string.network_state_disconnect;
         } else {
             messageResId =R.string.snap_load_fail;
         }
         Snackbar.make(mRecyclerView, messageResId,
                 Snackbar.LENGTH_LONG).setAction(R.string.retry, v -> {
             scrollToBottom();
         }).show();
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
