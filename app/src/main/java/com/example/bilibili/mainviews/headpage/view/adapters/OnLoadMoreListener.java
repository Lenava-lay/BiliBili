package com.example.bilibili.mainviews.headpage.view.adapters;

import android.widget.LinearLayout;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import static androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_DRAGGING;
import static androidx.viewpager.widget.ViewPager.SCROLL_STATE_SETTLING;

/**
 * @作者JTL.
 * @日期2017/12/1.
 * @说明：加载更多Listener
 */

public abstract class OnLoadMoreListener extends RecyclerView.OnScrollListener {
    private int countItem;
    private int lastItem;
    private boolean isScrolled = false;//是否可以滑动
    private RecyclerView.LayoutManager layoutManager;

    /**
     * 加载回调方法
     * @param countItem 总数量
     * @param lastItem  最后显示的position
     */
    protected abstract void onLoading(int countItem, int lastItem);

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
     /* 测试这三个参数的作用
        if (newState==SCROLL_STATE_IDLE){
            Log.d("test","SCROLL_STATE_IDLE,空闲");
        }
        else if (newState==SCROLL_STATE_DRAGGING){
            Log.d("test","SCROLL_STATE_DRAGGING,拖拽");
        }
        else if (newState==SCROLL_STATE_SETTLING){
            Log.d("test","SCROLL_STATE_SETTLING,固定");
        }
        else{
            Log.d("test","其它");
        }*/
        //拖拽或者惯性滑动时isScrolled设置为true
        if (newState == SCROLL_STATE_DRAGGING || newState == SCROLL_STATE_SETTLING) {
            isScrolled = true;
        } else {
            isScrolled = false;
        }

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        layoutManager = recyclerView.getLayoutManager();
        countItem = layoutManager.getItemCount();
        Class clazz = layoutManager.getClass();
        if(clazz == GridLayoutManager.class) {
            lastItem = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        } else if (clazz == LinearLayoutManager.class) {
            lastItem = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        } else if (clazz == StaggeredGridLayoutManager.class) {
            // 有待修改
//            lastItem = ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
            lastItem = ((StaggeredGridLayoutManager) layoutManager).findLastCompletelyVisibleItemPositions(null)[0];
        }

        if (isScrolled && countItem != lastItem && lastItem == countItem - 1) {
            onLoading(countItem, lastItem);
        }
    }
}

