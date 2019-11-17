package com.example.bilibiliproject.Fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bilibiliproject.Adater.PrettyPictureAdater;
import com.example.bilibiliproject.MemOfPurchase.MainActivity;
import com.example.bilibili.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class PrettyPictureFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView_prettypicture;

    public PrettyPictureFragment(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_prettypicture_recyclerview,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView_prettypicture = view.findViewById(R.id.recyclerview_prettypicture);
        recyclerView_prettypicture.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView_prettypicture.addItemDecoration(new MyPrettyPictureDecrtion());
        recyclerView_prettypicture.setAdapter(new PrettyPictureAdater(context, new PrettyPictureAdater.onIntemClickListener() {
            @Override
            public void OnClick(int pos) {
                Toast.makeText(context,"功能暂未开发! ",Toast.LENGTH_SHORT).show();
            }
        }));
    }
    class MyPrettyPictureDecrtion extends RecyclerView.ItemDecoration{

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = 20;
            outRect.set(gap,gap,gap,gap);
        }
    }
}
