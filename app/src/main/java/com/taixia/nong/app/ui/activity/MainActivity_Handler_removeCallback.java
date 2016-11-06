package com.taixia.nong.app.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;

import com.taixia.nong.R;
import com.taixia.nong.app.BaseActivity;
import com.taixia.nong.tools.MLog;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;

public class MainActivity_Handler_removeCallback extends BaseActivity {
    @BindView(R.id.btn_next)
    Button btnNext;
    private int count=0;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
    private final Handler mHideHandler = new Handler();
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            Log.e("sangxiang", "run: 5s end--->>"+count);
        }
    };
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
        Log.e("sangxiang", "run: 5s start--->>"+count++);
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable,5000);
    }
}
