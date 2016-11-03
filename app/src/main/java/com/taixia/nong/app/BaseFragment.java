package com.taixia.nong.app;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle.components.RxFragment;

/**
 * Created by Administrator on 2016/8/30.
 */
public abstract class BaseFragment extends RxFragment{

    private LayoutInflater inflater;
    private View parentView;
    public abstract  @LayoutRes int getLayoutResId();
    private BaseActivity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        parentView = inflater.inflate(getLayoutResId(), container, false);
        return parentView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity= (BaseActivity) activity;
    }
    @Override
    public void onDetach()
    {

        super.onDetach();
        this.activity = null;
    }

    //标志位 fragment是否可见
    protected boolean isVisible;
    /**
     * Fragment数据的懒加载
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser)
    {

        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint())
        {
            isVisible = true;
            onVisible();
        } else
        {
            isVisible = false;
            onInvisible();
        }
    }
    protected void onVisible()
    {

        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInvisible()
    {

    }

}
