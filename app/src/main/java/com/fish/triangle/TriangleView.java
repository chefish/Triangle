package com.fish.triangle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

/**
 * triagnle，support assign direction and color in xml
 * Created by fish on 2017/11/23.
 * yuxm_zju@aliyun.com
 */
public class TriangleView extends View {

    private int color;
    private Paint paint = new Paint();
    private Path path = new Path();

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
        paint.setColor(color);
        invalidate();
    }

    public TriangleView(Context context) {
        this(context, null);
    }

    public TriangleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TriangleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private int direction;

    private void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TriangleView, 0,
                defStyle);
        direction = a.getInteger(R.styleable.TriangleView_direction, 0);
        color = a.getColor(R.styleable.TriangleView_android_color, Color.BLACK);
        a.recycle();
        paint.setColor(color);
        paint.setAntiAlias(true);

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        initPath();
    }

    private void initPath() {
        int w = getWidth() / 2;
        int h = getHeight() / 2;
        if (direction == 0) {
            getLeftTriangle(w, h);
        } else if (direction == 1) {
            getTopTriangle(w, h);
        } else if (direction == 2) {
            getRightTriangle(w, h);
        } else if (direction == 3) {
            getDownTriangle(w, h);
        } else {
            throw new IllegalStateException("direction is illegal " + direction);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth() / 2;
        int h = getHeight() / 2;

        //Choose what type of triangle you want here


        canvas.drawPath(path, paint);
    }

    @NonNull
    /**
     * Return Path for down facing triangle
     */
    private Path getDownTriangle(int w, int h) {
        path.reset();
        path.moveTo(0, 0);
        path.lineTo(w, 2 * h);
        path.lineTo(2 * w, 0);
        path.lineTo(0, 0);
        path.close();
        return path;
    }

    @NonNull
    /**
     * Return Path for Up facing triangle
     */
    private Path getTopTriangle(int w, int h) {
        path.reset();
        path.moveTo(0, 2 * h);
        path.lineTo(w, 0);
        path.lineTo(2 * w, 2 * h);
        path.lineTo(0, 2 * h);
        path.close();
        return path;
    }

    @NonNull
    /**
     * Return Path for Right pointing triangle
     */
    private Path getRightTriangle(int w, int h) {
        path.reset();
        path.moveTo(0, 0);
        path.lineTo(2 * w, h);
        path.lineTo(0, 2 * h);
        path.lineTo(0, 0);
        path.close();
        return path;
    }

    @NonNull
    /**
     * Return Path for Left pointing triangle
     */
    private Path getLeftTriangle(int w, int h) {
        path.reset();
        path.moveTo(2 * w, 0);
        path.lineTo(0, h);
        path.lineTo(2 * w, 2 * h);
        path.lineTo(2 * w, 0);
        path.close();
        return path;
    }
}