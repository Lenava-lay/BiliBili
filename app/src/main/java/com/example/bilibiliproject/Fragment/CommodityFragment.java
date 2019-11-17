package com.example.bilibiliproject.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bilibiliproject.Adater.CommodityAdater;
import com.example.bilibiliproject.MemOfPurchase.CommodityDetailActivity;
import com.example.bilibili.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class CommodityFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView_commodity;

    public CommodityFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_commodity_recyclerview,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView_commodity = view.findViewById(R.id.recyclerview_commodity);
        recyclerView_commodity.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView_commodity.addItemDecoration(new MyCommodityDecrtion());
        recyclerView_commodity.setAdapter(new CommodityAdater(context, new CommodityAdater.onIntemClickListener() {
            @Override
            public void OnClick(int pos) {
                Intent intent = new Intent(context,CommodityDetailActivity.class);
                startActivity(intent);
            }
        }));
    }

    class MyCommodityDecrtion extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = 20;
            outRect.set(gap,gap,gap,gap);
        }
    }
}
