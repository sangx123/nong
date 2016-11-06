package com.taixia.nong.tools;

import com.taixia.nong.app.BaseConfig;

import java.io.File;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/7
 * Description: 文件工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/7         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class  MFile extends BaseConfig {
    public static double getDirSize(File file) {
        // 判断文件是否存在
        if (file.exists()) {
            // 如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                double size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {// 如果是文件则直接返回其大小,以“兆”为单位
                double size = (double) file.length() / 1024 / 1024;
                return size;
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0.0;
        }
    }
}
