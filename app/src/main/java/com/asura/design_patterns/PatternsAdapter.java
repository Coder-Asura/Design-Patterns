package com.asura.design_patterns;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Created by Asura on 2018/3/23 17:11.
 */
public class PatternsAdapter extends RecyclerView.Adapter<PatternsAdapter.PatternsViewHolder> {
    private List<String> mNames;
    private CallBack mCallBack;

    public PatternsAdapter(List<String> names, CallBack callBack) {
        this.mNames = names;
        this.mCallBack = callBack;
    }

    @NonNull
    @Override
    public PatternsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new PatternsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PatternsViewHolder holder, int position) {
        holder.mButton.setText(mNames.get(holder.getAdapterPosition()));
        if (mCallBack != null) {
            holder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallBack.onItemClick(v, holder.getAdapterPosition());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mNames == null ? 0 : mNames.size();
    }

    static class PatternsViewHolder extends RecyclerView.ViewHolder {
        AppCompatButton mButton;

        public PatternsViewHolder(View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btn_name);
        }
    }

    interface CallBack {
        /**
         * item 点击事件
         *
         * @param view
         * @param position
         */
        void onItemClick(View view, int position);
    }
}
