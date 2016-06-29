package com.yangyang.zhihu.Test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yy on 16/6/29.
 * 实现viewpager适配器
 */
public class ViewPageAdapter extends FragmentPagerAdapter{
    List<String> mtitle;

    public ViewPageAdapter(FragmentManager fm,List<String> title) {
        super(fm);
        mtitle=title;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment4();
            case 4:
                return new Fragment5();
            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return mtitle.size();
    }

//    public CharSequence getPageTitle(int position){
//        return mtitle.get(position);
//    }
}
