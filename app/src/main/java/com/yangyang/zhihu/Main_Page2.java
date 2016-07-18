package com.yangyang.zhihu;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.yangyang.zhihu.Adapter.MyViwePagerAdapter;

/**
 * Created by yy on 16/7/18.
 * 知乎第二个界面
 */
public class Main_Page2 extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyViwePagerAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page2);
        tabLayout= (TabLayout) findViewById(R.id.tablist);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("推荐"));
        tabLayout.addTab(tabLayout.newTab().setText("圆桌"));
        tabLayout.addTab(tabLayout.newTab().setText("热门"));
        tabLayout.addTab(tabLayout.newTab().setText("收藏"));
        pagerAdapter=new MyViwePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);


    }
}
