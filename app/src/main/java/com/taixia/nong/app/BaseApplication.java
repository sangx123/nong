package com.taixia.nong.app;
import android.app.Application;
/**
 * Created by Administrator on 2016/8/31.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseConfig.context=this;
    }
}
