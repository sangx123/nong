package com.taixia.nong.tools;

import android.view.View;

import com.taixia.nong.app.BaseConfig;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/12
 * Description: 动画工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/12         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MAnimation extends BaseConfig{
    //缩放一个view
    public static void scaleAnimation(View view, int scale, int duration){
        view.animate().scaleX(scale).scaleY(scale).setDuration(duration).start();
    }
}
