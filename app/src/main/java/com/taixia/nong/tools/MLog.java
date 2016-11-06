package com.taixia.nong.tools;

import com.taixia.nong.app.BaseConfig;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/7
 * Description: 日志工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/7         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MLog extends BaseConfig {
    public static void e(String str)
    {
        if(isLog)
            android.util.Log.e(logTag,str);
    }
    public static void e(int str){

        if(isLog)
            android.util.Log.e(logTag,str+"");
    }
}
