package com.taixia.nong.app.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.taixia.nong.R;
import com.taixia.nong.app.BaseActivity;
import com.taixia.nong.tools.MLog;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity_TextColor extends BaseActivity {
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
