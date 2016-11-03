package com.taixia.nong.app;

import android.content.Context;

import com.taixia.nong.tools.MReflect;

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
public abstract class BasePresent<T extends IBaseView> {
    protected Context context;
    protected T  mView;
    public BasePresent(Context context){
        this.context=context;
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }
}
