package com.android.daniel.antoniomagalhaes_comp304lab3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Exercise3Activity extends AppCompatActivity {

    //
    ImageView reusableImageView;
    Animation an;
    //
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);
        paint = new Paint();
        // Handle Start Button
        final Button onButton = (Button) findViewById(R.id.btn_start_exercise3);
        onButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });

        // Handle Stop Button
        final Button offButton = (Button) findViewById(R.id.btn_stop_exercise3);
        offButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });

    }

    private void startAnimation()
    {
        // We will animate the imageview
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
        reusableImageView.setImageResource(R.drawable.moon);
        
        reusableImageView.setVisibility(View.VISIBLE);


        //creating a bitmap as content view for the image
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.themoon);
//        Canvas canvas = new Canvas(bitmap);
//        reusableImageView.setImageBitmap(bitmap);
        //
//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setTextSize(60);
//        paint.setAntiAlias(true);
//        paint.setTypeface(Typeface.DEFAULT_BOLD);
        //
        Path p = new Path();
        p.moveTo(20, 200);
        p.lineTo(600, 200);

//        canvas.drawTextOnPath("Should learn Android", p, 0, 0, paint);

        // Load the appropriate animation
        an =  AnimationUtils.loadAnimation(this, R.anim.translate_position);

        // Start the animation
        reusableImageView.startAnimation(an);

    }// end of startAnimation

    private void stopAnimation()
    {
        reusableImageView.clearAnimation();
    }

}
