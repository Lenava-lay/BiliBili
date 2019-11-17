package com.example.bilibili.waste.recycler;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public abstract class MyRecyclerParentViewHolder extends RecyclerView.ViewHolder {

    public final static int MOVIE_VIEW_HOLDER = 1;
    public final static int ADVERTISEMENT_VIEW_HOLDER = 2;
    public final static int BANNER_VIEW_HOLDER = 3;
    public final static int FOOTER_VIEW_HOLDER = 4;


    public ViewGroup layout;

    public MyRecyclerParentViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract int getType();

}
