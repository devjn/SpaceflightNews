package com.devjn.spaceflightnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindingAdapter<BINDING : ViewDataBinding, ITEM>(protected var items: List<ITEM>) :
  RecyclerView.Adapter<BindingAdapter.BindViewHolder<BINDING>>() {

  @get:LayoutRes
  protected abstract val layoutId: Int

  abstract fun bind(binding: BINDING, item: ITEM)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BindViewHolder(
    DataBindingUtil.inflate<BINDING>(LayoutInflater.from(parent.context), layoutId, parent, false)
  )

  override fun onBindViewHolder(holder: BindViewHolder<BINDING>, position: Int) {
    bind(holder.binder, items[position])
  }

  override fun getItemCount() = items.size

  fun updateData(items: List<ITEM>) {
    this.items = items
    notifyDataSetChanged()
  }

  class BindViewHolder<BINDING : ViewDataBinding>(val binder: BINDING) : RecyclerView.ViewHolder(binder.root)
}