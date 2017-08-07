package com.lixiaodaoaaa.view.pieview.flower;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.gcssloop.graphics.R;

import java.util.Random;

/**
 * Created by lixiaodaoaaa on 2017/8/7.
 */

public class FlowerLayout extends RelativeLayout {
    private Random random;
    private int[] imageResourceIds;

    public FlowerLayout(Context context) {
        super(context);
        initData();
    }

    private void initData() {
        random = new Random();
        imageResourceIds = new int[]{R.drawable.logo_sinaweibo, R.drawable.logo_sms, R.drawable.logo_tencentweibo};
    }


    public FlowerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public FlowerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }


    //add flower******************************************************************
    public void addFlower() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(imageResourceIds[random.nextInt(imageResourceIds.length - 1)]);
        RelativeLayout.LayoutParams relativePara = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        relativePara.addRule(ALIGN_PARENT_BOTTOM);
        relativePara.addRule(CENTER_HORIZONTAL);
        imageView.setLayoutParams(relativePara);
        addView(imageView);
        setAnimation(imageView);
    }


    public void setAnimation(ImageView imageView) {

        AnimatorSet animatorSetIn = new AnimatorSet();

        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(imageView, "alpha", 0.3f, 1.0f);
        ObjectAnimator scaleAnimatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 0.3f, 1.0f);
        ObjectAnimator scaleAnimatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 0.3f, 1.0f);

        animatorSetIn.playTogether(alphaAnimator, scaleAnimatorX, scaleAnimatorY);
        animatorSetIn.setDuration(3000);
        animatorSetIn.start();
    }
}
