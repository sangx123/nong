package com.taixia.nong.app.presenter;

import android.content.Context;

import com.taixia.nong.app.BasePresent;
import com.taixia.nong.app.view.IMainView;
import com.taixia.nong.http.api.Api;
import com.taixia.nong.http.retrofit.IsUnsubScribedOperator;
import com.taixia.nong.http.retrofit.RetrofitClient;
import com.taixia.nong.tools.MLog;
import com.trello.rxlifecycle.android.ActivityEvent;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/18
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/18         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MainPresent extends BasePresent<IMainView> {
    public MainPresent(Context context){
        super(context);

    }

    public void getData(){
        RetrofitClient.createJavaApi(Api.class).getPiazza(1, 5)
              /*  .compose(bindUntilEvent(ActivityEvent.DESTROY))//防止内存内存泄漏*/
                .lift(new IsUnsubScribedOperator<>())//判断是否cancel掉了请求
                .subscribeOn(Schedulers.io())//请求在io线程中运行
                .observeOn(AndroidSchedulers.mainThread())//执行在主线程中执行
              /*  .doOnUnsubscribe(() -> {
                    MLog.e("取消订阅!");
                })*/
                .subscribe(squareModelResponseResult -> {
                    mView.loadServerData();
                }, throwable -> {
                    MLog.e("网络请求失败！");
                });
    }
}
