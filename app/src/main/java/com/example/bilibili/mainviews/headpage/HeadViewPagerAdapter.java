package com.example.bilibili.mainviews.headpage;

import android.content.Context;
import android.view.LayoutInflater;

import com.example.bilibili.R;
import com.example.bilibili.mainviews.headpage.view.MyFragmentFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Placeholder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HeadViewPagerAdapter extends FragmentPagerAdapter {


    private Context mContext;


    private List<Fragment> fragments;

    @NonNull
    private int[] tabs = {
            R.string.recommend_label, R.string.popular_label,
            R.string.chasing_label, R.string.movie_label,
            R.string.birth_label,
            R.string.birth_label,
            R.string.birth_label,
            R.string.birth_label
    };

    private FragmentManager fm;

    @NonNull
    private int[] fragmentsId = {
            R.id.recommend_page, R.id.popular_page,
            R.id.chasing_page, R.id.movie_page,
            R.id.birth_page,
            R.id.birth_page,
            R.id.birth_page,
            R.id.birth_page
    };

    public HeadViewPagerAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.fm  = fm;
        mContext = context;
        fragments = new ArrayList<>();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(tabs[position]);
    }

    @Override
    public Fragment getItem(int position) {
        if(position >= fragments.size()) {
            fragments.add(MyFragmentFactory.newInstance(fragmentsId[position]));
        }


        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsId.length;
    }


    public void setTabs(@NonNull int... tabs) {
        this.tabs = tabs;
    }
    public void setFragmentsId(@NonNull int... fragmentsId) {
        this.fragmentsId = fragmentsId;
    }

    public void setFragments(@NonNull int[] fragmentsId, @NonNull int[] tabs) {
        this.fragmentsId = fragmentsId;
        this.tabs = tabs;
    }

}
