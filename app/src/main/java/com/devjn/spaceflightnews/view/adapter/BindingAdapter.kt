package com.devjn.spaceflightnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BindingAdapter<BINDING : ViewBinding, ITEM>(protected var items: List<ITEM>) :
  RecyclerView.Adapter<BindingAdapter.BindViewHolder<BINDING>>() {

  protected abstract fun inflate(inflater: LayoutInflater, parent: ViewGroup): BINDING

  abstract fun bind(binding: BINDING, item: ITEM)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BindViewHolder(
    inflate(LayoutInflater.from(parent.context), parent)
  )

  override fun onBindViewHolder(holder: BindViewHolder<BINDING>, position: Int) {
    bind(holder.binder, items[position])
  }

  override fun getItemCount() = items.size

  fun updateData(items: List<ITEM>) {
    this.items = items
    notifyDataSetChanged()
  }

  class BindViewHolder<BINDING : ViewBinding>(val binder: BINDING) :
    RecyclerView.ViewHolder(binder.root)
}
