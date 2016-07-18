package com.yangyang.zhihu.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yangyang.zhihu.Page2_Fragemnts.CollectFragment;
import com.yangyang.zhihu.Page2_Fragemnts.HotFragment;
import com.yangyang.zhihu.Page2_Fragemnts.RecommendFragment;
import com.yangyang.zhihu.Page2_Fragemnts.RoundFragment;


/**
 * Created by yy on 16/7/18.
 * 知乎第二个主界面的滑动适配器
 */
public class MyViwePagerAdapter extends FragmentPagerAdapter {
    private int num;
    private String[] title=new String[]{"推荐","圆桌","热门","收藏"};
    public MyViwePagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new RecommendFragment();
            case 1:
                return new RoundFragment();
            case 2:
                return new HotFragment();
            case 3:
                return new CollectFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
