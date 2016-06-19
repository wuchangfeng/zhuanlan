package com.wu.allen.zhuanlan.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.model.ArticleDetail;
import com.wu.allen.zhuanlan.model.ZhuanLan;
import com.wu.allen.zhuanlan.net.Network;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by allen on 2016/6/18.
 */
public class ArticleDetailActivity extends BaseActivity {
    private static final String TAG = "ArticleDetailActivity";
    private String titleImage,articleTitle;
    private int articleSlug;
    private ImageView imageView;
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articledetail);
        getData();
        initView();
        loadView();
    }



    public void initView(){
        webView = (WebView) findViewById(R.id.wb_main);
        imageView = (ImageView) findViewById(R.id.iv_article);
        Glide.with(ArticleDetailActivity.this)
                .load(titleImage)
                .centerCrop()
                .into(imageView);
        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        mCollapsingToolbarLayout.setTitle(articleTitle);
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.GREEN);//设置收缩后Toolbar上字体的颜色
    }


    // Get data from ZhanlanDetailActivity
    public void getData() {
        Intent intent = getIntent();
        articleSlug = Integer.parseInt(intent.getStringExtra("slug"));
        articleTitle = intent.getStringExtra("title");
        titleImage = intent.getStringExtra("image");

        getArticleDetailData(articleSlug);
    }
    // reference is  https://github.com/marktony/zhuanlan/blob/master/app/src/main/java/com/marktony/zhuanlan/ui/ReadActivity.java
    private void loadView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }
    // Get Article Detail
    private void getArticleDetailData(int articleSlug) {
        Network.getArticleDetailApi()
                .getArticleDetail(articleSlug)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArticleDetail>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,e.getMessage());

                    }
                    @Override
                    public void onNext(ArticleDetail articleDetail) {
                        Log.e(TAG,articleDetail.getTitle());
                        processData(articleDetail);
                    }
                });
    }
    // Return data of Content is HTML ,Process here and show with webView
    private void processData(ArticleDetail articleDetail) {
        String content = articleDetail.getContent();
        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/master.css\" type=\"text/css\">";
        String html = "<!DOCTYPE html>\n"
                + "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n"
                + "<head>\n"
                + "\t<meta charset=\"utf-8\" />\n</head>\n"
                + css
                + "\n<body>"
                + content
                + "</body>\n</html>";
        webView.loadData(html,"text/html; charset=UTF-8", null);
    }
}
