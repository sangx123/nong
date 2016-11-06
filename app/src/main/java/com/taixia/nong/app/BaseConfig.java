package com.taixia.nong.app;

import android.content.Context;

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
public class BaseConfig {
    //AppLicationContext
    public static Context context;
    //log
    public static boolean isLog=true;
    public static String logTag="nong";
    //是否是调试模式
    public static final boolean DEBUG = Boolean.parseBoolean("true");
    //api的配置
    public static class ApiConfig{
        public static final String API_ROOU_URL = "http://api.mtap.cn/index.php/V1/";
    }

}
