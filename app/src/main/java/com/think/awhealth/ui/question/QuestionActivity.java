package com.think.awhealth.ui.question;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.think.awhealth.R;
import com.think.awhealth.ui.base.ToolBarActivity;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

public class QuestionActivity extends ToolBarActivity {

    private String[] className = new String[]{"健康常识","心理咨询","孕育指南","内科","外科","妇产科","儿科","皮肤科","五官科","男科","整容整形","中医","药物","体检","医院","其它疾病"};

    public static final String EVENT_TAG_FORWARD_FRAGMENT ="QuestionActivity_tag_1";
    private QuestionClazzFragment mFirstShowFragment;

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_question;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        mFirstShowFragment = new QuestionClazzFragment();
        setFirstShowingFragment(mFirstShowFragment);
    }

    @Subscriber(tag = EVENT_TAG_FORWARD_FRAGMENT)
    private void showOneQuestionClassFragment(int id){
        Log.w("logger","得到Id"+id);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.id_fragmentContainer,QuestionClazzListFragment.newInstance(id))
                .addToBackStack(QuestionClazzListFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Override
    protected boolean canBack() {
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


}
