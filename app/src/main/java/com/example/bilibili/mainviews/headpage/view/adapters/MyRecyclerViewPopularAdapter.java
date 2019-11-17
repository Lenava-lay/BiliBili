package com.example.bilibili.mainviews.headpage.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.bilibili.R;
import com.example.bilibili.contentobj.PopularObject;
import com.example.bilibili.contentobj.RecommendObject;
import com.example.bilibili.utils.CornerTransform;
import com.example.bilibili.utils.DensityUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewPopularAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private boolean hasHeader = false;
    private boolean hasFooter = false;
    private int countHF;

    public static final int MOVIE_TYPE = 1;
    public static final int HEADER_TYPE = 2;
    public static final int FOOTER_TYPE = 3;

    private HeaderViewHolder header;

    public List<PopularObject> getAllPopular() {
        return allPopular;
    }

    private List<PopularObject> allPopular = new ArrayList<>();

    private ItemClickListener listener = new ItemClickListener() {
        @Override
        public void onItemClick(int position) {

        }
    };

    public static List<RecyclerView.ViewHolder> holders = new ArrayList<>();


    public MyRecyclerViewPopularAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }


    public void setAllMovies(List<PopularObject> allPopular) {
        this.allPopular = allPopular;
    }
    public void setItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        if(viewType == MOVIE_TYPE) {
            view = mInflater.inflate(R.layout.popular_item_layout, parent, false);
            holder = new MyRecyclerPopularViewHolder(view);
        } else if (viewType == HEADER_TYPE) {
            holder = header;
        }
        holders.add(holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(position == getItemCount() - 1) {
            setLastItemMargin((MyRecyclerPopularViewHolder) holder);
        }
    }

    @Override
    public int getItemCount() {
//        return allPopular.size() + countHF;
        return 20;
    }

    @Override
    public int getItemViewType(int position) {

//        if(true) return super.getItemViewType(position);

        if(position == 0) {
            if(hasHeader) return HEADER_TYPE;
        } else if(position == getItemCount() - 1) {
            if(hasFooter) return FOOTER_TYPE;
        }
        return MOVIE_TYPE;
    }

//    @Override
//    public long getItemId(int position) {
//        return allPopular.get(position).aid;
//    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }




    public RecyclerView.ViewHolder getLastItem() {
        return holders.get(holders.size() - 1);
    }

    private void setLastItemMargin(@NonNull MyRecyclerPopularViewHolder holder) {
        LinearLayout layout = ((AppCompatActivity) mContext).findViewById(R.id.bottom_nav_bar);
        layout.measure(0, 0);
        ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) holder.layout.getLayoutParams();
        margin.setMargins(0, 0, 0,
                margin.bottomMargin + layout.getMeasuredHeight());
        holder.layout.requestLayout();
    }

    public void setMovieData(MyRecyclerRecommendViewHolder holder, int position) {
        PopularObject rec;
        if(hasHeader) {
           rec = allPopular.get(position - 1);
        } else {
            rec = allPopular.get(position);
        }

//        CornerTransform transform = new CornerTransform(mContext, DensityUtil.dip2px(mContext, 5));
//
//        transform.setNeedCorner(true, true, false, false);
//
//        Glide.with(holder.itemView)
//
//                .load(rec.pic)
//
//                .transform(transform)
//
//                .into(holder.movieImg);
    }


    public void addHeader(View view) {
        if(hasHeader) return;
        hasHeader = true;
        header = new HeaderViewHolder(view);
        countHF += 1;
    }

    public void removeHeader() {
        if(hasHeader) {
            hasHeader = false;
            countHF -= 1;
            header = null;
        }
    }

    public boolean hasHeader() {
        return hasHeader;
    }

    public boolean hasFooter() {
        return hasFooter;
    }
}
