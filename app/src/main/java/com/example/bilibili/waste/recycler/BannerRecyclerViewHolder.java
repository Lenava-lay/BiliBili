package com.example.bilibili.waste.recycler;

import android.view.LayoutInflater;
import android.view.View;

import com.example.bilibili.R;
import com.lany.banner.BannerView;

import androidx.annotation.NonNull;

@Deprecated
public class BannerRecyclerViewHolder extends MyRecyclerParentViewHolder {

    public View bannerLayout;
    public BannerView bannerView;


    public BannerRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        bannerLayout = LayoutInflater.from(itemView.getContext()).inflate(R.layout.head_page_fragment, null, false);
        bannerView = bannerLayout.findViewById(R.id.banner_view);
    }


    @Override
    public int getType() {
        return BANNER_VIEW_HOLDER;
    }
}
