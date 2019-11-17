package com.example.bilibili.waste.recycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;

import androidx.annotation.NonNull;

@Deprecated
public class MyRecyclerAdvertisementViewHolder extends MyRecyclerParentViewHolder {


    public TextView advertisementBigTitle;
    public ImageView advertisementImage;
    public TextView advertisementTag;
    public TextView advertisementTagTitle;
    public ImageView advertisementTagMoreImage;



    public MyRecyclerAdvertisementViewHolder(@NonNull View itemView) {
        super(itemView);

        layout = itemView.findViewById(R.id.advertisement_box_container);
        advertisementBigTitle = itemView.findViewById(R.id.advertisement_big_title);
        advertisementImage = itemView.findViewById(R.id.advertisement_image);
        advertisementTag = itemView.findViewById(R.id.advertisement_tag);
        advertisementTagTitle = itemView.findViewById(R.id.advertisement_tag_title);
        advertisementTagMoreImage = itemView.findViewById(R.id.advertisement_tag_more_image);

        Glide.with(itemView).asBitmap().load("http://i2.hdslb.com/bfs/archive/9d4ade70f36af2c9a574dc31828b3f04804ddcfc.jpg").into(advertisementImage);
    }

    @Override
    public int getType() {
        return ADVERTISEMENT_VIEW_HOLDER;
    }

}