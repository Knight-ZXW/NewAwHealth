package com.think.awhealth.ui.adapter;

import android.content.Context;
import android.content.res.ObbInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.think.awhealth.Injection;
import com.think.awhealth.model.impl.remote.HealthInforRemoteDataSource;
import com.think.awhealth.ui.healthInfor.HealthInforPresenter;
import com.think.awhealth.ui.healthInfor.HealthNewsFragment;

/**
 * Created by XiuWuZhuo on 2016/1/25.
 * Emial:nimdanoob@163.com
 */
public class NewsPagerAdapter extends FragmentStatePagerAdapter{

    private int[] classId = new int[]{3,4,5,7};
    private String[] titles = new String[]{"生活贴士","药品新闻","食品新闻","疾病快讯"};
    private Context mContext;
    public NewsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        HealthNewsFragment healthNewsFragment = HealthNewsFragment.newInstance(classId[position]);
        healthNewsFragment.setPresenter(new HealthInforPresenter(classId[position], Injection.provideHealthRepository(mContext),healthNewsFragment));
        return healthNewsFragment;
    }

    @Override
    public int getCount() {
        return classId.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
