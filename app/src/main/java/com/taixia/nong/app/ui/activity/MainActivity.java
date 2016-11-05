package com.taixia.nong.app.ui.activity;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nong.core.recycleview.BaseQuickAdapter;
import com.nong.core.recycleview.BaseViewHolder;
import com.nong.core.recycleview.RecyclerViewBuilder;
import com.nong.core.recycleview.listener.OnItemClickListener;
import com.taixia.nong.R;
import com.taixia.nong.app.BaseActivity;
import com.taixia.nong.tools.MLog;
import com.taixia.nong.tools.MToast;

import java.util.ArrayList;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    private ArrayList<HomeItem> mDataList;
    private static final String[] TITLE = {"Animation Use", "MultipleItem Use", "HeaderAndFooter Use", "PullToRefresh Use", "Section Use", "EmptyView Use", "ItemDragAndSwipe Use","RecyclerClickItemActivity", "ExpandableItem Activity", "DataBinding Use"};
    private static final String[] COLOR_STR = {"#0dddb8","#0bd4c3","#03cdcd","#00b1c5","#04b2d1","#04b2d1","#04b2d1","#04b2d1", "#04b2d1", "#04b2d1"};

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        initData();
        BaseQuickAdapter homeAdapter = new BaseQuickAdapter<HomeItem>(R.layout.home_item_view,mDataList) {
            @Override
            protected void convert(BaseViewHolder helper, HomeItem item,int position) {
                helper.setText(R.id.info_text, item.getTitle());
                CardView cardView = helper.getView(R.id.card_view);
                cardView.setCardBackgroundColor(Color.parseColor(item.getColorStr()));
            }
        };
        homeAdapter.openLoadAnimation();
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                MToast.Toast(""+position);
            }
        });
        RecyclerViewBuilder.create(mRecyclerView).setSpaceItemDecoration(100,RecyclerViewBuilder.DECOR_VERTICAL_LIST).build();
        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeItem item = new HomeItem();
            item.setTitle(TITLE[i]);
            item.setColorStr(COLOR_STR[i]);
            mDataList.add(item);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MLog.e("onDestroy");
    }

    class HomeItem {
        private String title;
        private String colorStr;

        public String getColorStr() {
            return colorStr;
        }

        public void setColorStr(String colorStr) {
            this.colorStr = colorStr;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }
}
