package com.nimdannob.superadapter.internal;

import android.view.View;

/**
 * Created by Zousfu on 2016/4/29.
 * Email:nimdanoob@163.com
 */
interface IHeaderFooter {
    View getHeaderView();

    View getFooterView();

    void addHeaderView(View header);

    void addFooterView(View footer);

    boolean removeHeaderView();

    boolean removeFooterView();

    boolean hasHeaderView();

    boolean hasFooterView();

    boolean isHeaderView(int position);

    boolean isFooterView(int position);
}