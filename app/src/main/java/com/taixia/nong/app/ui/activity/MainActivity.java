package com.taixia.nong.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;

import com.taixia.nong.R;
import com.taixia.nong.app.BaseActivity;
import com.taixia.nong.app.presenter.MainPresent;
import com.taixia.nong.app.view.IMainView;
import com.taixia.nong.http.api.Api;
import com.taixia.nong.http.retrofit.IsUnsubScribedOperator;
import com.taixia.nong.http.retrofit.RetrofitClient;
import com.taixia.nong.tools.MAndroid;
import com.taixia.nong.tools.MLog;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.android.schedulers.HandlerScheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.schedulers.NewThreadScheduler;
import rx.internal.util.RxThreadFactory;
import rx.observers.SafeSubscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_next)
    Button btnNext;
    boolean flag=false;
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MLog.e("onDestroy");
    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        flag=!flag;
        btnNext.setSelected(flag);
    }
}
