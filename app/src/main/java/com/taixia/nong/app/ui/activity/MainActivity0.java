package com.taixia.nong.app.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import com.taixia.nong.R;
import com.taixia.nong.app.BaseActivity;
import com.taixia.nong.app.presenter.MainPresent;
import com.taixia.nong.app.view.IMainView;
import com.taixia.nong.tools.MLog;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity0 extends BaseActivity implements IMainView{
    @BindView(R.id.btn_next)
    Button btnNext;
    private MainPresent mainPresent;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        mainPresent=new MainPresent(this);
        mainPresent.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MLog.e("onDestroy");
    }

    /**
     * 通过present获取数据
     */
    @OnClick(R.id.btn_next)
    public void onClick() {
        mainPresent.getData();
    }

    /**
     * present获取数据后回调方法
     */
    @Override
    public void loadServerData() {
        MLog.e("请求成功！");
    }
}
