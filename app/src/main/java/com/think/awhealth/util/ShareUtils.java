package com.think.awhealth.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.StringRes;

import com.think.awhealth.R;


/**
 * Created by XiuWuZhuo on 2016/2/14.
 * Emial:nimdanoob@163.com
 */
public class ShareUtils {

    public static void share(Context context, @StringRes int resId){
        share(context,context.getString(R.string.share_text));
    }
    /**
     * 分享图片
     * @param context
     * @param uri
     * @param title
     */
    public static void shareImage(Context context,Uri uri,String title){
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM,uri);
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent,title));
    }

    public static void share(Context context,String extraText){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,context.getString(R.string.action_share));
        intent.putExtra(Intent.EXTRA_TEXT,extraText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(Intent.createChooser(intent,context.getString(R.string.action_share)));
    }

}
