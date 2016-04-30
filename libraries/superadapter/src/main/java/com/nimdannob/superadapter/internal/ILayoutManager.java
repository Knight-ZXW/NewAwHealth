package com.nimdannob.superadapter.internal;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Zousfu on 2016/4/29.
 * Email:nimdanoob@163.com
 */
interface ILayoutManager {
    boolean hasLayoutManager();

    RecyclerView.LayoutManager getLayoutManager();
}
