package com.wu.allen.zhuanlan.adapter;

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.model.Article;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by allen on 2016/6/15.
 */
public class ArticleViewHolder extends BaseViewHolder<Article> {
    private ImageView imageview;
    private CircleImageView circleImageView;
    private TextView tvLike,tvAuthor,tvComment,tvTitle;

    private static final String TAG = "ArticleViewHolder";

    public ArticleViewHolder(ViewGroup view) {
        super(view, R.layout.zhuanlanpost_item);

        imageview = $(R.id.iv_articlebg);
        circleImageView = $(R.id.profile_image);
        tvAuthor = $(R.id.tv_author);
        tvLike = $(R.id.tv_fans_count);
        tvComment = $(R.id.tv_comment_count);
        tvTitle = $(R.id.tv_title);
    }

    @Override
    public void setData(Article data) {
        super.setData(data);
        tvAuthor.setText(data.getSlug() +" "+"发布了文章" );
        tvComment.setText(data.getCommentsCount() +" "+"评论");
        tvTitle.setText(data.getTitle());
        Log.e(TAG,data.getProfileUrl());
        // Because of zhihu url API logo is the default img
        Glide.with(getContext())
                .load(data.getProfileUrl())
                .centerCrop()
                .error(R.drawable.logo)
                .placeholder(R.drawable.logo)//占位图
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(circleImageView);

        Glide.with(getContext())
                    .load(data.getTitleImage())
                    .centerCrop()
                    .error(R.drawable.error)
                    .placeholder(R.drawable.error)//占位图
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageview);

    }
}
