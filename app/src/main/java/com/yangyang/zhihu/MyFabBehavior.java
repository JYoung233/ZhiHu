package com.yangyang.zhihu;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

/**
 * Created by yy on 16/7/17.
 *
 */
public class MyFabBehavior extends CoordinatorLayout.Behavior<View> {
    private static final Interpolator INTERPOLATOR=new FastOutSlowInInterpolator();
    private float viewY;//控件距离coordinatorLayout底部距离
    private boolean isAnimate;//动画是否在进行

    public MyFabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //在嵌套滑动开始前调用

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        if(child.getVisibility()==View.VISIBLE&&viewY==0){
            viewY=coordinatorLayout.getHeight()-child.getY();
        }
        return (nestedScrollAxes& ViewCompat.SCROLL_AXIS_VERTICAL)!=0;//判断是否竖直滑动

    }
    //在嵌套滑动进行时,对象消费滚动距离前回调

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {

        if(dy>=0&&!isAnimate&&child.getVisibility()==View.VISIBLE){
            hide(child);
        }
        if(dy<0&&!isAnimate&&child.getVisibility()==View.GONE){
            show(child);
        }
    }

    private void show(final View child) {
        ViewPropertyAnimator animator=child.animate().translationY(0).setInterpolator(INTERPOLATOR).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                child.setVisibility(View.VISIBLE);
                isAnimate=true;
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                isAnimate=false;
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                hide(child);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    //隐藏时的动画
    private void hide(final View child) {
        ViewPropertyAnimator animator=child.animate().translationY(viewY).setInterpolator(INTERPOLATOR).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                isAnimate=true;
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                 child.setVisibility(View.GONE);
                isAnimate=false;
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                show(child);
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        //测试是否需要start
    }

}
