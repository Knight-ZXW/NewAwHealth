package com.think.awhealth.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.think.awhealth.R;
import com.think.awhealth.util.HtmlRegexpUtil;
import com.think.awhealth.util.StringUtils;

/**
 * Created by XiuWuZhuo on 2016/2/12.
 * Emial:nimdanoob@163.com
 */
public class TitleWithContentView extends LinearLayout{

    private TextView titleView;
    private TextView contentView;
    public TitleWithContentView(Context context) {
        this(context,null);
    }

    public TitleWithContentView(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public TitleWithContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.view_title_with_content,this,true);
        titleView = (TextView) view.findViewById(R.id.id_item_title);
        contentView = (TextView) view.findViewById(R.id.id_item_content);
    }

    public void setTitleText(String str){
        titleView.setText(str);
    }
    public void setContentView(String str){
        if (StringUtils.isBlank(str)){
            contentView.setText("暂无相关信息");
            return;
        }
        contentView.setText(HtmlRegexpUtil.filterHtml(str));
    }
}
