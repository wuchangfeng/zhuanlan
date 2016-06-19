package com.wu.allen.zhuanlan.adapter;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.model.Item;

/**
 * Created by allen on 2016/6/17.
 */
public class GirlViewHolder extends BaseViewHolder<Item> {
    private ImageView image;
    public GirlViewHolder(ViewGroup parent) {
        super(parent, R.layout.girl_item);
        image = $(R.id.image);
    }

    @Override
    public void setData(Item data) {
        super.setData(data);
        Log.e("GirlViewHolder",data.imageUrl);
        Glide.with(getContext())
                .load(data.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
    }
}
