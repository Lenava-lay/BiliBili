package com.example.bilibili.mainviews.headpage.view.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.shehuan.niv.NiceImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerPopularViewHolder extends RecyclerView.ViewHolder {


    public ViewGroup layout;
    public ImageView movieImg;  //封面
    public TextView movieMiniTime; //视频时间
    public TextView movieMiniTitle; //视频标题
    public TextView movieClickNum; //点击量
    public TextView movieMiniTag; //播放量和时间标签
    public ImageView movieMoreIcon; //更多三个点的图标

    public MyRecyclerPopularViewHolder(@NonNull View itemView) {
        super(itemView);
        layout = itemView.findViewById(R.id.popular_item);
        movieImg = itemView.findViewById(R.id.popular_item_img);
        movieMiniTime = itemView.findViewById(R.id.popular_movie_time);
        movieMiniTitle = itemView.findViewById(R.id.popular_item_title);
        movieClickNum = itemView.findViewById(R.id.popular_click_num);
        movieMiniTag = itemView.findViewById(R.id.popular_review_and_retime);
        movieMoreIcon = itemView.findViewById(R.id.movie_click_mini_more_icon);


    }

}