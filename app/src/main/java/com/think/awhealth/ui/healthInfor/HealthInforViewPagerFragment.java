package com.think.awhealth.ui.healthInfor;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.think.awhealth.R;
import com.think.awhealth.ui.adapter.NewsPagerAdapter;
import com.think.awhealth.ui.base.ViewPagerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthInforViewPagerFragment extends ViewPagerFragment {

    private NewsPagerAdapter mNewsPagerAdapter;

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_health_infor;
    }

    @Override
    protected PagerAdapter providePagerAdapter() {
        if (mNewsPagerAdapter == null){
        mNewsPagerAdapter = new NewsPagerAdapter(getActivity().getSupportFragmentManager());
        Log.w("looger","mNewsPagerAdapter is null");
        }
        return mNewsPagerAdapter;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.w("logger","healthInforViewPagerFragment onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.w("logger","healthInforViewPagerFragment onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.w("logger","healthInforViewPagerFragment onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Log.w("logger","healthInforViewPagerFragment onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.w("logger","healthInforViewPagerFragment onDestroy");
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.w("logger","healthInforViewPagerFragment onAttach");

    }

    @Override
    public void onDetach() {
        Log.w("logger","healthInforViewPagerFragment onDetach");
        super.onDetach();
    }
}
