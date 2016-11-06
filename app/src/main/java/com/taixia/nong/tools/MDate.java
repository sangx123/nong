package com.taixia.nong.tools;

import android.text.TextUtils;

import com.taixia.nong.app.BaseConfig;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/7
 * Description: 日期工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/7         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MDate extends BaseConfig {

    /**
     * Java将Unix时间戳转换成指定格式日期字符串
     * @param timestampString 时间戳 如："1473048265";
     * @param formats 要格式化的格式 默认："yyyy-MM-dd HH:mm:ss";
     * @return 返回结果 如："2016-09-05 16:06:42";
     */
    public static String TimeStamp2Date(String timestampString, String formats) {
        if (TextUtils.isEmpty(formats))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }
    public static String TimeStamp2Date(String timestampString) {
        return TimeStamp2Date(timestampString,"");
    }
}
