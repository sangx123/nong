/**
 * <p>Project:        patac_k226_git</p>
 * <p>Package:    com.patac.hmi.base.adapter</p>
 * <p>File:        CommonViewHolder.java</p>
 * <p>Version:         1.0.0</p>
 * <p>Date:         2016/8/25/11:35.</p>
 */
package com.nong.core.recyclerview.adapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;


/**<p>Class:        com.patac.hmi.wiget.recyclerview.adapter.CommonViewHolder</p>
 * <p>Description:        </p>
 * <pre>
 *
 * </pre>
 * @author baojianming
 * @date 2016/8/25/11:35
 * @version 1.0.0
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> viewHolder;

    public CommonViewHolder(View itemView) {
        super(itemView);
        viewHolder = new SparseArray<>();
    }

    /**
     * 通过ID来获取指定的View
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends  View> T findViewById(@IdRes int viewId){
        View childView = viewHolder.get(viewId);
        if(childView == null){
            childView = itemView.findViewById(viewId);
            viewHolder.put(viewId, childView);
        }
        return (T) childView;
    }
}