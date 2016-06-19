package com.wu.allen.zhuanlan.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by allen on 2016/6/14.
 */


public class ToastUtil {

    // 短时间显示Toast信息
    public static void showShort(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
    }

    // 长时间显示Toast信息
    public static void showLong(Context context, String info) {
        Toast.makeText(context, info, Toast.LENGTH_LONG).show();
    }
}
