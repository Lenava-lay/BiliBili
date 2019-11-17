package com.example.bilibili.mainviews.headpage.view.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.example.bilibili.waste.recycler.MyRecyclerParentViewHolder;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.shehuan.niv.NiceImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerRecommendViewHolder extends RecyclerView.ViewHolder {


    public ViewGroup layout;
    public NiceImageView movieImg;  //封面
    public ImageView movieClickIcon;  //播放图标
    public TextView movieClickNum; //播放量
    public ImageView movieBarrageIcon; //弹幕图标
    public TextView movieBarrageNum; //弹幕量
    public TextView movieMiniTitle; //视频标题
    public TextView movieMiniTag; //弹幕标签
    public TextView movieMiniTime; //视频时间
    public ImageView movieMoreIcon; //更多三个点的图标

    public MyRecyclerRecommendViewHolder(@NonNull View itemView) {
        super(itemView);
        layout = itemView.findViewById(R.id.movie_box_container);
        movieImg = itemView.findViewById(R.id.movie_pic);
        movieClickIcon = itemView.findViewById(R.id.movie_click_icon);
        movieClickNum = itemView.findViewById(R.id.movie_click_num);
        movieBarrageIcon = itemView.findViewById(R.id.movie_barrage_icon);
        movieBarrageNum = itemView.findViewById(R.id.movie_barrage_num);
        movieMiniTitle = itemView.findViewById(R.id.movie_mini_title);
        movieMiniTag = itemView.findViewById(R.id.movie_mini_tag);
        movieMiniTime = itemView.findViewById(R.id.movie_time);
        movieMoreIcon = itemView.findViewById(R.id.movie_click_mini_more_icon);

    }

}