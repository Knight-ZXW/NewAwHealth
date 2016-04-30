package com.think.awhealth.ui.healthInfor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.think.awhealth.R;
import com.think.awhealth.bean.entity.HealthInfor;
import com.think.awhealth.ui.adapter.RecyclerNewsAdapter;
import com.think.awhealth.ui.base.SwipeRefreshBaseFragment;

import java.util.ArrayList;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthNewsFragment extends SwipeRefreshBaseFragment {
    /**
     * 数据的类别
     */
    private int mClassId;
    /**
     * 已经加载的页数
     */
    private int currentPage;
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
     protected void loadData() {
        Subscription s = sTianGouApi.getHealthInforData(mClassId, ++currentPage)
                .map(healthInforData -> healthInforData.getHeathInfors())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(healthInfors -> {
                    if (healthInfors!=null) {
                        mDatas.addAll(healthInfors);
                        mAdapter.notifyDataSetChanged();
                    }
                    setRefreshing(false);
                }, throwable -> {
                    HealthNewsFragment.this.loadError(throwable);
                });
        addSubscription(s);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
