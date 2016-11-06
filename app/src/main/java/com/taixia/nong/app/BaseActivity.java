package com.taixia.nong.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/8/26.
 */
public abstract class BaseActivity extends RxAppCompatActivity  {
    public BaseActivity getActivity(){
        return this;
    }
    private Unbinder mUnBinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayout());
        //初始化黄油刀控件绑定框架
        mUnBinder=ButterKnife.bind(this);
        //初始化控件
        init(savedInstanceState);
        //去掉title
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }
    public abstract int getLayout();

    public abstract void init(Bundle savedInstanceState);
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
