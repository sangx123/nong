package com.nong.core.recyclerview.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class CommonAdapter<T, VH extends CommonViewHolder> extends RecyclerView.Adapter<CommonViewHolder> {

    protected List<T> datas;
    protected LayoutInflater mLayoutInflater;
    protected int resources;
    protected Context mContext;
    protected final Object mLock = new Object();

    private OnRecyclerViewItemClickListener<T> mOnRecyclerViewItemClickListener;

    public CommonAdapter(Context mContext, @LayoutRes int resources){
        this(mContext, resources, new ArrayList<T>());
    }

    public CommonAdapter(Context mContext, @LayoutRes int resources, List<T> datas){
        this.resources = resources;
        this.datas = datas;
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * on Item click listener
     * @param <T>
     */
    public  interface OnRecyclerViewItemClickListener<T>{
        void onItemClick(View view, T item, int position);
    }

    /**
     * add listener
     * @param mOnRecyclerViewItemClickListener
     */
    public void addOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener ){
        this.mOnRecyclerViewItemClickListener = mOnRecyclerViewItemClickListener;
    }

    /**
     * get onclick listener
     * @return
     */
    protected View.OnClickListener getOnClickListener(final View view,final T item, final int position){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mOnRecyclerViewItemClickListener.onItemClick(view, item, position);
            }
        };
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(resources, parent, false);
        return (VH) getViewHolder(view, parent);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        if( mOnRecyclerViewItemClickListener != null ){
            View.OnClickListener mOnClickListener = getOnClickListener(holder.itemView, getItem(position), position);
            holder.itemView.setOnClickListener(mOnClickListener);
        }
        convert((VH) holder, getItem(position), position);
    }


    /**
     * When need to rewrite
     * @param view
     * @param parent
     * @return
     */
    protected CommonViewHolder getViewHolder(View view, ViewGroup parent){
        return  new CommonViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public T getItem(int position){
        return datas.get(position);
    }

    /**
     * add all datas
     * @param collection
     */
    public void addAll(Collection<? extends T> collection){
        if( collection == null ){
            return ;
        }
        synchronized (mLock) {
            this.datas.addAll(collection);
        }
        notifyDataSetChanged();
    }

    /**
     * add item data
     * @param data
     */
    public void add(T data){
        if( data == null){
            return ;
        }
        synchronized (mLock){
            this.datas.add(data);
        }
        notifyDataSetChanged();
    }

    /**
     * Refresh the specified entry
     * @param postion
     * @param data
     */
    public void refresh(int postion, T data){
        synchronized (mLock) {
            datas.set(postion, data);
        }
        notifyItemChanged(postion);
    }

    /**
     * Insert in a position
     * @param data
     * @param location
     */
    public void add(T data, int location){
        if( data == null){
            return ;
        }
        synchronized (mLock){
            this.datas.add(location, data);
        }
        notifyDataSetChanged();
    }

    /**
     *  remove in a position
     * @param position
     */
    public void remove(int position){
        synchronized (mLock) {
            this.datas.remove(position);
        }
        notifyItemRemoved(position);
    }

    /**
     *  remove
     * @param data
     */
    public void remove(T data){
        synchronized (mLock){
            this.datas.remove(data);
        }
        notifyDataSetChanged();
    }

    /**
     * clear
     */
    public void clear(){
        synchronized (mLock) {
            this.datas.clear();
        }
        notifyDataSetChanged();
    }

    /**
     *
     * @return
     */
    public List<T> getDatas(){
        return this.datas;
    }

    public Context getContext(){
        return this.mContext;
    }

    public boolean isLast(int position){
        return (datas.size() - 1) == position;
    }

    public abstract void convert(VH mCommonViewHolder, T item, int position);



}
