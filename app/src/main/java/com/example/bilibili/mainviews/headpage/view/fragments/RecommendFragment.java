package com.example.bilibili.mainviews.headpage.view.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.bilibili.R;
import com.example.bilibili.data.GetNewRecommendData;
import com.example.bilibili.mainviews.headpage.view.adapters.MyRecyclerViewRecommendAdapter;
import com.example.bilibili.utils.DensityUtil;
import com.example.bilibili.utils.ThreadUtils;
import com.example.bilibili.mainviews.headpage.view.adapters.OnLoadMoreListener;
import com.example.bilibili.utils.ToastUtil;
import com.lany.banner.BannerAdapter;
import com.lany.banner.BannerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends Fragment {

    Context mContext;
    GridLayoutManager mManager;
    MyRecyclerViewRecommendAdapter mAdapter;
    RecyclerView mRecyclerView;
    SwipeRefreshLayout mRefreshLayout;

    int page = 1;

    public RecommendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(true) return;
        mContext = getContext();
        mAdapter = new MyRecyclerViewRecommendAdapter(mContext);
        mRefreshLayout = getView().findViewById(R.id.recommend_page);
        initMoviesData(true);

        mRecyclerView = getView().findViewById(R.id.recommend_page_recycler_view);
        mManager = new GridLayoutManager(mContext, 2);


        initRecyclerView();
        mAdapter.addHeader(setItems());

        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(mAdapter.getItemViewType(position) == mAdapter.MOVIE_TYPE)
                    return 1;
                else return 2;
            }
        });

    }

    //获得推荐视频的数据
    private void initMoviesData(boolean flag) {

        ThreadUtils.setInThread(new Runnable() {
            @Override
            public void run() {
                int state = GetNewRecommendData.getNewData(page, mAdapter, flag);
                if(state == GetNewRecommendData.LOAD_SUCCESSFUL) {
                    ThreadUtils.setInUIThread(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.notifyDataSetChanged();
                            mRefreshLayout.setRefreshing(false);
                        }
                    });
                } else if (state == GetNewRecommendData.LOAD_FAILD) {
                    Looper.prepare();
                    ToastUtil.makeText(mContext, "网络不良，加载失败！", Toast.LENGTH_SHORT);
                    mRefreshLayout.setRefreshing(false);
                    Looper.loop();
                }
            }
        });

    }
    //初始化RecyclerView
    private void initRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mManager);


        mRefreshLayout.setColorSchemeResources(R.color.nav_bar_text_select_color);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page += 1;
                initMoviesData(false);
            }
        });

        mRecyclerView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                ToastUtil.makeText(mContext, "正在加载", Toast.LENGTH_SHORT);

                mAdapter.setItemClickListener(new MyRecyclerViewRecommendAdapter.ItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                    }
                });

                page += 1;
                initMoviesData(true);
            }
        });
    }


    public MyRecyclerViewRecommendAdapter getmAdapter() {
        return mAdapter;
    }




    List<String> bannerSourceItems = new ArrayList<>();

    View setItems() {
        View linearLayout = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_head_layout, mRecyclerView, false);
        BannerView bannerView = linearLayout.findViewById(R.id.banner_view);

        if(bannerSourceItems == null) {
            bannerSourceItems = new ArrayList<>();
        }
        RequestOptions myOptions =new RequestOptions()
                .transform((new MultiTransformation(new CenterCrop(), new RoundedCorners(DensityUtil.dip2px(mContext,5)))));
        bannerSourceItems.clear();
        bannerSourceItems.add("http://i0.hdslb.com/bfs/archive/0e75efdfb8441fd424c3ef82e95e2c2ad7791c54.jpg");
        bannerSourceItems.add("http://i2.hdslb.com/bfs/archive/ac4ad60a441ad7d41c72d58a00f1bdd390ff9398.jpg");
        bannerSourceItems.add("http://i1.hdslb.com/bfs/archive/5e3af2630681e52a06d62ed7c8c7a7ccbc84c5d1.jpg");
        bannerSourceItems.add("http://i0.hdslb.com/bfs/archive/b7a65759d053fc3fd54a4fe51e3471917b969c07.jpg");
        setBannerImage(bannerView, myOptions);
        return linearLayout;
    }

    void setBannerImage(BannerView view, RequestOptions options) {
        view.setAdapter(new BannerAdapter<String>(bannerSourceItems) {
            @Override
            public void bindImage(ImageView imageView, String item) {
                Glide.with(mContext).load(item).error(R.drawable.ic_logo).apply(options).into(imageView);
            }

            @Override
            public void bindTitle(TextView titleText, String item) {

            }

            @Override
            public void onItemClicked(int position, String item) {

            }

        });
    }


}
