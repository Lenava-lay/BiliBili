package com.example.bilibiliproject.MemOfPurchase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.bilibiliproject.Fragment.CommodityFragment;
import com.example.bilibiliproject.Fragment.InfomationFragment;
import com.example.bilibiliproject.Fragment.PrettyPictureFragment;
import com.example.bilibiliproject.Fragment.RecommandFragment;
import com.example.bilibiliproject.PageFragmentAdapter.TabPageFragmentAdapter;
import com.example.bilibili.R;
import com.example.bilibiliproject.Util.GlideImageLoader;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoaderImage();
        tabLayout = findViewById(R.id.tablayout_main);
        viewPager = findViewById(R.id.viewpager_items);
        onBindData();
        tabLayout.setupWithViewPager(viewPager);
        init();
        Listener();
    }

    public void Listener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_tablayout_text, null);
                TextView tv_tab = view.findViewById(R.id.text_tablayout);
                tv_tab.setTextSize(20);
                tv_tab.setTextColor(Color.BLACK);
                tv_tab.setText(tab.getText());
                tab.setCustomView(tv_tab);
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

    public void onBindData(){
        String[] mTabNames=new String[]{"推荐","商品","美图","情报"};
        fragments = new ArrayList<>();
        fragments.add(new RecommandFragment(MainActivity.this));
        fragments.add(new CommodityFragment(MainActivity.this));
        fragments.add(new PrettyPictureFragment(MainActivity.this));
        fragments.add(new InfomationFragment(MainActivity.this));
        TabPageFragmentAdapter tabPageAdapter = new TabPageFragmentAdapter(getSupportFragmentManager(),fragments,mTabNames);
        viewPager.setAdapter(tabPageAdapter);

    }

    public void LoaderImage(){
        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.a);
        images.add(R.drawable.b);
        images.add(R.drawable.c);
        images.add(R.drawable.d);
        images.add(R.drawable.e);
        Banner banner = findViewById(R.id.banner_1);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.Default);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(3000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public void init(){
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_tablayout_text, null);
        textView = view.findViewById(R.id.text_tablayout);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        textView.setText(tabLayout.getTabAt(0).getText());
        tabLayout.getTabAt(0).setCustomView(textView);
    }
}
