package com.example.bilibili.waste.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.example.bilibili.contentobj.AdvertisementObject;
import com.example.bilibili.contentobj.RecommendObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

@Deprecated
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerParentViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private boolean hasHeader = false;
    private boolean hasFooter = false;
    private int movieNowPosition = 0; //视频集合中显示位置
    private int adNowPosition = 0; // 广告集合中显示位置

    public List<Integer> types = new ArrayList<>();
    private List<RecommendObject> allMovies = new ArrayList<>();
    private List<AdvertisementObject> allAdvertisements = new ArrayList<>();

    private ItemClickListener listener = new ItemClickListener() {
        @Override
        public void onItemClick(int position) {

        }
    };

    public static List<MyRecyclerParentViewHolder> holders = new ArrayList<>();


    public MyRecyclerViewAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public MyRecyclerViewAdapter(Context context, List<MyRecyclerParentViewHolder> holders) {
        mContext = context;
    }

    public void setAllMovies(List<RecommendObject> allMovies) {
        this.allMovies = allMovies;
    }
    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public MyRecyclerParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = null;
        MyRecyclerParentViewHolder holder = null;
        if(viewType == MyRecyclerParentViewHolder.MOVIE_VIEW_HOLDER) {
            view = mInflater.inflate(R.layout.movie_box_item_style_1, parent, false);
            holder = new MyRecyclerMovieViewHolder(view);
            setMovieData((MyRecyclerMovieViewHolder) holder, movieNowPosition, view);
            movieNowPosition ++;
        } else if (viewType == MyRecyclerParentViewHolder.ADVERTISEMENT_VIEW_HOLDER) {
            view = mInflater.inflate(R.layout.advertisement_layout, parent, false);
            holder = new MyRecyclerAdvertisementViewHolder(view);
            setAdData((MyRecyclerAdvertisementViewHolder) holder, adNowPosition, view);
            adNowPosition ++;
        } else if (viewType == MyRecyclerParentViewHolder.BANNER_VIEW_HOLDER) {
            view = mInflater.inflate(R.layout.recycler_view_head_layout, parent, false);
            holder = new BannerRecyclerViewHolder(view);
        } else if (viewType == MyRecyclerParentViewHolder.FOOTER_VIEW_HOLDER) {
            view = mInflater.inflate(R.layout.footer_load_layout, parent, false);
            holder = new FooterRecyclerViewHolder(view);
        }
        holders.add(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerParentViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(position);
            }
        });


        if(position == getItemCount() - 1) {
            setLastItemMargin(holder);
        }
    }

    @Override
    public int getItemCount() {
//        return holders.size();
        int count = 0;
        if(hasHeader) count += 1;
        if(hasFooter) count += 1;
        count += allAdvertisements.size() + allMovies.size();
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            if(hasHeader) return MyRecyclerParentViewHolder.BANNER_VIEW_HOLDER;
        } else if (position == getItemCount() - 1) {
            if(hasFooter) return MyRecyclerParentViewHolder.FOOTER_VIEW_HOLDER;
        }

        return MyRecyclerParentViewHolder.MOVIE_VIEW_HOLDER;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }


    public MyRecyclerParentViewHolder getLastItem() {
        return holders.get(holders.size() - 1);
    }

    private void setLastItemMargin(@NonNull MyRecyclerParentViewHolder holder) {
        LinearLayout layout = ((AppCompatActivity) mContext).findViewById(R.id.bottom_nav_bar);
        layout.measure(0, 0);
        ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) holder.layout.getLayoutParams();
        margin.setMargins(0, 0, 0,
                margin.bottomMargin + layout.getMeasuredHeight());
        holder.layout.requestLayout();
    }

    /**
     *
     * @param holder
     * @param recAtListPosition 视频在视频合集中的位置，由于footer和header，会影响position数值
     */
    public void setMovieData(MyRecyclerMovieViewHolder holder, int recAtListPosition, View itemView) {
        RecommendObject rec = allMovies.get(recAtListPosition);
        Glide.with(itemView).asBitmap().load(rec.pic).into(holder.movieImg);
        holder.movieClickNum.setText("" + rec.play);
        holder.movieBarrageNum.setText("" + rec.videoReview);
        holder.movieMiniTitle.setText(rec.title);
        holder.movieMiniTag.setText(rec.typeName);
    }

    public void setAdData(MyRecyclerAdvertisementViewHolder holder, int adAtListPosition, View itemView) {
        AdvertisementObject adObj = allAdvertisements.get(adAtListPosition);
        Glide.with(itemView).asBitmap().load(adObj.img).into(holder.advertisementImage);
        holder.advertisementBigTitle.setText(adObj.title);
        holder.advertisementTagTitle.setText(adObj.tag);
    }

}
