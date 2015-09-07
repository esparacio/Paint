package edu.elon.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Elena on 9/7/15.
 */
public class Line {

    private float x0, y0, x1, y1;
    private int red, blue, green, alpha;
    private int width;
    private Paint paint;



    public Line(float x0, float y0, float x1, float y1){

        this.x0 =x0;
        this.y0 = y0;
        this.x1 =x1;
        this.y1 = y1;

        //need to get these values from the slider//
        red = (int) (Math.random()* 256);
        blue = (int) (Math.random()*256);
        green = (int) (Math.random()*256);
        alpha = (int) (Math.random()*256);

        paint = new Paint();
        paint.setARGB(alpha,red,blue,green);
        paint.setStrokeCap(Paint.Cap.ROUND);

    }
    public void draw(Canvas canvas){


        canvas.drawLine(x0,y0,x1,y1,paint);
    }

}


