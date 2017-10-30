package com.lixiaodaoaaa.activity;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2017/10/26
       Time     :  13:55
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gcssloop.graphics.R;

public class NormalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
