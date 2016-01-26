package com.think.awhealth.ui.commonFragment;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.think.awhealth.R;
import com.think.awhealth.data.entity.HealthInfor;
import com.think.awhealth.ui.adapter.RecyclerNewsAdapter;
import com.think.awhealth.ui.base.SwipeRefreshBaseFragment;

import java.util.ArrayList;

import butterknife.InjectView;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthNewsFragment extends SwipeRefreshBaseFragment {
    @InjectView(R.id.id_recyclerView)
    RecyclerView mRecyclerView;

    private int mClassId;
    private ArrayList<HealthInfor> mDatas;
    private RecyclerNewsAdapter mAdapter;


    private static final String CLASSID = "classId";
    private LinearLayoutManager layoutManager;

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
        // Inflate the layout for this fragment
        Bundle arguments = getArguments();
        mClassId = arguments.getInt(CLASSID,1);
        return inflater.inflate(R.layout.fragment_health_news, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initVariables();
        initViews(savedInstanceState);
        loadData();
    }



    private void initVariables() {
        mDatas = new ArrayList<>();
        mAdapter = new RecyclerNewsAdapter(mDatas);
        layoutManager = new LinearLayoutManager(getContext());

    }

    private void initViews(Bundle savedInstanceState) {
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(getOnBottomListener(layoutManager));
    }

    private void loadData() {
        setRefreshing(true);
        Subscription s = sTianGouApi.getHealthInforData(mClassId, 1)
                .map(healthInforData -> healthInforData.getHeathInfors())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(healthInfors -> {
                    mDatas.addAll(healthInfors);
                    mAdapter.notifyDataSetChanged();
                    setRefreshing(false);
                },throwable -> );
        addSubscription(s);
    }


    RecyclerView.OnScrollListener getOnBottomListener(LinearLayoutManager layoutManager){
        return new RecyclerView.OnScrollListener(){
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && !mSwipeRefreshLayout.isRefreshing()
                        && layoutManager.findLastVisibleItemPosition()+1 == mAdapter.getItemCount()){
                    loadData();
                    //todo load data
                }

            }
        };
    }

    private void loadError(Throwable throwable) {
        throwable.printStackTrace();
        setRefreshing(false);
        Snackbar.make(mRecyclerView, R.string.snap_load_fail,
                Snackbar.LENGTH_LONG).setAction(R.string.retry, v -> {
            loadData();
        }).show();
    }
}
