package com.luocj.baselib;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
    private static final String TAG = BaseAdapter.class.getSimpleName();
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    protected int mLayoutId;
    protected List<T> mData;

    public BaseAdapter(@LayoutRes int layoutId, @Nullable List<T> data) {
        this.mData = data == null ? new ArrayList<T>() : data;
        if (layoutId != 0) {
            this.mLayoutId = layoutId;
        }
    }

    public BaseAdapter(@LayoutRes int layoutId) {
        this(layoutId, null);
    }

    public BaseAdapter(@Nullable List<T> data) {
        this(0, data);
    }

    @NonNull
    @Override
    public K onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        K baseViewHolder = null;
        this.mContext = parent.getContext();
        this.mLayoutInflater = LayoutInflater.from(mContext);
        baseViewHolder = onCreateDefViewHolder(parent, viewType);
        baseViewHolder.setAdapter(this);
        return baseViewHolder;
    }

    private K onCreateDefViewHolder(ViewGroup parent, int viewType) {
        View itemView = getItemView(mLayoutId, parent);
        return createBaseViewHolder(itemView);
    }

    protected K createBaseViewHolder(ViewGroup parent, int layoutResId) {
        return createBaseViewHolder(getItemView(layoutResId, parent));
    }

    @SuppressWarnings("unchecked")
    protected K createBaseViewHolder(View view) {
        return (K) new BaseViewHolder(view);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected View getItemView(@LayoutRes int layoutResId, ViewGroup parent) {
        return mLayoutInflater.inflate(layoutResId, parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull K holder, int position) {
        convert(holder, getItem(position));
    }

    @Override
    public void onBindViewHolder(@NonNull K holder, int position, @NonNull List<Object> payloads) {
        onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        Log.i(TAG, "getItemCount: " + mData.size());
        return mData.size();
    }

    protected abstract void convert(K holder, T item);

    @Nullable
    public T getItem(@IntRange(from = 0) int position) {
        if (position >= 0 && position < mData.size())
            return mData.get(position);
        else
            return null;
    }
}
