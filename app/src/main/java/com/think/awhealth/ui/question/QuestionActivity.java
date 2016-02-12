package com.think.awhealth.ui.question;

import android.os.Bundle;

import com.think.awhealth.R;
import com.think.awhealth.ui.base.ToolBarActivity;

public class QuestionActivity extends ToolBarActivity {

    private String[] str = new String[]{"健康常识","心理咨询","孕育指南","内科","外科","妇产科","儿科","皮肤科","五官科","男科","整容整形","中医","药物","体检","医院","其它疾病"};

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_question;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected boolean canBack() {
        return true;
    }
}
