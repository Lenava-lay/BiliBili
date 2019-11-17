package com.example.bilibili.waste.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;

@Deprecated
public class FooterRecyclerViewHolder extends MyRecyclerParentViewHolder {

    public ContentLoadingProgressBar progressBar;

    public FooterRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        progressBar = new ContentLoadingProgressBar(itemView.getContext());
    }

    @Override
    public int getType() {
        return FOOTER_VIEW_HOLDER;
    }
}
