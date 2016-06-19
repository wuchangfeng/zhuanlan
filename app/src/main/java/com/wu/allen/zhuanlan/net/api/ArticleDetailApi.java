package com.wu.allen.zhuanlan.net.api;

import com.wu.allen.zhuanlan.model.ArticleDetail;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by allen on 2016/6/19.
 */
public interface ArticleDetailApi {
    @GET("{articleSlug}")
    Observable<ArticleDetail> getArticleDetail(
            @Path("articleSlug") int articleSlug
    );
}
