package com.wu.allen.zhuanlan.net.api;

import com.wu.allen.zhuanlan.model.ZhuanLan;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by allen on 2016/6/18.
 */
public interface ZhuanLanApi {
    @GET("{zhuanlanname}")
    Observable<ZhuanLan> getZhuanLan(
            @Path("zhuanlanname") String zhuanlanname
    );
}
