package com.think.awhealth.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.think.awhealth.R;
import com.think.awhealth.ui.base.ToolBarActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SearchActivity extends ToolBarActivity {

    @InjectView(R.id.img_search_disease)
    ImageView mImgSearchDisease;
    @InjectView(R.id.img_search_drug)
    ImageView mImgSearchDrug;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_search;
    }

    @Override
    protected boolean canBack() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.img_search_disease, R.id.img_search_drug})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_search_disease:
                break;
            case R.id.img_search_drug:
                break;
        }
    }
}
