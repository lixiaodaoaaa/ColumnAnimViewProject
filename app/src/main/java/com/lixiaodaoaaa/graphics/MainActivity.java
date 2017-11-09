/*
 * Copyright 2016 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2016-10-02 00:22:33
 *
 */

package com.lixiaodaoaaa.graphics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gcssloop.graphics.R;
import com.lixiaodaoaaa.view.pieview.PColumn;
import com.lixiaodaoaaa.view.pieview.RoadTableView;

public class MainActivity extends AppCompatActivity {

    private PColumn column_one;
    private PColumn column_two;
    private PColumn column_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(new RoadTableView(this));
//        initAllViews();
    }

    private void initAllViews() {
        column_one = (PColumn) findViewById(R.id.column_one);
        column_two = (PColumn) findViewById(R.id.column_two);
        column_three = (PColumn) findViewById(R.id.column_three);

        column_one.setData(0, 100);
        column_two.setData(30, 400);
        column_three.setData(450, 900);

    }

}
