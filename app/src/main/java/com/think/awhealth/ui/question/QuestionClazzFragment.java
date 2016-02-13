package com.think.awhealth.ui.question;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.think.awhealth.R;
import com.think.awhealth.ui.adapter.QuestionClassAdapter;
import com.think.awhealth.ui.base.BaseFragment;

import butterknife.InjectView;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionClazzFragment extends BaseFragment {

    private String[] className = new String[]{"健康常识","心理咨询","孕育指南","内科","外科","妇产科","儿科","皮肤科","五官科","男科","整容整形","中医","药物","体检","医院","其它疾病"};

    @InjectView(R.id.id_recyclerView)
    RecyclerView mRecyclerView;
    QuestionClassAdapter mAdapter;

    public QuestionClazzFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_clazzs, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mAdapter = new QuestionClassAdapter(className);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
