package com.example.bilibiliproject.Fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bilibiliproject.Adater.RecommandAdater;
import com.example.bilibili.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class RecommandFragment extends Fragment {
    private RecyclerView recyclerView_recommand;
    private Context context;

    public RecommandFragment(Context context){
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView_recommand = view.findViewById(R.id.recyclerview_recommand);
        recyclerView_recommand.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView_recommand.addItemDecoration(new MyRecommandDecrtion());
        recyclerView_recommand.setAdapter(new RecommandAdater(context, new RecommandAdater.onIntemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(context,"功能暂未开发!",Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recommand_recyclerview,container,false);
        return view;
    }

    class MyRecommandDecrtion extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = 20;
            outRect.set(gap,gap,gap,gap);
        }
    }
}
