package com.wu.allen.zhuanlan.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allen on 2016/6/17.
 */
public class Girl {
    public boolean error;
    // @SerializedName 定义序列化之后的名称
    public @SerializedName("results")
    List<GirlResult> girlResults;

    public static class GirlResult{
        public String createdAt;
        public String url;
    }
}
