package com.android.daniel.antoniomagalhaes_comp304lab3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by danie on 07/10/2017.
 */

class Draw extends View {
    int startx = 10;
    int starty = 10;
    int endx=10;
    int endy=10;

    private Paint mPaint;
    private Bitmap mBitmap;
    private int mColor;
    private int mThickness;
    private Canvas mCanvas;
    private Path mPath;

    public Draw(Context context) {
        super(context);
        mPath = new Path();
        mPaint   = new Paint();
        mColor = Color.RED;
        mThickness = 10;
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(mThickness);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    public void drawLine()
    {
        //canvas.drawLine(100,100,1000,1000,paint);
        mCanvas.drawLine(startx, starty, endx, endy, mPaint);
        startx=endx;
        starty=endy;
    }

    public void setColor(int color){
        switch (color){
            case 0:{
                mColor = Color.RED;
                break;
            }
            case 1:{
                mColor = Color.BLUE;
                break;
            }
            case 2:{
                mColor = Color.GREEN;
                break;
            }
        }
    }

    public void setThickness(int thickness){
        switch (thickness){
            case 0:{
                 mThickness = 10;
                break;
            }
            case 1:{
                mThickness = 20;
                break;
            }
            case 2:{
                mThickness = 30;
                break;
            }
        }
    }

    public void drawDown(){
        endy=endy+5;
        drawLine();
    }
    public void drawRight(){
        endx=endx+5;
        drawLine( );
    }
    public void drawUp(){
        endy=endy-5;
        drawLine();
    }
    public void drawLeft(){
        endx=endx-5;
        drawLine();
    }
}
