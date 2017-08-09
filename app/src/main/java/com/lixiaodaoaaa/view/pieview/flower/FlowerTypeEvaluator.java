package com.lixiaodaoaaa.view.pieview.flower;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/**
 * Created by lixiaodaoaaa on 2017/8/8.
 */

public class FlowerTypeEvaluator implements TypeEvaluator<PointF> {


    private PointF pStart, pControl1, pControl2, pEnd;

    public FlowerTypeEvaluator(PointF pStart, PointF pControl1, PointF pControl2, PointF pEnd) {
        this.pStart = pStart;
        this.pControl1 = pControl1;
        this.pControl2 = pControl2;
        this.pEnd = pEnd;
    }

    @Override
    public PointF evaluate(float t, PointF startValue, PointF endValue) {
        PointF pointF = new PointF();

        pointF.x = pStart.x * (1 - t) * (1 - t) * (1 - t) //
                + 3 * pControl1.x * t * (1 - t) * (1 - t)//
                + 3 * pControl2.x * t * t * (1 - t)//
                + pEnd.x * t * t * t;//

        pointF.y = pStart.y * (1 - t) * (1 - t) * (1 - t) //
                + 3 * pControl1.y * t * (1 - t) * (1 - t)//
                + 3 * pControl2.y * t * t * (1 - t)//
                + pEnd.y * t * t * t;//


        return pointF;
    }


}
