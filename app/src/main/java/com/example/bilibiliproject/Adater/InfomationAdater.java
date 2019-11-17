package com.example.bilibiliproject.Adater;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bilibili.R;

import androidx.recyclerview.widget.RecyclerView;


public class InfomationAdater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private onIntemClickListener listener;

    public InfomationAdater(Context context,onIntemClickListener listener){
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new InfomationViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_infomation_item,null));

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {
        ((InfomationViewHolder)viewHolder).textView1.setOnClickListener(new View.OnClickListener() {
            private boolean isDianzan = false;
            @Override
            public void onClick(View v) {
                if(!isDianzan){
                    isDianzan = true;
                    Drawable drawable = context.getResources().getDrawable(R.drawable.dianzan_1);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    ((InfomationViewHolder)viewHolder).textView1.setCompoundDrawables(drawable,null,null,null);
                }else{
                    isDianzan = false;
                    Drawable drawable = context.getResources().getDrawable(R.drawable.dianzan);
                    drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
                    ((InfomationViewHolder)viewHolder).textView1.setCompoundDrawables(drawable,null,null,null);
                }
            }

        });
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

    class InfomationViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        private TextView textView1;

        public InfomationViewHolder( View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
            textView1 = itemView.findViewById(R.id.tv_4);
        }
    }

    public interface onIntemClickListener{
        void OnClick(int pos);
    }

}
