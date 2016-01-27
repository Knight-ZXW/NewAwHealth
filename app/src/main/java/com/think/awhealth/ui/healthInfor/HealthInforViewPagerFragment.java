package com.think.awhealth.ui.healthInfor;


import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;

import com.think.awhealth.R;
import com.think.awhealth.ui.adapter.NewsPagerAdapter;
import com.think.awhealth.ui.base.ViewPagerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HealthInforViewPagerFragment extends ViewPagerFragment {
    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_health_infor;
    }

    @Override
    protected PagerAdapter providePagerAdapter() {
        return new NewsPagerAdapter(getActivity().getSupportFragmentManager());
    }
}
