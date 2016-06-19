package com.wu.allen.zhuanlan.net.api;

import com.wu.allen.zhuanlan.model.Article;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by allen on 2016/6/18.
 */
public interface ZhLanArticleApi {
    @GET("{slug}/posts")
    Observable<List<Article>> getArticle(
            @Path("slug") String slug,
            @Query("limit") int limit,
            @Query("offest") int offest
    );
}
