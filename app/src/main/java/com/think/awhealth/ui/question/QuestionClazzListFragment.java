package com.think.awhealth.ui.question;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.think.awhealth.R;
import com.think.awhealth.data.entity.Question;
import com.think.awhealth.ui.adapter.RecyclerQuestionAdapter;
import com.think.awhealth.ui.base.SwipeRefreshBaseFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */
public class QuestionClazzListFragment extends SwipeRefreshBaseFragment {

    private int mClassId;
    private Subscription mLoadDataSubscription;

    private int currentRows = 10;

    public static QuestionClazzListFragment newInstance(int id) {

        Bundle args = new Bundle();
        QuestionClazzListFragment fragment = new QuestionClazzListFragment();
        args.putInt("id", id);
        fragment.setArguments(args);
        return fragment;
    }

    private ArrayList<Question> mQuestions = new ArrayList<>();

    @Override
    protected RecyclerView.Adapter<?> provideRecyclerAdapter() {
        mQuestions = new ArrayList<>();
        return new RecyclerQuestionAdapter(mQuestions);
    }

    @Override
    protected RecyclerView.LayoutManager provideLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    @Override
    protected void loadData() {
        mLoadDataSubscription = sTianGouApi.getQuestionsById(mClassId, currentRows)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(questoinsData -> {
                    List<Question> questions = questoinsData.getTngou();
                    mQuestions.clear();
                    //又是api 奇葩的原因，不解释了
                    Log.w("logger", questions.size() + ":" + currentRows);
                    mQuestions.clear();
                    mQuestions.addAll(questions);
                    mAdapter.notifyItemInserted(currentRows);
//                    mAdapter.notifyDataSetChanged();
                    currentRows += 10;
                    setRefreshing(false);
                }, throwable -> {
                    loadError(throwable);
                });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mClassId = getArguments().getInt("id");
        initView();
        loadData();
    }

    private void initView() {
        if (mAdapter instanceof RecyclerQuestionAdapter) {
            ((RecyclerQuestionAdapter) mAdapter).setOnCardClickListener(new RecyclerQuestionAdapter.onCardClickListener() {
                @Override
                public void onCradItemClick(int id, TextView view) {
                    int iId = mQuestions.get(id).getId();
                    Intent intent = new Intent();
                    intent.putExtra("InforId",iId);
                    intent.setClass(getActivity(),QuestionDetailActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLoadDataSubscription.isUnsubscribed())
            mLoadDataSubscription.unsubscribe();
    }
}
