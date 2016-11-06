/**
 * <p>Project: nong</p>
 * <p>Package: com.taixia.nong.tools</p>
 * <p>File: MHashMap.java</p>
 * <p>Date: 2016/10/28/17:00.</p>
 */
package com.taixia.nong.tools;

import com.taixia.nong.app.BaseConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**<p>Class: com.taixia.nong.tools.MHashMap</p>
 * <p>Description: </p>
 * <pre>
 * </pre>
 * @author
 * @date 2016/10/28/17:00
 */

public class MHashMap extends BaseConfig {
    public static <T,V> List<V> hashMapToListOnlyValue(HashMap<T,V> hashMap){
        ArrayList<V> list=new ArrayList<>();
        Iterator iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            T key = (T) entry.getKey();
            V val = (V) entry.getValue();
            list.add(val);
        }
        return list;
    }
}
