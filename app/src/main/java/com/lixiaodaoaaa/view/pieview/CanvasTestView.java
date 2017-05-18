package com.lixiaodaoaaa.view.pieview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CanvasTestView extends View {


    private Paint paint;
    private int mWidth;
    private int mHeight;

    public CanvasTestView(Context context) {
        this(context, null);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(12);
        paint.setStyle(Paint.Style.STROKE);
    }

    public CanvasTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        translateTest(canvas);
//        scaleTest(canvas);
//        scaleTest03(canvas);
//        rotateTest01(canvas);
//        goodTest01(canvas);
//        screwTest(canvas);
//        testPathClose(canvas);
//        testPathDirection(canvas);
//        testPathForCan(canvas);
//        testArctoTest(canvas);
        rLineToTest(canvas);
    }


    private void translateTest(Canvas canvas) {
        for (int i = 0; i < 10; i++) {
            paint.setColor(Color.BLUE);
            canvas.translate(200, 200);
            canvas.drawCircle(0, 0, 100, paint);
        }
    }

    private void scaleTest(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        paint.setColor(Color.RED);
        Rect rect = new Rect(0, -400, 400, 0);
        canvas.drawRect(rect, paint);
        canvas.save();
        canvas.scale(0.5f, 0.5f);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
        canvas.restore();
    }

    private void scaleTest01(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        paint.setColor(Color.RED);
        Rect rect = new Rect(0, -400, 400, 0);
        canvas.drawRect(rect, paint);
        canvas.save();
        canvas.scale(0.5f, 0.5f, 200, -200);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
        canvas.restore();
    }


    private void scaleTest02(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        paint.setColor(Color.RED);
        Rect rect = new Rect(0, -400, 400, 0);
        canvas.drawRect(rect, paint);
        canvas.save();
        canvas.scale(0.5f, 0.5f, 200, 0);
        paint.setColor(Color.BLUE);
        canvas.drawRect(rect, paint);
        canvas.restore();
    }


    private void scaleTest03(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        paint.setColor(Color.BLUE);
        Rect rect = new Rect(-400, -400, 400, 400);

        for (int i = 0; i < 10; i++) {
            canvas.drawRect(rect, paint);
            canvas.scale(0.82f, 0.82f);
            canvas.drawRect(rect, paint);
        }
    }


    private void rotateTest01(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);
        paint.setColor(Color.RED);
        Rect rect = new Rect(0, -400, 400, 0);
        canvas.drawRect(rect, paint);
        paint.setColor(Color.BLUE);
        canvas.rotate(270, 0, 0);
        canvas.drawRect(rect, paint);
    }


    private void goodTest01(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0, 0, 400, paint);          // 绘制两个圆形
        paint.setColor(Color.GREEN);
        canvas.drawCircle(0, 0, 320, paint);
        for (int i = 0; i <= 360; i += 10) {               // 绘制圆形之间的连接线
            canvas.drawLine(0, 320, 0, 400, paint);
            canvas.rotate(10);
        }
    }


    private void screwTest(Canvas canvas) {
        // 将坐标系原点移动到画布正中心
        canvas.translate(mWidth / 2, mHeight / 2);

        RectF rect = new RectF(-200, 0, 0, 200);   // 矩形区域

        paint.setColor(Color.BLACK);           // 绘制黑色矩形
        canvas.drawRect(rect, paint);

        canvas.skew(1, 0);                       // 水平错切 <- 45度

        paint.setColor(Color.BLUE);            // 绘制蓝色矩形
        canvas.drawRect(rect, paint);
    }

    private void pathTest(Canvas canvas) {
        Path path = new Path();
        canvas.translate(mWidth / 2, mHeight / 2);

        path.lineTo(200, 200);
        path.lineTo(0, 200);
        path.lineTo(0, 0);
        canvas.drawPath(path, paint);
    }


    private void testPathClose(Canvas canvas) {
        Path path = new Path();
        canvas.translate(mWidth / 2, mHeight / 2);

        path.lineTo(200, 200);
        path.lineTo(0, 200);
        path.close();
        canvas.drawPath(path, paint);
    }


    private void testPathDirection(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心

        Path path = new Path();

        path.addRect(-100, -100, 100, 100, Path.Direction.CCW);

        path.setLastPoint(-500, 500);// <-- 重置最后一个点的位置
        path.close();
        canvas.drawPath(path, paint);
        path.close();
    }

    private void testPathForCan(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴

        Path path = new Path();
        Path src = new Path();

        path.addRect(-200, -200, 200, 200, Path.Direction.CW);
        src.addCircle(0, 0, 100, Path.Direction.CW);

        path.addPath(src, 0, 200);
        paint.setColor(Color.BLACK);           // 绘制合并后的路径
        canvas.drawPath(path, paint);
    }

    private void testArctoTest(Canvas canvas) {
        canvas.translate(mWidth / 2, mHeight / 2);  // 移动坐标系到屏幕中心
//        canvas.scale(1, -1);                         // <-- 注意 翻转y坐标轴

        Path path = new Path();
        path.lineTo(100, 100);

        RectF oval = new RectF(0, 0, 300, 300);

        path.addArc(oval, 0, 270);
// path.arcTo(oval,0,270,false);             // <-- 和上面一句作用等价

        canvas.drawPath(path, paint);
    }


    private void isArtTest(Canvas canvas) {
        Path path = new Path();
        path.lineTo(0, 400);
        path.lineTo(400, 400);
        path.lineTo(400, 0);
        path.lineTo(0, 0);


        RectF rect = new RectF();
        boolean b = path.isRect(rect);
        System.out.println("   result is " + b);
    }

    private void rLineToTest(Canvas canvas) {
        Path path = new Path();
        path.moveTo(100, 100);
        path.rLineTo(0, 200);
        canvas.drawPath(path, paint);
    }

}
