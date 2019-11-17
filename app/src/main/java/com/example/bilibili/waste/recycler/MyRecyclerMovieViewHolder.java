package com.example.bilibili.waste.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.shehuan.niv.NiceImageView;

import androidx.annotation.NonNull;

@Deprecated
public class MyRecyclerMovieViewHolder extends MyRecyclerParentViewHolder {


    public NiceImageView movieImg;  //封面
    public ImageView movieClickIcon;  //播放图标
    public TextView movieClickNum; //播放量
    public ImageView movieBarrageIcon; //弹幕图标
    public TextView movieBarrageNum; //弹幕量
    public TextView movieMiniTitle; //视频标题
    public TextView movieMiniTag; //弹幕标签
    public ImageView movieMoreIcon; //更多三个点的图标

    public MyRecyclerMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        layout = itemView.findViewById(R.id.movie_box_container);
        movieImg = itemView.findViewById(R.id.movie_pic);
        movieClickIcon = itemView.findViewById(R.id.movie_click_icon);
        movieClickNum = itemView.findViewById(R.id.movie_click_num);
        movieBarrageIcon = itemView.findViewById(R.id.movie_barrage_icon);
        movieBarrageNum = itemView.findViewById(R.id.movie_barrage_num);
        movieMiniTitle = itemView.findViewById(R.id.movie_mini_title);
        movieMiniTag = itemView.findViewById(R.id.movie_mini_tag);
        movieMoreIcon = itemView.findViewById(R.id.movie_click_mini_more_icon);


//            tv.setCompoundDrawables(null,Glide.with(imageView).load("http://i2.hdslb.com/bfs/archive/9d4ade70f36af2c9a574dc31828b3f04804ddcfc.jpg").getFallbackDrawable(), null, null);
//            Glide.with(imageView).asBitmap().load("http://i2.hdslb.com/bfs/archive/9d4ade70f36af2c9a574dc31828b3f04804ddcfc.jpg").into(imageView);
        Glide.with(itemView).asBitmap().load("http://i2.hdslb.com/bfs/archive/b5eb84896fe48040c32f50d8d43bcc2ef87590ba.jpg").into(movieImg);

//            Glide.with(imageView).asBitmap().load("http://i2.hdslb.com/bfs/archive/9d4ade70f36af2c9a574dc31828b3f04804ddcfc.jpg").getFallbackDrawable()

    }

    @Override
    public int getType() {
        return MOVIE_VIEW_HOLDER;
    }

}