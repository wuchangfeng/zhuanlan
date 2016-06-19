package com.wu.allen.zhuanlan.adapter;

import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.wu.allen.zhuanlan.R;
import com.wu.allen.zhuanlan.model.ZhuanLan;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by allen on 2016/6/14.
 */
public class ZhuanLanViewHolder extends BaseViewHolder<ZhuanLan> {

    private CircleImageView imageView;
    private TextView tvName;
    private TextView tvIntro;
    private TextView tvArticleCount;
    private TextView tvFansCount;


    public ZhuanLanViewHolder(ViewGroup parent) {
        super(parent, R.layout.zhuanlan_item);
        imageView = $(R.id.profile_image);
        //tvName = $(R.id.name);
        tvArticleCount = $(R.id.tv_article_count);
        tvFansCount = $(R.id.tv_fans_count);
        tvIntro = $(R.id.intro);
        // Bold for textView
        TextPaint tp = tvIntro.getPaint();
        tp.setFakeBoldText(true);
    }

    @Override
    public void setData(ZhuanLan data) {
        super.setData(data);
        Glide.with(getContext())
                .load("https://pic2.zhimg.com/" + data.getAvatar().getId()  + "_m.jpg")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(imageView);
        tvIntro.setText(data.getDescription());
        tvFansCount.setText(data.getFollowersCount() + "人关注");
        tvArticleCount.setText(data.getPostsCount() + "篇文章");
    }
}
