package com.example.bilibiliproject.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bilibili.R;

import androidx.recyclerview.widget.RecyclerView;

public class CommodityAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private onIntemClickListener listener;

    public CommodityAdater(Context context, onIntemClickListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecommandViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_commodity_item,null));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class RecommandViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public RecommandViewHolder( View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
        }
    }

    public interface onIntemClickListener{
        void OnClick(int pos);
    }

}
