package com.jeench.shoplist.ui;

/**
 * Created by Radik on 01.12.2017.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jeench.shoplist.R;

/**
 * Created by Радик on 24.09.2017 as part of the Gymm project.
 */

public class SatelliteProgressBar extends View {
    private float orbitStrokeWidth;
    private float angle;
    private float startAngle;
    private @ColorInt int mainColor;
    private @ColorInt int secondaryColor;

    private float orbitCenter;

    private PointF center = new PointF();

    private Paint orbitPaint = new Paint();
    private Paint backgroundRingPaint;
    private final RectF orbitRect = new RectF();

    public SatelliteProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.SatelliteProgressBar, 0, 0);

        try {
            orbitStrokeWidth = a.getDimension(R.styleable.SatelliteProgressBar_orbitStrokeWidth, 10f);
            angle = a.getFloat(R.styleable.SatelliteProgressBar_angle, 120);
            startAngle = -a.getFloat(R.styleable.SatelliteProgressBar_startAngle, 90);
            mainColor = a.getColor(R.styleable.SatelliteProgressBar_mainColor, Color.BLACK);
            secondaryColor = a.getColor(R.styleable.SatelliteProgressBar_secondaryColor, Color.WHITE);
        } finally {
            a.recycle();
        }

        orbitCenter = orbitStrokeWidth / 2.0f;

        orbitPaint = new Paint();
        orbitPaint.setStyle(Paint.Style.STROKE);
        orbitPaint.setStrokeWidth(orbitStrokeWidth);
        orbitPaint.setColor(mainColor);
        orbitPaint.setAntiAlias(true);

        backgroundRingPaint = new Paint(orbitPaint);
        backgroundRingPaint.setColor(secondaryColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(orbitRect, startAngle, 360 + angle, false, backgroundRingPaint);
        canvas.drawArc(orbitRect, startAngle, angle, false, orbitPaint);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        orbitRect.set(orbitCenter, orbitCenter, width - orbitCenter, height - orbitCenter);
        center.set(width / 2f, height / 2f);
    }

    public float getOrbitStrokeWidth() {
        return orbitStrokeWidth;
    }

    public void setOrbitStrokeWidth(float orbitStrokeWidth) {
        this.orbitStrokeWidth = orbitStrokeWidth;
        invalidate();
        requestLayout();
    }

    public float getAngle() {
        return -angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
        invalidate();
    }

    public float getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = -startAngle;
        invalidate();
    }

    public int getMainColor() {
        return mainColor;
    }

    public void setMainColor(int mainColor) {
        this.mainColor = mainColor;
        invalidate();
    }

    public int getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(int secondaryColor) {
        this.secondaryColor = secondaryColor;
        invalidate();
    }
}
