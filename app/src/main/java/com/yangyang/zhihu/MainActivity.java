package com.yangyang.zhihu;

import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerview;
    private List<News> data;
    private RecycleriewAdapter adapter;
    private LinearLayout l1,l2,l3,l4,l5;
    private Button editText;
    private FloatingActionButton fab;
    private boolean fabopened=false;
    private TextView cloud;//为fab设置蒙板效果
    private FloatingActionButton write1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("测试");
        recyclerview= (RecyclerView) findViewById(R.id.list);
        editText= (Button) findViewById(R.id.search_bar);
        cloud= (TextView) findViewById(R.id.cloud);
        write1= (FloatingActionButton) findViewById(R.id.write);
        l1= (LinearLayout) findViewById(R.id.page1);
        l2= (LinearLayout) findViewById(R.id.page2);
        l3= (LinearLayout) findViewById(R.id.page3);
        l4= (LinearLayout) findViewById(R.id.page4);
        l5= (LinearLayout) findViewById(R.id.page5);
        data=new ArrayList<>();
        News news1=new News("你有什么道理后悔没有早知道","莫尔顿家族的箴言是昂首屹立，是少数拥有祖传瓦雷利亚刚的家族之一。传说北境之王罗德利克·史塔克在一场摔跤比赛中赢得了熊岛(大概是从当时统治那里的铁群岛之王处夺过来的)然后把其交给了莫尔蒙家族。从此莫尔顿家族效忠于史塔克。熊岛的女人们非常厉害");
        News news2=new News("你最意想不到的一笔收入是怎么来的","接下来是吊龙伴，它的位置相当于牛腰里脊的侧唇，而匙仁与匙柄则相当于肩胛里脊和肩胛肉条，牛骨盆的夹缝被叫做“龙虾须”，牛腹部的夹层肉则是“肥胼”，即便是庖丁解牛也很难这样将一只牛像绣花般细细分解。张新民特别推荐了胸口朥，这是牛的一小块前胸脂肪，状若黄油，特别之处是久煮不老，吃到口中酥脆无渣，满口脂香。另外一盘则是正五花脚趾，部位具体是牛腿的腱肌，一头牛只有两小块。通过如此刁钻的吃法可以理解汕头人的美食哲学：任有弱水三千，只选择最有口感的那一瓢。");
        News news3=new News("你最意想不到的一笔收入是怎么来的","接下来是吊龙伴，它的位置相当于牛腰里脊的侧唇，而匙仁与匙柄则相当于肩胛里脊和肩胛肉条，牛骨盆的夹缝被叫做“龙虾须”，牛腹部的夹层肉则是“肥胼”，即便是庖丁解牛也很难这样将一只牛像绣花般细细分解。张新民特别推荐了胸口朥，这是牛的一小块前胸脂肪，状若黄油，特别之处是久煮不老，吃到口中酥脆无渣，满口脂香。另外一盘则是正五花脚趾，部位具体是牛腿的腱肌，一头牛只有两小块。通过如此刁钻的吃法可以理解汕头人的美食哲学：任有弱水三千，只选择最有口感的那一瓢。");
        data.add(news1);
        data.add(news2);
        data.add(news3);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter=new RecycleriewAdapter(this,data);
        recyclerview.setAdapter(adapter);
        final Intent intent=new Intent(MainActivity.this,SearchViewTest.class);

        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(!fabopened){
                  OpenMenu(view);
              }
                else{
                  CloseMenu(view);
              }
            }
        });

         l2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                ChangeView(2);
                 Intent intent=new Intent(MainActivity.this,Main_Page2.class);
                 startActivity(intent);
             }
         });

   }

    private void ChangeView(int i) {
    }

    private void CloseMenu(View view) {
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"rotation",-135,20,0);
        animator.setDuration(500);
        animator.start();
        AlphaAnimation alphaAnimator=new AlphaAnimation(0.7f,0);
        alphaAnimator.setDuration(500);
        cloud.startAnimation(alphaAnimator);
        cloud.setVisibility(View.GONE);
        write1.setVisibility(View.GONE);

        fabopened=false;

    }

    private void OpenMenu(View view) {
        ObjectAnimator animator=ObjectAnimator.ofFloat(view,"rotation",0,-155,-135);//了解参数,不是面向对象的方式
        animator.setDuration(500);
        animator.start();
        cloud.setVisibility(View.VISIBLE);
        write1.setVisibility(View.VISIBLE);

        AlphaAnimation alphaAnimator=new AlphaAnimation(0,0.7f);
        alphaAnimator.setDuration(500);
        alphaAnimator.setFillAfter(true);
        cloud.startAnimation(alphaAnimator);

        fabopened=true;

    }
}
