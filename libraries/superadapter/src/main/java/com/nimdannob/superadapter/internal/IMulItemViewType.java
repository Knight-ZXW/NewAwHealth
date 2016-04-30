package com.nimdannob.superadapter.internal;

import android.support.annotation.LayoutRes;

/**
 * Created by Zousfu on 2016/4/29.
 * Email:nimdanoob@163.com
 */
public interface IMulItemViewType<T> {
    /**
     * this method will not be called if using a RecyclerView
     * @return the adapter view type count
     */
    int getViewTypeCount();

    /**
     * Item view type, a non-negative integer is better.
     *
     * @param position current position of ViewHolder
     * @param t        model item
     * @return viewType
     */
    int getItemViewType(int position, T t);

    /**
     * Layout res.
     *
     * @param viewType {@link #getItemViewType(int, T)}
     * @return {@link android.support.annotation.LayoutRes}
     */
    @LayoutRes
    int getLayoutId(int viewType);
}
