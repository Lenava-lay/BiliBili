package com.example.bilibiliproject.Adater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bilibili.R;
import java.util.List;


public class CommodityListViewAdapter extends BaseAdapter {

    private Context context;
    private List<String> listattr;
    private List<String> listdetail;
    private LayoutInflater layoutInflater;
    private int ItemCount = 4;

    public CommodityListViewAdapter(Context context,List<String> listattr, List<String> listdetail){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.listattr = listattr;
        this.listdetail = listdetail;
    }

    @Override
    public int getCount() {
        if(listattr.size() > 4){
            return ItemCount;
        }
        return listattr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        public TextView textView_commodityattr,textView_attrdetail;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.layout_detail_list_item,null);
            viewHolder = new ViewHolder();
            viewHolder.textView_commodityattr = convertView.findViewById(R.id.textview_commodityattr);
            viewHolder.textView_attrdetail = convertView.findViewById(R.id.textview_attrdetail);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView_commodityattr.setText(listattr.get(position));
        viewHolder.textView_attrdetail.setText(listdetail.get(position));
        return convertView;
    }

    public void addItemNum(int num){
        ItemCount = num;
    }
}
