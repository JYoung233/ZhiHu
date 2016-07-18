package com.yangyang.zhihu;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yy on 16/7/16.
 * 自定义滑动的动画效果:步骤:明确从属的组件;明确响应的操作
 */
public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //确定所提供的子视图是否有另一个特定的同级视图作为布局从属(从属于某个组件的活动)

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }
    //响应从属布局的变化

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        float translationY=Math.abs(dependency.getTop());
        child.setTranslationY(translationY);
        return true;
    }
    //响应从属控件的大小变化
    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }
}
