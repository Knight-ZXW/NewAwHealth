package com.think.awhealth.ui.search;

import android.content.Intent;
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
        ButterKnife.inject(this);
    }

    @OnClick({R.id.img_search_disease, R.id.img_search_drug})
    public void onClick(View view) {
        //跳转的Activity
        Class searchActivity = null;
        //dialog 的title
        String dialogTitle = "";
        switch (view.getId()) {
            case R.id.img_search_disease:
                dialogTitle = "查询疾病";
                searchActivity = SearchDiseaseResultActivity.class;
                break;
            case R.id.img_search_drug:
                dialogTitle = "查询药品";
                searchActivity = SearchDrugResultActivity.class;
                break;
            default:
                break;
        }
        SearchAlertDialog searchAlertDialog = new SearchAlertDialog(this);

        searchAlertDialog.setDialogTitle(dialogTitle);

        final Class finalSearchActivity = searchActivity;
        searchAlertDialog.setOnPositiveBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchKey = searchAlertDialog.getSearchKey();
                gotoSearchActivityWithKey(finalSearchActivity, searchKey);
                searchAlertDialog.getRealAlertDialog().dismiss();
            }
        });
    }

    private void gotoSearchActivityWithKey(Class activity, String searchKey) {
        Intent intent = new Intent();
        intent.putExtra("name", searchKey);
        intent.setClass(this, activity);
        startActivity(intent);
    }

}
