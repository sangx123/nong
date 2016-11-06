package com.taixia.nong.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.taixia.nong.app.BaseConfig;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/18
 * Description: 网络监测工具类
 * 权限:
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" >
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/18         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MNetWork extends BaseConfig {
    /**
     * 判断网络是否可用, 在使用网络请求是预先使用此方法进行检查, 以节省资源.
     * @return 可用状态
     */
    public static boolean isNetAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        return (info != null && info.isAvailable() && info.isConnected());
    }

    /*
        判断网络类型
        ConnectivityManager conMan = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // 3G
        State mobile = conMan.getNetworkInfo(0).getState();

        // WIFI
        State wifi = conMan.getNetworkInfo(1).getState();

        if (mobile == NetworkInfo.State.CONNECTED
        || mobile == NetworkInfo.State.CONNECTING) {
            // TODO: in mobile do something
        } else if (wifi == NetworkInfo.State.CONNECTED
        || wifi == NetworkInfo.State.CONNECTING) {
            // TODO: in wifi do something
        }
    */
}
