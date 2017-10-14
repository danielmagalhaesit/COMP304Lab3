package com.android.daniel.antoniomagalhaes_comp304lab3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

public class Exercise1Activity extends AppCompatActivity {

    ImageButton keyDown;
    ImageButton keyRight;
    ImageButton keyUp;
    ImageButton keyLeft;
    Spinner spn_color;
    Spinner spn_thickness;
    Button btnClear;
    ImageView drawbleImageView;

    //
    int startx = 10;
    int starty = 10;
    int endx=10;
    int endy=10;
    //
    Paint mPaint;
    Bitmap mBitmap;
    Canvas mCanvas;
    //

    int mColor;
    int mThickness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        //
        mPaint = new Paint();

        //creating a mBitmap as content view for the mCanvas
        mBitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        //

        keyDown = (ImageButton) findViewById(R.id.down_key);
        keyRight = (ImageButton) findViewById(R.id.right_key);
        keyLeft = (ImageButton) findViewById(R.id.left_key);
        keyUp = (ImageButton) findViewById(R.id.up_key);
        spn_color = (Spinner) findViewById(R.id.spn_color);
        spn_thickness = (Spinner) findViewById(R.id.spn_thickness);
        btnClear = (Button) findViewById(R.id.btnClear);
        drawbleImageView = (ImageView) findViewById(R.id.ImageViewForDrawing);

        setLineColor(spn_color.getSelectedItemPosition());
        mThickness = Integer.parseInt(spn_thickness.getSelectedItem().toString());

        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(mThickness);

        mBitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        drawbleImageView.setImageBitmap(mBitmap);

//        keyDown.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                endy=endy+10;
//                drawLine(mCanvas);
//            }
//        });

        keyDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    endy=endy+10;
                    drawLine(mCanvas);
                }

                if(motionEvent.getAction() == MotionEvent.ACTION_UP){

                }

                return true;
            }
        });

        keyUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    endy=endy-10;
                    drawLine(mCanvas);
                }

                if(motionEvent.getAction() == MotionEvent.ACTION_UP){


                }
                return true;
            }
        });

        keyRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    endx=endx+10;
                    drawLine(mCanvas);
                }
                return true;
            }
        });

        keyLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    endx=endx-10;
                    drawLine(mCanvas);
                }
                return true;
            }
        });

        spn_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                setLineColor(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spn_thickness.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mThickness = Integer.parseInt(adapterView.getSelectedItem().toString());
                mPaint.setStrokeWidth(mThickness);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCanvas.drawColor(Color.WHITE);
            }
        });
    }

    public void drawLine(Canvas canvas)
    {
        //mCanvas.drawLine(100,100,1000,1000,mPaint);
        canvas.drawLine(startx, starty, endx, endy, mPaint);
        startx=endx;
        starty=endy;
        drawbleImageView.invalidate();

    }

    public void setLineColor(int color){
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
        mPaint.setColor(mColor);
    }



}
