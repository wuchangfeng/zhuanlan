package com.wu.allen.zhuanlan.view.fragment;

import android.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Subscription;

/**
 * Created by allen on 2016/6/17.
 */
public class BaseFragment extends Fragment implements SwipeRefreshLayout
        .OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener{
    protected Subscription subscription;



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unsubscribe();
    }

    protected void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
