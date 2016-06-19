package com.wu.allen.zhuanlan.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.wu.allen.zhuanlan.model.Article;

/**
 * Created by allen on 2016/6/15.
 */
public class ArticleAdapter extends RecyclerArrayAdapter<Article> {

    public ArticleAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(parent);
    }
}
