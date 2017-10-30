package com.lixiaodaoaaa.activity;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2017/10/26
       Time     :  13:55
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.gcssloop.graphics.R;

public class ProductActivity extends AppCompatActivity {

    private SimpleDraweeView draweeView;
    private DraweeController draweeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productinfo);
        initAllViews();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2200);
    }

    private void initAllViews() {
        draweeView = (SimpleDraweeView) findViewById(R.id.outgooding_iv);
    }

    private void initData() {
        Uri uri1 = Uri.parse("res://com.want.vendor/" + R.raw.vendor_payinfo_outgooding);
        draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri1)
                .setAutoPlayAnimations(true)
                .build();
        draweeView.setController(draweeController);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
