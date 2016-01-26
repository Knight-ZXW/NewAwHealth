package com.think.awhealth.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.think.awhealth.R;

import butterknife.InjectView;

/**
 * Created by XiuWuZhuo on 2016/1/26.
 * Emial:nimdanoob@163.com
 */
public abstract class ViewPagerFragment extends BaseFragment{
    @InjectView(R.id.id_viewPager)
    ViewPager mViewPager;
    @InjectView(R.id.id_tabLayout)
    TabLayout mTabLayout;
    public ViewPagerFragment() {
        // Required empty public constructor
    }

    protected abstract @LayoutRes int provideLayoutId();

    protected abstract PagerAdapter providePagerAdapter();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_health_infor, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        NewsPagerAdapter adapter = new NewsPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(providePagerAdapter());
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

}
