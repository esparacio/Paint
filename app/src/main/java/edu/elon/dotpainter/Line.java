//Author: Elena Sparacio & Patrick Lathan

package edu.elon.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Line {

    public float x0, y0, x1, y1;
    private int red, blue, green, alpha;
    private int lineWidth;
    private Paint paint;



    public Line(float x0, float y0, float x1, float y1, int lineWidth, int red, int blue, int green, int alpha){

        this.x0 =x0;
        this.y0 = y0;
        this.x1 =x1;
        this.y1 = y1;

        this.lineWidth = lineWidth;

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;

        paint = new Paint();
        paint.setARGB(alpha,red, blue, green);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(lineWidth);

    }
    public void draw(Canvas canvas){

        canvas.drawLine(x0,y0,x1,y1,paint);
    }

}


