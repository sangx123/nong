package com.nong.core.listview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class CommonAdapter<T> extends BaseAdapter {

    private Context mContext;
    private @LayoutRes
    int layoutId;
    private List<T> datas;

    private final Object mLock = new Object();
    private boolean mNotifyOnChange = true;

    public CommonAdapter(Context mContext, @LayoutRes int layoutId, List<T> datas){
        this.mContext = mContext;
        this.layoutId = layoutId;
        this.datas = datas;
    }

    public CommonAdapter(Context mContext, @LayoutRes int layoutId){
       this(mContext, layoutId, new ArrayList<T>());
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
            holder = new ViewHolder( convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        convert(holder, getItem(position), position);
        return convertView;
    }


    public void add(T object) {
        synchronized (mLock) {
            datas.add(object);
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }


    public void addAll(Collection<? extends T> collection) {
        synchronized (mLock) {
            datas.addAll(collection);
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    public void addAll(T ... items) {
        synchronized (mLock) {
            Collections.addAll(datas, items);
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    public void insert(T object, int index) {
        synchronized (mLock) {
            datas.add(index, object);
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    public void remove(T object) {
        synchronized (mLock) {
            datas.remove(object);
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    public void clear() {
        synchronized (mLock) {
            datas.clear();
        }
        if (mNotifyOnChange) notifyDataSetChanged();
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        mNotifyOnChange = true;
    }

    /**
     * set at once changge
     * @param notifyOnChange
     */
    public void setNotifyOnChange(boolean notifyOnChange) {
        mNotifyOnChange = notifyOnChange;
    }


    protected abstract void convert(ViewHolder viewHolder, T item, int position);


}
