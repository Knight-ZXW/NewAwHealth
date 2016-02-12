package com.think.awhealth.ui.search;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.think.awhealth.R;
import com.think.awhealth.data.entity.Disease;
import com.think.awhealth.ui.base.BaseToolBarAndNetWorkActivity;
import com.think.awhealth.widget.TitleWithContentView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchDiseaseResultActivity extends BaseToolBarAndNetWorkActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @InjectView(R.id.id_titleWithContent_caretext)
    TitleWithContentView mCareText;
    @InjectView(R.id.id_titleWithContent_sysmtext)
    TitleWithContentView mSysmtext;
    @InjectView(R.id.id_titleWithContent_causetext)
    TitleWithContentView mCausetext;
    @InjectView(R.id.id_titleWithContent_checks)
    TitleWithContentView mChecks;
    @InjectView(R.id.id_titleWithContent_checktext)
    TitleWithContentView mChecktext;
    @InjectView(R.id.id_titleWithContent_food)
    TitleWithContentView mFood;
    @InjectView(R.id.id_titleWithContent_foodtext)
    TitleWithContentView mFoodtext;
    private String mDiseaseName;

    @Override
    protected int provideContentViewId() {

        return R.layout.activity_search_diseas_result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.inject(this);
        mDiseaseName = getIntent().getStringExtra("name");
        loadData();
    }

    @Override
    protected boolean canBack() {
        return true;
    }

    @Override
    protected void loadData() {
        super.loadData();
        sTianGouIO.getDiseaseByName(mDiseaseName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(disease -> {
                    if (disease.getName()!=null) {
                        setDiseaseViewContent(disease);
                    } else {
                        Toast.makeText(SearchDiseaseResultActivity.this,"无查询结果",Toast.LENGTH_SHORT).show();
                        onBackPressed();
                    }
                    Log.w("logger", "loaddata" + disease);
                }, throwable -> showError(throwable));

    }

    private void setDiseaseViewContent(Disease disease) {
        mCareText.setTitleText("描述：");
        mCareText.setContentView(disease.getCaretext());
        mCausetext.setTitleText("病发原因：");
        mCausetext.setContentView(disease.getCausetext());
        mCareText.setTitleText("注意事项：");
        mCareText.setContentView(disease.getCaretext());
        mChecks.setTitleText("常规检验：");
        mChecks.setContentView(disease.getChecks());
        mChecktext.setTitleText("一般检验结果：");
        mChecktext.setContentView(disease.getCausetext());
        mSysmtext.setTitleText("症状：");
        mSysmtext.setContentView(disease.getSymptomtext());
        mFood.setTitleText("食疗：");
        mFood.setContentView(disease.getFood());
        mFoodtext.setTitleText("食疗配方：");
        mFoodtext.setContentView(disease.getFoodtext());

    }

    @OnClick(R.id.id_titleWithContent_caretext)
    public void onClick() {
    }
}
