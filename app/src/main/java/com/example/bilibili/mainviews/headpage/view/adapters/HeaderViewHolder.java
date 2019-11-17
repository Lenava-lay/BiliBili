package com.example.bilibili.mainviews.headpage.view.adapters;

import android.view.LayoutInflater;
import android.view.View;

import com.example.bilibili.R;
import com.lany.banner.BannerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public View bannerLayout;
//    public BannerView bannerView;

    public HeaderViewHolder(@NonNull View itemView) {
        super(itemView);
//        bannerLayout = LayoutInflater.from(itemView.getContext()).inflate(R.layout.head_page_fragment, null, false);
//        bannerView = bannerLayout.findViewById(R.id.banner_view);
    }
}
