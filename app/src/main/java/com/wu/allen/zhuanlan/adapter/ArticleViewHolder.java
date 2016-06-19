package com.wu.allen.zhuanlan.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.model.Article;

/**
 * Created by allen on 2016/6/15.
 */
public class ArticleViewHolder extends BaseViewHolder<Article> {
    private ImageView imageview;
    private TextView tvLike,tvAuthor,tvComment,tvTitle;

    private static final String TAG = "ArticleViewHolder";

    public ArticleViewHolder(ViewGroup view) {
        super(view, R.layout.zhuanlanpost_item);

        imageview = $(R.id.iv_articlebg);
        tvAuthor = $(R.id.tv_author);
        tvLike = $(R.id.tv_fans_count);
        tvComment = $(R.id.tv_comment_count);
        tvTitle = $(R.id.tv_title);
    }

    @Override
    public void setData(Article data) {
        super.setData(data);
        tvAuthor.setText(data.getSlug() );
        tvComment.setText(data.getCommentsCount() + "评论");
        tvTitle.setText(data.getTitle());

        Glide.with(getContext())
                    .load(data.getTitleImage())
                    .centerCrop()
                    .error(R.drawable.error)
                    .placeholder(R.drawable.error)//占位图
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(imageview);

    }
}
