/**
 * <p>Project: nong</p>
 * <p>Package: com.taixia.nong.tools</p>
 * <p>File: MAndroid.java</p>
 * <p>Date: 2016/10/26/11:01.</p>
 */
package com.taixia.nong.tools;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

import com.taixia.nong.app.BaseConfig;

/**<p>Class: com.taixia.nong.tools.MAndroid</p>
 * <p>Description: android自身特性有关的类</p>
 * <pre>
 *
 * </pre>
 * @author sangxiang
 * @date 2016/10/26/11:01
 */

public class MAndroid extends BaseConfig {
    /**
     * 设置全屏状态
     * @param mContentView
     * @param isShowState
     */
    public static void showStatus(View mContentView,boolean isShowState){
        if(isShowState) {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    );
        }else {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    }
}
