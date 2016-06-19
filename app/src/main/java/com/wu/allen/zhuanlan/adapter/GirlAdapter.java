package com.wu.allen.zhuanlan.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.zhuanlan.model.Item;

/**
 * Created by allen on 2016/6/17.
 */
public class GirlAdapter extends RecyclerArrayAdapter<Item> {


    public GirlAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new GirlViewHolder(parent);
    }
}
