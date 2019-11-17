package com.example.bilibili.mainviews.headpage.view.fragments;


import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.bilibili.R;
import com.example.bilibili.mainviews.headpage.view.adapters.MyRecyclerViewPopularAdapter;
import com.example.bilibili.mainviews.headpage.view.adapters.OnLoadMoreListener;
import com.example.bilibili.utils.DensityUtil;
import com.example.bilibili.utils.ToastUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {

    private Context mContext;

    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getContext();
        SwipeRefreshLayout refreshLayout = getView().findViewById(R.id.popular_page);
        RecyclerView recyclerView = getView().findViewById(R.id.popular_page_recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        manager.setOrientation(RecyclerView.VERTICAL);
        MyRecyclerViewPopularAdapter adapter = new MyRecyclerViewPopularAdapter(mContext);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(manager);

        View layout = LayoutInflater.from(mContext).inflate(R.layout.popular_header_layout, recyclerView, false);
        adapter.addHeader(layout);
        refreshLayout.setColorSchemeResources(R.color.nav_bar_text_select_color);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 下拉刷新

                refreshLayout.setRefreshing(false);
            }
        });

        recyclerView.addOnScrollListener(new OnLoadMoreListener() {
            @Override
            protected void onLoading(int countItem, int lastItem) {
                ToastUtil.makeText(mContext, "正在加载", Toast.LENGTH_SHORT);
            }
        });
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0, 0, 0, DensityUtil.dip2px(mContext, 1));
            }
        });

    }
}
