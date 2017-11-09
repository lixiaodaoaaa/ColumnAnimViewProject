package com.lixiaodaoaaa.view.pieview;
/*
    ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ 
       Author   :  lixiaodaoaaa
       Date     :  2017/11/9
       Time     :  09:29
    ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛
 */

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class RoadTableView extends View {


    private Paint paint;
    private int mWidth;
    private int mHeight;
    private int marginLeft = 0;
    private int marginRight = 0;
    private int marginTop = 0;

    private int tableHeight = 80;
    private int tableWidth = 70;

    private int widthCount = 6;
    private int heightCount = 8;


    public RoadTableView(Context context) {
        super(context);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
    }

    public RoadTableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public RoadTableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        initTable();
    }

    private void initTable() {


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int totalTableWidth = mWidth - marginLeft - marginRight;
        int firstTableHeight = marginTop;
        int firstTableLeftPoint = marginLeft;
        int tableCount = totalTableWidth / tableWidth;

        for (int i = 0; i < heightCount; i++) {
            for (int k = 0; k < widthCount; k++) {
                Rect tempRect = new Rect(firstTableLeftPoint + i * tableWidth, firstTableHeight + k * tableHeight,
                        firstTableLeftPoint + (i + 1) * tableWidth, firstTableHeight + (k + 1) * tableHeight);
                revertPaint();
                canvas.drawRect(tempRect, paint);
                paint.setTextSize(24);
                String text = (k + 1) + "" + (i + 1);
                paint.setColor(Color.RED);

                float textWidth = paint.measureText(text, 0, text.length());
                float textLeft = (firstTableLeftPoint + (i + 1) * tableWidth - firstTableLeftPoint + i * tableWidth) / 2  - textWidth/2;
                float textTop = (firstTableHeight + (k + 1) * tableHeight - firstTableHeight + k * tableHeight) / 2+paint.getTextSize()/2;
                canvas.drawText(text, textLeft, textTop, paint);
                canvas.save();
            }

        }


    }

    private void revertPaint() {
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
    }
}
