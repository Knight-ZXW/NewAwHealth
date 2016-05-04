package com.think.awhealth.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.nimdannob.superadapter.SuperAdapter;
import com.nimdannob.superadapter.internal.SuperViewHolder;
import com.think.awhealth.R;
import com.think.awhealth.bean.entity.HealthComment;

import java.util.List;

/**
 * Created by Zousfu on 2016/5/4.
 * Email:nimdanoob@163.com
 */
public class CommentAdapter extends SuperAdapter<HealthComment>{
    public CommentAdapter(Context context, List<HealthComment> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, HealthComment item) {
        holder.setText(R.id.id_recommend_tv,item.comment);
    }
}
