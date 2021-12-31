package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGhraphics(this));
    }
}

class  MyGhraphics extends View
{
    public MyGhraphics(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint=new Paint();
        paint.setColor(Color.BLUE);


        canvas.drawLine(200,200,400,200,paint);
        canvas.drawLine(200,200,200,400,paint);
        canvas.drawLine(400,200,400,400,paint);
        canvas.drawLine(200,400,400,400,paint);

        canvas.drawLine(300,300,500,300,paint);
        canvas.drawLine(300,300,300,500,paint);
        canvas.drawLine(500,300,500,500,paint);
        canvas.drawLine(300,500,500,500,paint);

        canvas.drawLine(200,200,300,300,paint);
        canvas.drawLine(400,200,500,300,paint);
        canvas.drawLine(200,400,300,500,paint);
        canvas.drawLine(400,400,500,500,paint);


        paint.setColor(Color.RED);

        canvas.drawCircle(200,1000,100,paint);

        paint.setColor(Color.GREEN);
        canvas.drawRect(200,600,400,700,paint);


        paint.setColor(Color.BLUE);
        for (int i=0; i<=50;i++)
        {
            Random random=new Random();
            random.nextInt(1000);
            canvas.drawCircle(random.nextInt(1000),random.nextInt(1500),3*random.nextInt(8),paint);
        }

        for (int i=0; i<=50;i++)
        {
            Random random=new Random();
            int a=random.nextInt(10);
            int b=random.nextInt(1500);

            canvas.drawLine(20*b,20*b,40*a,20*a,paint);
            canvas.drawLine(20*b,20*b,20*a,40*a,paint);
            canvas.drawLine(40*b,20*b,40*a,40*a,paint);
            canvas.drawLine(20*b,40*b,40*a,40*a,paint);


        }


    }
}























