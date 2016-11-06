package com.taixia.nong.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Button;

import com.taixia.nong.R;
import com.taixia.nong.app.BaseActivity;
import com.taixia.nong.tools.MLog;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.HandlerScheduler;
import rx.internal.schedulers.NewThreadScheduler;
import rx.internal.util.RxThreadFactory;

public class MainActivity_rxjava_timer extends BaseActivity {
    @BindView(R.id.btn_next)
    Button btnNext;
    private Subscription subscription;
    int count=0;
    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        Observable.interval(1, TimeUnit.SECONDS).subscribe(aLong -> {
            Log.e("Observable.timer", "time:"+aLong );
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MLog.e("onDestroy");
    }

    @OnClick(R.id.btn_next)
    public void onClick() {
        if(subscription!=null&&!subscription.isUnsubscribed()){
                subscription.unsubscribe();
        }
        Log.e("Observable.timer", "call: statr"+count);
        subscription=Observable.timer(5, TimeUnit.SECONDS).observeOn(new NewThreadScheduler(new RxThreadFactory("RxNewThreadScheduler-"))).observeOn(HandlerScheduler.from(new Handler(Looper.getMainLooper()))).doOnUnsubscribe(() -> {
            Log.e("subscription", "cancel" +count);
            count++;
        }).subscribe(aLong -> {
            Log.e("Observable.timer", "call: end"+count);
        });
    }
}
