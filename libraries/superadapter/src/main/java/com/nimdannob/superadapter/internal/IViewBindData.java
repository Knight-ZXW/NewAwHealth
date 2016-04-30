package com.nimdannob.superadapter.internal;

import android.view.View;
import android.view.ViewGroup;


/**
 *  * <p>Create and bind data to item view.</p>
 * Created by Zousfu on 2016/4/29.
 * Email:nimdanoob@163.com
 */
interface IViewBindData<T, VH> {

    /**
     * @param convertView Support by {@link BaseSuperAdapter#getView(int, View, ViewGroup)}.
     * @param parent      Target container(ListView, GridView, RecyclerView,Spinner, etc.).
     * @param viewType    Choose the layout resource according to view type.
     * @return Created view holder.
     */
    VH onCreate(View convertView, ViewGroup parent, int viewType);

    /**
     * Method for binding data to view.
     *
     * @param holder         ViewHolder
     * @param viewType       {@link BaseSuperAdapter#getItemViewType(int)}
     * @param layoutPosition position
     * @param item           data
     */
    void onBind(VH holder, int viewType, int layoutPosition, T item);
}
