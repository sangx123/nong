package com.taixia.nong.tools;

import com.taixia.nong.app.BaseConfig;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Author:    sangxiang
 * Version    V 1.0
 * Date:      2016/9/18
 * Description: 反射工具类
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2016/9/18         sangxiang           1.0             1.0
 * Why & What is modified:
 */
public class MReflect extends BaseConfig {
    /**
     * 通过反射,获得定义Class时声明的父类的范型参数的类型.
     * 如public BookManager extends GenricManager<Book>
     * @param clazz
     * @return
     */
    public static Class getSuperClassGenricType(Class clazz) {
        return getSuperClassGenricType(clazz, 0);
    }
    public static Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }
}
