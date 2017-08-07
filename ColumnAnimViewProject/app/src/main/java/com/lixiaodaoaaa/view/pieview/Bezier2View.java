package com.lixiaodaoaaa.view.pieview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author crazychen
 * @version 1.0
 * @date 2015/12/2
 */
public class Bezier2View extends View {
    private Paint mPaint;
    private int centerX, centerY;

    private PointF start, end, control1, control2;
    private boolean mode = true;

    public Bezier2View(Context context) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(60);

        start = new PointF(0, 0);
        end = new PointF(0, 0);
        control1 = new PointF(0, 0);
        control2 = new PointF(0, 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        // 初始化数据点和控制点的位置
        start.x = centerX - 300;
        start.y = centerY;
        end.x = centerX + 300;
        end.y = centerY;
        control1.x = centerX - 200;
        control1.y = centerY - 200;

        control2.x = centerX + 200;
        control2.y = centerY - 200;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 根据触摸位置更新控制点，并提示重绘
        control1.x = event.getX();
        control1.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 绘制数据点和控制点
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(20);
        mPaint.setAntiAlias(true);
        canvas.drawPoint(start.x, start.y, mPaint);
        canvas.drawPoint(end.x, end.y, mPaint);
        canvas.drawPoint(control1.x, control1.y, mPaint);

        // 绘制辅助线
        mPaint.setStrokeWidth(4);
        canvas.drawLine(start.x, start.y, control1.x, control1.y, mPaint);
        canvas.drawLine(control1.x, control1.y, control2.x, control2.y, mPaint);
        canvas.drawLine(control2.x, control2.y, end.x, end.y, mPaint);

        // 绘制贝塞尔曲线
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);

        Path path = new Path();

        path.moveTo(start.x, start.y);


        /**
         * (float x1, float y1, float x2, float y2,
         float x3, float y3)
         */
        path.cubicTo(control1.x, control1.y, control2.x, control2.y, end.x, end.y);

        canvas.drawPath(path, mPaint);
    }
}