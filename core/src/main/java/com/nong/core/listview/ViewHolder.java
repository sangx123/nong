package com.nong.core.listview;

import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;

public class ViewHolder {

    private SparseArray<View> mViews;
    public   View itemView;

    public ViewHolder(View itemView) {
        this.mViews = new SparseArray<View>();
        this.itemView = itemView;
    }



    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T findViewById( @IdRes int viewId) {
        View view = mViews.get(viewId);
        if (view == null)
        {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


}
