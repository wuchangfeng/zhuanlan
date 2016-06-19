// (c)2016 Flipboard Inc, All Rights Reserved.

package com.wu.allen.zhuanlan.net;


import com.wu.allen.zhuanlan.net.api.ArticleDetailApi;
import com.wu.allen.zhuanlan.net.api.GankApi;
import com.wu.allen.zhuanlan.net.api.ZhLanArticleApi;
import com.wu.allen.zhuanlan.net.api.ZhuanLanApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Network {
    private static GankApi gankApi;
    private static ZhuanLanApi zhuanLanApi;
    private static ZhLanArticleApi zhLanArticleApi;
    private static ArticleDetailApi articleDetailApi;
    private static final String GANHUO_API = "http://gank.io/api/";
    private static final String ZhuanLanList_API = "https://zhuanlan.zhihu.com/api/columns/";
    private static final String ArticleList_API = "https://zhuanlan.zhihu.com/api/columns/";
    private static final String ARTICLEDETAIL_API = "https://zhuanlan.zhihu.com/api/posts/";
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static OkHttpClient client;

    public static OkHttpClient initOkHttp(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return client;
    }
    // Gank meizi api
    public static GankApi getGankApi() {
        if (gankApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(initOkHttp())
                    .baseUrl(GANHUO_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            gankApi = retrofit.create(GankApi.class);
        }
        return gankApi;
    }
    // Zhihu zhuanlan api
    public static ZhuanLanApi getZhuanLanApi() {
        if (zhuanLanApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(initOkHttp())
                    .baseUrl(ZhuanLanList_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            zhuanLanApi = retrofit.create(ZhuanLanApi.class);
        }
        return zhuanLanApi;
    }
    // Zhihu zhuanlanarticle api
    public static ZhLanArticleApi getZhLanArticleApi() {
        if (zhLanArticleApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(initOkHttp())
                    .baseUrl(ArticleList_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            zhLanArticleApi= retrofit.create(ZhLanArticleApi.class);
        }
        return zhLanArticleApi;
    }
    // Zhihu articleDetail api
    public static ArticleDetailApi getArticleDetailApi() {
        if (articleDetailApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(initOkHttp())
                    .baseUrl(ARTICLEDETAIL_API)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            articleDetailApi = retrofit.create(ArticleDetailApi.class);
        }
        return articleDetailApi;
    }
}
