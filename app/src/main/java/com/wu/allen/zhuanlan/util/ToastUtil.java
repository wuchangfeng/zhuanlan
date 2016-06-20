package com.wu.allen.zhuanlan.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by allen on 2016/6/14.
 */


public class ToastUtil {

    // shortTime
    public static void showShort(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

    // LongTime
    public static void showLong(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}
