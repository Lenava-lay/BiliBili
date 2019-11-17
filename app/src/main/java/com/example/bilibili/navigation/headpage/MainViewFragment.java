package com.example.bilibili.navigation.headpage;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bilibili.MainActivity;
import com.example.bilibili.R;
import com.example.bilibili.mainviews.channel.ChannelFragment;
import com.example.bilibili.mainviews.headpage.HeadPageFragment;
import com.example.bilibili.mainviews.mine.MineFragment;
import com.example.bilibili.mainviews.shopping.ShoppingFragment;
import com.example.bilibili.misc.NavBarCreate;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainViewFragment extends Fragment {


    Map<Integer, Fragment> fragmentMap;
    FragmentManager manager;
    FragmentTransaction transaction;

    View selectedView;
    Fragment currentFragment;

    public MainViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_view, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        initSetting();

    }

    public void initSetting() {
        manager = requireActivity().getSupportFragmentManager();
        currentFragment = new HeadPageFragment();
        selectedView = getView().findViewById(R.id.nav_bar_generate);
        setFragmentMap();
        setColor(selectedView);
        switchFragment(currentFragment, fragmentMap.get(selectedView.getId()));
        initClick();
    }



    private void initClick() {
        LinearLayout layout = getView().findViewById(R.id.bottom_nav_bar);
        int len = layout.getChildCount();
        for(int i = 0; i < len; i++) {
            layout.getChildAt(i).setOnClickListener(v -> {
                setColorAndFragment(v);
            });
        }
    }

    private void setFragmentMap() {

        fragmentMap = new HashMap<>();
        fragmentMap.put(selectedView.getId(), currentFragment);
        fragmentMap.put(R.id.nav_bar_channel, new ChannelFragment());
        fragmentMap.put(R.id.nav_bar_shopping, new ShoppingFragment());
        fragmentMap.put(R.id.nav_bar_self, new MineFragment());
    }


    private void setColorAndFragment(View view) {
        if(view != selectedView) {
            setColor(view);
        }
        switchFragment(currentFragment, getFragment(view.getId()));
    }

    private void setColor(View view) {
        selectedView.setSelected(false);
        ((TextView) selectedView).setTextColor(getResources().getColor(R.color.nav_bar_text_color));

        view.setSelected(true);
        ((TextView) view).setTextColor(getResources().getColor(R.color.nav_bar_text_select_color));
        selectedView = view;
    }

    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        transaction = manager.beginTransaction();

        if (toFragment.isAdded()) {
            transaction.hide(fromFragment).show(toFragment).commit();
        } else {
            transaction.hide(fromFragment).add(R.id.nav_fragment_container, toFragment).show(toFragment).commit();
        }
        currentFragment = toFragment;
    }


    private Fragment getFragment(int navBarId) {
        return fragmentMap.get(navBarId);

    }







}






