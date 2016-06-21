package com.wu.allen.zhuanlan.view.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.adapter.ZhuanLanAdapter;
import com.wu.allen.zhuanlan.model.ZhuanLan;
import com.wu.allen.zhuanlan.net.Network;
import com.wu.allen.zhuanlan.util.TopicData;
import com.wu.allen.zhuanlan.view.activity.ZhlanDetailActivity;
import java.util.List;
import java.util.Random;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by allen on 2016/6/17.
 */
public class ZhihuFragment extends BaseFragment {

    private static final String TAG = "ZhihuFragment";
    private EasyRecyclerView recyclerView;
    private List<ZhuanLan> zhuanLanList;
    private ZhuanLanAdapter zhuanLanAdapter;
    private String title;
    private int page = 1;
    private Handler handler = new Handler();
    private String[] ids;
    private String[] TopicIds = {"TopicData.music_film_ids","TopicData.life_talks_ids",
            "TopicData.photography_ids","TopicData.photography_ids"};
    private String msgTopic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ids = TopicData.default_ids;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zhuanlan_layout, container, false);
        initView(view);
        return view;
    }
    // initView
    public void initView(View view){

        final FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animator animator = AnimatorInflater.loadAnimator(getActivity(), R.animator.animator_rotation);
                animator.setTarget(fab);
                animator.setInterpolator(new CycleInterpolator(2));
                animator.start();
                // bug here still
                changeTopic();
                onRefresh();
            }
        });

        //girlList = new ArrayList<>();
        recyclerView = (EasyRecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(linearLayoutManager);
        zhuanLanAdapter = new ZhuanLanAdapter(getActivity());
        doWithZhuanLan(zhuanLanAdapter);
        recyclerView.setRefreshListener(this);
        onRefresh();
    }
    // Because of Api , there is a Skill
    private void changeTopic() {
        int max=3;
        int min=0;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;

        ids = TopicData.life_talks_ids;
    }
    // Intent to ZhlanDetailActivity
    private void doWithZhuanLan(final RecyclerArrayAdapter<ZhuanLan> adapter) {
        recyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.load_more_layout,this);
        adapter.setNoMore(R.layout.no_more_layout);
        adapter.setError(R.layout.error_layout);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(),ZhlanDetailActivity.class);
                intent.putExtra("slug",adapter.getItem(position).getSlug());
                intent.putExtra("title",adapter.getItem(position).getName());
                intent.putExtra("profile_url",adapter.getItem(position).getCreator().getProfileUrl());
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
            }
        });
    }

    // Get Zhuanlan Author List
    private void getZhuanLanData(String zhuanlanname) {
        Network.getZhuanLanApi()
                .getZhuanLan(zhuanlanname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ZhuanLan>() {
                    @Override
                    public void onCompleted() {
                        Log.e(TAG,"onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,e.getMessage());

                    }
                    @Override
                    public void onNext(ZhuanLan zhuanLan) {
                        Log.e(TAG,"OnNext");
                        zhuanLanAdapter.add(zhuanLan);
                    }
                });
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                zhuanLanAdapter.clear();
                for (int i = 0;i < ids.length; i++) {
                        getZhuanLanData(ids[i]);
                }
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ids = TopicData.photography_ids;
                //zhuanLanAdapter.clear();
                for (int i = 0;i < ids.length; i++) {
                    getZhuanLanData(ids[i]);
                }
            }
        }, 1000);
    }
}
