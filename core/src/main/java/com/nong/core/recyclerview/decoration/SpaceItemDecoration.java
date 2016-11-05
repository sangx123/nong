/**
 * <p>Project:        venus</p>
 * <p>Package:    com.tp.venus.base.decoration</p>
 * <p>File:        SpaceItemDecoration.java</p>
 * <p>Version:         4.0.0</p>
 * <p>Date:         2016/2/2/9:50.</p>
 */
package com.nong.core.recyclerview.decoration;

import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**<p>Class:        com.tp.venus.base.decoration.SpaceItemDecoration</p>
 * <p>Description:        </p>
 * <pre>
 * RecyclerView space item
 * </pre>
 * @author baojianming
 * @date 2016/2/2/9:50
 * @version 1.0.0
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int space;
    private int orientation;

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    public SpaceItemDecoration(int space, int orientation) {
        this.space = space;
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (orientation == VERTICAL_LIST){
            outRect.set(0, 0, 0, space);
        } else{
            outRect.set(0, 0, space, 0);
        }
    }

}
