package com.wu.allen.zhuanlan.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by allen on 2016/6/21.
 */
public class ImgShareUtil {

    public static void shareImage(Context context, Uri uri){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/jpeg");//图片
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        context.startActivity(Intent.createChooser(intent,"分享妹纸"));
    }
}
