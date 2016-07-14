package com.yangyang.zhihu.Test;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yangyang.zhihu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy on 16/6/29.
 * 测试底部工具栏的实现
 */
public class ViewPagerTest extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<String> title=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_toolbar);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        tabLayout= (TabLayout) findViewById(R.id.tab1);
        title.add("1");
        title.add("2");
        title.add("3");
        title.add("4");
        title.add("5");
        ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager(),title);
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        Resources res=getResources();
        for(int i=0;i<tabLayout.getTabCount();i++){
            tabLayout.getTabAt(i).setIcon(res.getDrawable(android.R.drawable.ic_dialog_dialer));

        }//没有解决底部工具栏的问题,增加
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




    }


}
