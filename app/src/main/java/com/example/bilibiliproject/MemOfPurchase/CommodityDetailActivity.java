package com.example.bilibiliproject.MemOfPurchase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.bilibiliproject.Adater.CommodityListViewAdapter;
import com.example.bilibili.R;
import com.example.bilibiliproject.Util.GlideImageLoader;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CommodityDetailActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ScrollView scrollView_commodity;
    private ImageView textView_back;
    private LinearLayout linearLayout_top;
    private Banner banner_commoditys;
    private ListView listView_commoditydetail;
    private View footview;
    private ImageView ivDowan;
    private CommodityListViewAdapter myadapter;
    private List<String> listattr;
    private List<String> listdetail;
    private LinearLayout linearLayout_item1;
    private LinearLayout linearLayout_item2;
    private LinearLayout linearLayout_item3;
    private boolean IsSlide = false;//是否为滑动操作,默认为滑动操作
    //表示item的高度
    private int itemHeight1;
    private int itemHeight2;
    private int itemHeight3;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commodity_detail);
        tabLayout = findViewById(R.id.tablayout_title);
        linearLayout_top = findViewById(R.id.linearlayout_top);
        scrollView_commodity = findViewById(R.id.scrollView_commodity);
        linearLayout_item1 = findViewById(R.id.linearlayout_item1);
        linearLayout_item2 = findViewById(R.id.linearlayout_item2);
        linearLayout_item3 = findViewById(R.id.linearlayout_item3);
        linearLayout_top.bringToFront();
        AddTab();
        LoadCommodity();
        Goback();
        onBindListView();
        //绑定scrollview与tablayout
        onBindScrollViewWithTabLayout();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        itemHeight1 = linearLayout_item1.getMeasuredHeight();//表示第一个item高度
        itemHeight2 = linearLayout_item1.getMeasuredHeight() + linearLayout_item2.getMeasuredHeight();
        itemHeight3 = linearLayout_item1.getMeasuredHeight() + linearLayout_item2.getMeasuredHeight() + linearLayout_item3.getMeasuredHeight();
    }

    public void LoadCommodity(){
        banner_commoditys = findViewById(R.id.banner_commoditys);
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.a);
        images.add(R.drawable.b);
        images.add(R.drawable.c);
        images.add(R.drawable.d);
        images.add(R.drawable.e);
        banner_commoditys.setBannerStyle(BannerConfig.NUM_INDICATOR);
        banner_commoditys.setImageLoader(new GlideImageLoader());
        banner_commoditys.setImages(images);
        banner_commoditys.setBannerAnimation(Transformer.Default);
        banner_commoditys.isAutoPlay(false);
        banner_commoditys.start();
    }
    public void AddTab(){
        TabLayout.Tab tab1 = tabLayout.newTab().setText("商品");
        TabLayout.Tab tab2 = tabLayout.newTab().setText("评论");
        TabLayout.Tab tab3 = tabLayout.newTab().setText("详情");
        tabLayout.addTab(tab1);
        tabLayout.addTab(tab2);
        tabLayout.addTab(tab3);
    }
    public void Goback(){
        textView_back = findViewById(R.id.imageview_back);
        textView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommodityDetailActivity.this,MainActivity.class);
                startActivity(intent);
                CommodityDetailActivity.this.finish();
            }
        });
    }
    public void InitData(){
        listattr = new ArrayList<>();
        listdetail = new ArrayList<>();
        listattr.add("尺寸");
        listdetail.add("高约27.2cm");
        listattr.add("系列");
        listdetail.add("手办系列");
        listattr.add("材质");
        listdetail.add("PVC;ABS");
        listattr.add("适合年龄");
        listdetail.add("14岁以上");
        listattr.add("发售日");
        listdetail.add("2020年5月");
        listattr.add("类别");
        listdetail.add("不可动手办");
        listattr.add("IP");
        listdetail.add("高达系列");
        listattr.add("品牌");
        listdetail.add("万达");

    }
    //动态设置listview高度
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);  // 获取item高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // 最后再加上分割线的高度和padding高度，否则显示不完整。
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1))+listView.getPaddingTop()+listView.getPaddingBottom();
        listView.setLayoutParams(params);
    }
    public void onBindListView(){
        listView_commoditydetail = findViewById(R.id.list_commoditydetal);
        listView_commoditydetail.setDivider(new ColorDrawable(getResources().getColor(R.color.colorWhite)));
        listView_commoditydetail.setDividerHeight(2);
        footview = getLayoutInflater().inflate(R.layout.layout_detail_list_foot,null);
        ivDowan = footview.findViewById(R.id.iv_down);
        listView_commoditydetail.addFooterView(footview);
        ivDowan.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp));
        InitData();
        myadapter = new CommodityListViewAdapter(CommodityDetailActivity.this,listattr,listdetail);
        listView_commoditydetail.setAdapter(myadapter);
        setListViewHeightBasedOnChildren(listView_commoditydetail);
        ivDowan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myadapter.getCount() == 4){
                    myadapter.addItemNum(listattr.size());
                    ivDowan.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp));
                    setListViewHeightBasedOnChildren(listView_commoditydetail);
                    myadapter.notifyDataSetChanged();
                }else{
                    myadapter.addItemNum(4);
                    ivDowan.setImageDrawable(getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp));
                    setListViewHeightBasedOnChildren(listView_commoditydetail);
                    myadapter.notifyDataSetChanged();
                }
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onBindScrollViewWithTabLayout(){
        //ScrollView滑动监听
        scrollView_commodity.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                IsSlide = true;//此时正在滑动
                if (scrollY < itemHeight1) {//表明此时在Item1范围内，所以第一个Item应该被选择
                    Objects.requireNonNull(tabLayout.getTabAt(0)).select();
                } else if (scrollY >= itemHeight1 && scrollY < itemHeight2) {//表明此时在Item2范围内，所以第二个Item应该被选择
                    Objects.requireNonNull(tabLayout.getTabAt(1)).select();
                } else if (scrollY >= itemHeight2 && scrollY < itemHeight3) {//表明此时在Item3范围内，所以第三个Item应该被选择
                    Objects.requireNonNull(tabLayout.getTabAt(2)).select();
                }
                IsSlide = false;//表明滑动结束
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = LayoutInflater.from(CommodityDetailActivity.this).inflate(R.layout.layout_tablayout_text, null);
                TextView tv_tab = view.findViewById(R.id.text_tablayout);
                tv_tab.setTextSize(20);
                tv_tab.setTextColor(Color.BLACK);
                tv_tab.setText(tab.getText());
                tab.setCustomView(tv_tab);
                if(IsSlide){
                    return;
                }
                int position = tab.getPosition();//当前被选中标签
                if(position == 0){
                    scrollView_commodity.smoothScrollTo(0,0);
                }else if(position == 1){
                    scrollView_commodity.smoothScrollTo(0,itemHeight1);
                }else if(position == 2){
                    scrollView_commodity.smoothScrollTo(0,itemHeight2);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setCustomView(null);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
