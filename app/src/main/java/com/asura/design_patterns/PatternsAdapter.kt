package com.asura.design_patterns

import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Created by Asura on 2018/3/23 17:11.
 */
class PatternsAdapter(private val mNames: List<String>?, private val mCallBack: CallBack?) : RecyclerView.Adapter<PatternsAdapter.PatternsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatternsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return PatternsViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatternsViewHolder, position: Int) {
        holder.mButton.text = mNames!![holder.adapterPosition]
        if (mCallBack != null) {
            holder.mButton.setOnClickListener { v -> mCallBack.onItemClick(v, holder.adapterPosition) }
        }
    }

    override fun getItemCount(): Int {
        return mNames?.size ?: 0
    }

    class PatternsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mButton: AppCompatButton

        init {
            mButton = itemView.findViewById(R.id.btn_name)
        }
    }

    interface CallBack {
        /**
         * item 点击事件
         *
         * @param view
         * @param position
         */
        fun onItemClick(view: View, position: Int)
    }
}
