package com.taixia.nong.tools;

import android.widget.Toast;

import com.taixia.nong.app.BaseConfig;
/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/18
 * Description: Toast工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/18         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class  MToast extends BaseConfig {
    private static Toast toast = null;
    public  static void Toast(String msg){
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
