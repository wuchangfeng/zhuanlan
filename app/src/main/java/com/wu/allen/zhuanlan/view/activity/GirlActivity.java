package com.wu.allen.zhuanlan.view.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.model.Girl;
import com.wu.allen.zhuanlan.util.ImgSaveUtil;
import com.wu.allen.zhuanlan.util.ToastUtil;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by allen on 2016/6/14.
 */
public class GirlActivity extends BaseActivity {

    private static final String TAG = "GirlActivity";
    private Toolbar toolbar;
    private ImageView image;
    private String desc;
    private String url;
    private PhotoViewAttacher attacher;
    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInitView();
        setContentView(R.layout.girldetail_layout);
        getData();
        initView();
    }
    // Animated transitions
    public void beforeInitView(){
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());
    }
    // Get data from MainFragment
    public void getData() {
        Intent intent = getIntent();
        desc = intent.getStringExtra("desc");
        url = intent.getStringExtra("url");
    }
    // initView
    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        getSupportActionBar().setTitle(desc);
        image = (ImageView) findViewById(R.id.image_meizhi);
        attacher = new PhotoViewAttacher(image);
        // Glide
        Glide.with(this)
                .load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(new SimpleTarget<Bitmap>() {// 这样写有什么好处？
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        image.setImageBitmap(resource);
                        attacher.update();
                        bitmap = resource;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.girl_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            ImgSaveUtil.saveImage(GirlActivity.this,url,bitmap,image,"saveImg");
        }else if (id == R.id.action_share){
            ToastUtil.showLong(GirlActivity.this,"share");
        }else if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
