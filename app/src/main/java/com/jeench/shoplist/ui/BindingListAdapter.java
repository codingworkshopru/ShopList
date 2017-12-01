package com.jeench.shoplist.ui;

import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Radik on 01.12.2017.
 */

public abstract class BindingListAdapter<T, V extends ViewDataBinding> extends RecyclerView.Adapter<BindingListViewHolder<V>> {
    @Nullable
    private List<T> items;

    public BindingListAdapter() {
    }

    public BindingListAdapter(@Nullable List<T> items) {
        this.items = items;
    }

    @Override
    public BindingListViewHolder<V> onCreateViewHolder(ViewGroup parent, int viewType) {
        V binding = createBinding(parent);
        return new BindingListViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(BindingListViewHolder<V> holder, int position) {
        if (items == null) {
            throw new NullPointerException("Items list is pointing to null");
        }

        bind(holder.binding, items.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setItems(@Nullable List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    protected abstract V createBinding(ViewGroup parent);
    protected abstract void bind(V binding, T item);
}
