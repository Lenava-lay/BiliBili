package com.example.bilibili.misc;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bilibili.R;

import java.util.ArrayList;
import java.util.Random;

public class NavBarCreate {

    int[] barText;
    int[] barIcon;

    Context container;

    // 导航浏览控件集合
    private ArrayList<TextView> tvs = new ArrayList<>();

    public int[] getBarText() {
        return barText;
    }

    public void setBarText(int[] barText) {
        this.barText = barText;
    }

    public int[] getBarIcon() {
        return barIcon;
    }

    public void setBarIcon(int[] barIcon) {
        this.barIcon = barIcon;
    }

    public Context getContainer() {
        return container;
    }

    public void setContainer(Context container) {
        this.container = container;
    }


    public NavBarCreate(Context container) {
        this.container = container;
        barIcon = new int[] {
                R.drawable.ic_generate,
                R.drawable.ic_channel,
                R.drawable.ic_shopping,
                R.drawable.ic_self
        };
        barText = new int[] {
                R.string.text_generate,
                R.string.text_channel,
                R.string.text_shopping,
                R.string.text_self
        };
    }

    public NavBarCreate(Context container, int[] barText, int[] barIcon) {
        this.barText = barText;
        this.barIcon = barIcon;
        this.container = container;
    }

    public void createNavBar(LinearLayout layout) {

        TextView tv;

        // 设置权重
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1;

        //循环创建底部导航栏控件
        for(int i = 0; i < barText.length; i++) {

            tv = (TextView) View.inflate(container, R.layout.nav_bar_component, null);
            tv.setId(new Random().nextInt(9999));
            tv.setText(barText[i]);
            // 设置图标
            tv.setCompoundDrawablesWithIntrinsicBounds(0, barIcon[i], 0, 0);
            layout.addView(tv, params);
            tvs.add(tv);

            int position = i;
            tv.setOnClickListener(v -> {
                changeColor(position);
                clickListener.onNavBarClick(v.getId());
            });
        }
        // 设置选择状态
        changeColor(0);
    }



    public void changeColor(int position) {
        Resources rs = container.getResources();
        for(TextView t : tvs) {
            t.setSelected(false);
            t.setTextColor(rs.getColor(R.color.nav_bar_text_color));
        }
        tvs.get(position).setSelected(true);
        tvs.get(position).setTextColor(rs.getColor(R.color.nav_bar_text_select_color));
    }

    // 滑动效果通过接口回调进行配和

    /**
     * 1.创建接口和接口方法，用于回调，设置Activity之间的切换，和ViewPaer结合
     */
    public interface OnNavBarClickListener {

        public void onNavBarClick(int navBarId);
    }

    /**
     * 2.定义接口变量
     */
    OnNavBarClickListener clickListener ;

    /**
     * 3.在需要传值的地方引用接口对象调用接口方法
     */


    /**
     * 4.暴露一个公共的方法
     */
    public void setClickListener(OnNavBarClickListener clickListener) {
        this.clickListener = clickListener;
    }


}
