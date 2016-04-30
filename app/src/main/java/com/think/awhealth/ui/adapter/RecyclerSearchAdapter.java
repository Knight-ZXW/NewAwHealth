package com.think.awhealth.ui.adapter;

/**
 * Created by XiuWuZhuo on 2016/2/11.
 * Emial:nimdanoob@163.com
 */

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.think.awhealth.R;
import com.think.awhealth.bean.entity.Drug;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 搜索界面 -SearchDrugResultActivity-展示的RecyclerView 的 adapter
 */
public class RecyclerSearchAdapter extends RecyclerView.Adapter<RecyclerSearchAdapter.ViewHolder> {

    private List<Drug> mDatas;

    public RecyclerSearchAdapter(List<Drug> datas) {
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_query_reslut, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Drug drug = mDatas.get(position);
        holder.drugTitle.setText(drug.getName());

        holder.drugImage.setImageURI(Uri.parse(drug.getImg()));

        if (mOnItemClickListener!=null){
            holder.wrapView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mDatas!=null){
            return mDatas.size();
        }
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.id_item_title)
        TextView drugTitle;
        @InjectView(R.id.id_item_image)
        SimpleDraweeView drugImage;
        View wrapView;
        public ViewHolder(View itemView) {
            super(itemView);
            wrapView = itemView;
            ButterKnife.inject(this, itemView);
        }

    }

    private onItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(onItemClickListener listener){
        mOnItemClickListener = listener;
    }
    public interface onItemClickListener{
        void onItemClick(int position);

    }
}
