package com.taixia.nong.http.api;

import com.taixia.nong.http.model.SquareModel;
import com.taixia.nong.http.retrofit.ResponseResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/8/29.
 */
public interface Api {
    String MAN="1";
    String WOMEN="2";
    @GET("Piazza/get")
    Observable<ResponseResult<SquareModel>> getPiazza(
            @Query("p") Integer pageIndex,
            @Query("p_size") Integer pageSize
    );
}
