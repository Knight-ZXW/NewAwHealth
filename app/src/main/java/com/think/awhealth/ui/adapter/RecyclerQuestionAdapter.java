package com.think.awhealth.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.think.awhealth.R;
import com.think.awhealth.data.entity.Question;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by XiuWuZhuo on 2016/2/13.
 * Emial:nimdanoob@163.com
 */
public class RecyclerQuestionAdapter extends RecyclerView.Adapter<RecyclerQuestionAdapter.ViewHolder> {
    List<Question> mdatas;

    public RecyclerQuestionAdapter(List<Question> questions) {
        mdatas = questions;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_health_news, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question question = mdatas.get(position);
        holder.image.setImageURI(Uri.parse("http://tnfs.tngou.net/image" + question.getImg()));
        holder.title.setText(question.getTitle());
        holder.wrapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onCradItemClick(position, holder.title);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.id_item_title)
        TextView title;

        @InjectView(R.id.id_item_image)
        SimpleDraweeView image;

        View wrapView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
            wrapView = itemView;

        }

    }

    private onCardClickListener mListener;

    public void setOnCardClickListener(onCardClickListener listener) {
        this.mListener = listener;
    }

    public interface onCardClickListener {
        void onCradItemClick(int id, TextView view);
//        void onCollect
    }
}

