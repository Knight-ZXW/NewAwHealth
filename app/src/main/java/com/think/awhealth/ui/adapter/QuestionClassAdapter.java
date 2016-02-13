package com.think.awhealth.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.think.awhealth.R;
import com.think.awhealth.ui.question.QuestionActivity;

import org.simple.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */
public class QuestionClassAdapter extends RecyclerView.Adapter<QuestionClassAdapter.TextViewHolder> {

    public String[] mDatas;

    public QuestionClassAdapter(String[] datas) {
        mDatas = datas;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View containerView = inflater.inflate(R.layout.view_card_text, parent, false);
        return new TextViewHolder(containerView);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        String name = mDatas[position];

        holder.questionClassName.setText(name);
        holder.wrapView.setOnClickListener(v -> {
            //服务器接口奇葩，中间少了一个
            int classId=1;
            if (position>0){
                classId = position+2;
            }
            Log.w("logger","发送事件"+classId);
            EventBus.getDefault().post(classId, QuestionActivity.EVENT_TAG_FORWARD_FRAGMENT);

        });
    }

    @Override
    public int getItemCount() {
        if (mDatas != null) {
            return mDatas.length;
        }
        return 0;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.id_question_class)
        TextView questionClassName;
        CardView wrapView;
        public TextViewHolder(View itemView) {
            super(itemView);
            wrapView = (CardView) itemView;
            ButterKnife.inject(this, itemView);
        }
    }
}
