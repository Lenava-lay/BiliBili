package com.example.bilibili.headpage;

import android.util.Log;

import com.example.bilibili.MainActivity;
import com.example.bilibili.mainviews.channel.ChannelFragment;
import com.example.bilibili.mainviews.headpage.HeadPageFragment;
import com.example.bilibili.mainviews.mine.MineFragment;
import com.example.bilibili.mainviews.shopping.ShoppingFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SetViewPager {



    /**
     * 设置view pager
     * @param fm
     * @param pager
     * @param bar  (缺少参数，暂未建立)
     */
    public void setViewPager(FragmentManager fm, ViewPager pager) {

        MyFragmentAdapter adapter = new MyFragmentAdapter(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new HeadPageFragment());
        adapter.addFragment(new ChannelFragment());
        adapter.addFragment(new ShoppingFragment());
        adapter.addFragment(new MineFragment());


        pager.setAdapter(adapter);

        Log.d(MainActivity.TAG, "setViewPager: 1");

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    public class MyFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment) {
            if(fragments == null) {
                fragments = new ArrayList<>();
            }
            fragments.add(fragment);
        }

        public void deleteFragment(int position) {
            if(fragments == null) {
                fragments = new ArrayList<>();
            }
            fragments.remove(position);
        }

        public void setFragments(List<Fragment> fragments) {
            this.fragments = fragments;
        }
    }



}
