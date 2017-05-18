package com.lixiaodaoaaa.view.pieview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;

public class CanvasTest2View extends View {


    private Paint paint;
    private int mWidth;
    private int mHeight;

    public CanvasTest2View(Context context) {
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

    public CanvasTest2View(Context context, AttributeSet attrs) {
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
//        fillTypeTest(canvas);
        booleanTest(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY,
                HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING
                        | HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
        return super.onTouchEvent(event);
    }

    private void fillTypeTest(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);                   // 设置画布模式为填充kk
        canvas.translate(mWidth / 2, mHeight / 2);          // 移动画布(坐标系)

        Path path = new Path();                                     // 创建Path

        path.setFillType(Path.FillType.INVERSE_WINDING);                   // 设置Path填充模式为 奇偶规则
//        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);            // 反奇偶规则
        path.addRect(-400, -400, 400, 400, Path.Direction.CW);         // 给Path中添加一个矩形

        canvas.drawPath(path, paint);
    }

    private void booleanTest(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);                   // 设置画布模式为填充kk
        canvas.translate(mWidth / 2, mHeight / 2);

        Path path1 = new Path();
        Path path2 = new Path();
        Path path3 = new Path();
        Path path4 = new Path();

        path1.addCircle(0, 0, 200, Path.Direction.CW);
        path2.addRect(0, -200, 200, 200, Path.Direction.CW);
        path3.addCircle(0, -100, 100, Path.Direction.CW);
        path4.addCircle(0, 100, 100, Path.Direction.CCW);
//
        path1.op(path2, Path.Op.DIFFERENCE);
        path1.op(path3, Path.Op.UNION);
        path1.op(path4, Path.Op.DIFFERENCE);
        canvas.drawPath(path1, paint);


    }


}
