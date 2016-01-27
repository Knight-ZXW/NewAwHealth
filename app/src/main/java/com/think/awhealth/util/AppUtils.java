package com.think.awhealth.util;

import android.graphics.drawable.Drawable;
import android.text.Html;

/**
 * Created by XiuWuZhuo on 2016/1/27.
 * Emial:nimdanoob@163.com
 */
public class AppUtils {
    public static void shwoErrorMessage() {

    }

    public static Html.ImageGetter getHtmlImageGetter() {
        return new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {

                return null;
            }
        };
    }
}
