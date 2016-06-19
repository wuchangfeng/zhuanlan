// (c)2016 Flipboard Inc, All Rights Reserved.

package com.wu.allen.zhuanlan.net.api;


import com.wu.allen.zhuanlan.model.Girl;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GankApi {
    @GET("data/福利/{number}/{page}")
    Observable<Girl> getBeauties(@Path("number") int number, @Path("page") int page);
}
