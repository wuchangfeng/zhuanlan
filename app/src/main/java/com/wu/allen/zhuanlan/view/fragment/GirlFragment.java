package com.wu.allen.zhuanlan.view.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.adapter.GirlAdapter;
import com.wu.allen.zhuanlan.cache.Data;
import com.wu.allen.zhuanlan.model.Item;
import com.wu.allen.zhuanlan.util.DpToPxUtil;
import com.wu.allen.zhuanlan.view.activity.GirlActivity;

import java.util.List;

import rx.Observer;
import rx.Subscription;

/**
 * Created by allen on 2016/6/17.
 */
public class GirlFragment extends BaseFragment {

    private static final String TAG = "GirlFragment";
    protected Subscription subscription;
    private EasyRecyclerView recyclerView;
    private GirlAdapter girlAdapter;
    private String title;
    private int page = 1;
    private Handler handler = new Handler();
    private String[] ids;
    private String msgTopic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_girl_layout, container, false);
        initView(view);
        return view;
    }
    // initView
    public void initView(View view){
        recyclerView = (EasyRecyclerView) view.findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        girlAdapter = new GirlAdapter(getActivity());
        doWithGirl(girlAdapter);
        // for itemDecoration
        SpaceDecoration itemDecoration = new SpaceDecoration((int) DpToPxUtil.convertDpToPixel(8,getActivity()));
        itemDecoration.setPaddingEdgeSide(true);
        itemDecoration.setPaddingStart(true);
        itemDecoration.setPaddingHeaderFooter(false);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setRefreshListener(this);
        // load data while init
        getGirlData(page);
    }
    // can intent to GirlActivity here
    private void doWithGirl(final RecyclerArrayAdapter<Item> adapter) {
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.load_more_layout,this);
        adapter.setNoMore(R.layout.no_more_layout);
        adapter.setError(R.layout.error_layout);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent(getActivity(), GirlActivity.class);
                intent.putExtra("desc",adapter.getItem(position).description);
                intent.putExtra("url",adapter.getItem(position).imageUrl);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            }
        });
    }
    // Here get data from cache or net
    private void getGirlData(int page) {
        unsubscribe();
        subscription = Data.getInstance()
                .subscribeData(new Observer<List<Item>>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Main",e.getMessage());
                    }

                    @Override
                    public void onNext(List<Item> items) {
                        girlAdapter.addAll(items);
                    }
                },page*10);
    }
    // some bug here
    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // before refresh clean cache
                Data.getInstance().clearMemoryAndDiskCache();
                getGirlData(page);

            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // before load more ,clean cache
                Data.getInstance().clearMemoryAndDiskCache();
                page ++;
                getGirlData(page);
            }
        }, 1000);
    }
}
