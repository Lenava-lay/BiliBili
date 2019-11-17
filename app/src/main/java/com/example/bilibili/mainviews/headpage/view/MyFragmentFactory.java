package com.example.bilibili.mainviews.headpage.view;

import com.example.bilibili.R;
import com.example.bilibili.mainviews.headpage.view.fragments.BirthFragment;
import com.example.bilibili.mainviews.headpage.view.fragments.ChasingFragment;
import com.example.bilibili.mainviews.headpage.view.fragments.MovieFragment;
import com.example.bilibili.mainviews.headpage.view.fragments.PopularFragment;
import com.example.bilibili.mainviews.headpage.view.fragments.RecommendFragment;

import androidx.fragment.app.Fragment;

public class MyFragmentFactory {

    public static Fragment newInstance(int fragmentId) {
        Fragment fragment;
        switch (fragmentId) {
            case R.id.recommend_page:
                fragment = new RecommendFragment();
                break;
            case R.id.popular_page:
                fragment = new PopularFragment();
                break;
            case R.id.chasing_page:
                fragment = new ChasingFragment();
                break;
            case R.id.movie_page:
                fragment = new MovieFragment();
                break;
            case R.id.birth_page:
                fragment = new BirthFragment();
                break;
            default:
                return null;
        }


        return fragment;
    }
}
