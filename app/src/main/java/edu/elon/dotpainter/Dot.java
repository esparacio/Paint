package edu.elon.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Elena on 9/2/15.
 */
public class Dot {

    private float x, y;
    private final int RADIUS=50;
    private Paint paint;
    private int red, blue, green, alpha;

    public Dot(float x, float y){

        this.x =x;
        this.y = y;

        red = (int) (Math.random()* 256);
        blue = (int) (Math.random()*256);
        green = (int) (Math.random()*256);
        alpha = (int) (Math.random()*256);

        paint = new Paint();
        paint.setARGB(alpha,red,blue,green);

    }

    public void draw(Canvas canvas){
        canvas.drawCircle(x,y,RADIUS,paint);
    }

}
