package com.wu.allen.zhuanlan.view.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.Window;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.adapter.ArticleAdapter;
import com.wu.allen.zhuanlan.model.Article;
import com.wu.allen.zhuanlan.net.Network;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by allen on 2016/6/14.
 */
public class ZhlanDetailActivity extends BaseActivity {

    private static final String TAG = "ZhlanDetailActivity";
    private Toolbar toolbar;
    private String slug,title,name,articeSlug,titleImage;
    private EasyRecyclerView recyclerView;
    private List<Article> articleList;
    private ArticleAdapter articleAdapter;
    private Handler handler = new Handler();
    private int page = 1;
    private CollapsingToolbarLayout toolbarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInitView();
        setContentView(R.layout.zhuanlan_layout);
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
        slug = intent.getStringExtra("slug");
        title = intent.getStringExtra("title");
    }
    // initView
    public void initView() {

        articleList = new ArrayList<>();
        recyclerView = (EasyRecyclerView) findViewById(R.id.recycler_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        //getSupportActionBar().setTitle(desc);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        articleAdapter = new ArticleAdapter(getApplicationContext());
        doWithArticle(articleAdapter);
        recyclerView.setRefreshListener(ZhlanDetailActivity.this);
        onRefresh();
    }
    // here can intent to ArticleDetailActivity
    private void doWithArticle(final RecyclerArrayAdapter<Article> adapter) {
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.load_more_layout,this);
        adapter.setNoMore(R.layout.no_more_layout);
        adapter.setError(R.layout.error_layout);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ZhlanDetailActivity.this,ArticleDetailActivity.class);
                intent.putExtra("slug",adapter.getItem(position).getArticleSlug());
                intent.putExtra("image",adapter.getItem(position).getTitleImage());
                intent.putExtra("title",adapter.getItem(position).getTitle());
                startActivity(intent);
            }
        });
    }
    // Get Article List with the zhuanlan
    private void getArticleData(String slug,int limit,int offest) {
        Network.getZhLanArticleApi()
                .getArticle(slug,limit,offest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Article>>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG,"onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,e.getMessage());
                    }
                    @Override
                    public void onNext(List<Article> article) {
                        ProcessData(article);
                        articleAdapter.addAll(articleList);
                    }
                });
    }
    // process data so that can be posted to ArticleAdapter
    private List<Article> ProcessData(List<Article> article) {
        for (int i = 0; i < article.size(); i++) {
            String title = article.get(i).getTitle();
            String content = article.get(i).getContent();
            titleImage = article.get(i).getTitleImage();
            String sumary = article.get(i).getSummary();
            int commentsCount = article.get(i).getCommentsCount();
            // no use
            int likesCount =article.get(i).getLikeCount();
            articeSlug = article.get(i).getSlug();
            Article articleItem = new Article(title,titleImage,content
                    ,sumary,commentsCount,likesCount,slug,articeSlug);
            articleList.add(articleItem);
        }
        return articleList;
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // bug here
                getArticleData(slug,page*5,0);
                page++;
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        articleAdapter.clear();
        getArticleData(slug,5,0);
    }
}
