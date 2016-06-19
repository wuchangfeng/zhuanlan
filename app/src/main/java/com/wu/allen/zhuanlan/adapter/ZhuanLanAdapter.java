package com.wu.allen.zhuanlan.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.zhuanlan.model.ZhuanLan;

/**
 * Created by allen on 2016/6/14.
 */
public class ZhuanLanAdapter extends RecyclerArrayAdapter<ZhuanLan> {


    public ZhuanLanAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ZhuanLanViewHolder(parent);
    }
}
