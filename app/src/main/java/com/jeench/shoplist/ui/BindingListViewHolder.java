package com.jeench.shoplist.ui;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Radik on 01.12.2017.
 */

public class BindingListViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public final T binding;

    public BindingListViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
