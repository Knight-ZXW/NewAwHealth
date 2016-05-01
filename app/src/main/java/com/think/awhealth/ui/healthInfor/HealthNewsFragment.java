package com.think.awhealth.ui.healthInfor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.think.awhealth.R;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.ui.adapter.RecyclerNewsAdapter;
import com.think.awhealth.ui.base.SwipeRefreshBaseFragment;

import java.util.ArrayList;
import java.util.List;

import static com.think.awhealth.util.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthNewsFragment extends SwipeRefreshBaseFragment implements HealthInforContract.View{
    /**
     * 数据的类别
     */
    private int mClassId;
    /**
     * 已经加载的页数
     */
    private int currentPage;
    private HealthInforContract.Presenter mPresenter;

    //todo 如果是单一简单逻辑的 界面可以考虑将presenter的声明周期流程写到父类
    //  可能存在 一个Fragment 对应多个presenter 的情况
    @Override
    public void setPresenter(HealthInforContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        Log.w("zxw","正在加载中");
    }


    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        Log.w("zxw","加载出错了");

    }

    @Override
    protected void scrollToBottom() {
        mPresenter.loadHealthInfors(mClassId,++currentPage);
    }

    @Override
    public void additionMoreHealthInforView(List<HealthInfor> healthInfors) {
        mDatas.addAll(healthInfors);
        mAdapter.notifyDataSetChanged();
    }
    private ArrayList<HealthInfor> mDatas;
    private static final String CLASSID = "classId";

    public static HealthNewsFragment newInstance(int classId) {
        Bundle args = new Bundle();
        args.putInt(CLASSID,classId);
        HealthNewsFragment fragment = new HealthNewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public HealthNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        mClassId = arguments.getInt(CLASSID);
        return inflater.inflate(R.layout.fragment_health_news, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected RecyclerView.Adapter<?> provideRecyclerAdapter() {
        mDatas = new ArrayList<>();
        RecyclerNewsAdapter adapter = new RecyclerNewsAdapter(mDatas);
        adapter.setOnCardClickListener(new RecyclerNewsAdapter.onCardClickListener() {
            @Override
            public void onCradItemClick(int id,TextView view) {
                int InforId = mDatas.get(id).getId();
//                ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
//                        getActivity(), view, HealthInforDetailActivity.View_HEADER_TITLE);
                Intent intent = new Intent(getActivity(),HealthInforDetailActivity.class);
                intent.putExtra("InforId", InforId);
                startActivity(intent);
//                ActivityCompat.startActivity(getActivity(), intent, activityOptions.toBundle());
            }
        });
        return adapter;
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }



}
