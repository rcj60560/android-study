package com.luocj.baselib;

import android.util.SparseArray;
import android.view.PointerIcon;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashSet;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private View contentView;
    private SparseArray<View> views;
    private LinkedHashSet<Integer> childClickViewIds;
    private BaseAdapter adapter;

    public BaseViewHolder(@NonNull View view) {
        super(view);
        this.views = new SparseArray<>();
        this.contentView = view;
        this.childClickViewIds = new LinkedHashSet<Integer>();
    }

    public View getContentView() {
        return contentView;
    }

    public <T, K extends BaseViewHolder> BaseViewHolder setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public BaseViewHolder setText(@IdRes int viewId, CharSequence value) {
        TextView view = getView(viewId);
        view.setText(value);
        return this;
    }

    public BaseViewHolder setText(@IdRes int viewId, @StringRes int strId) {
        TextView view = getView(viewId);
        view.setText(strId);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public BaseViewHolder addOnItemChildClick(@IdRes int... viewIds) {
        for (int viewId : viewIds) {
            childClickViewIds.add(viewId);
            View view = getView(viewId);
            if (view != null) {
                if (!view.isClickable()) {
                    view.setClickable(true);
                }

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (adapter.getOnItemChildClickListener() != null) {
                            adapter.setOnItemChildClick(v, getLayoutPosition());
                        }
                    }
                });
            }
        }
        return this;
    }
}
