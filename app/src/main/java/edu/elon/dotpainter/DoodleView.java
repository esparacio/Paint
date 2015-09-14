//Author: Elena Sparacio & Patrick Lathan

package edu.elon.dotpainter;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DoodleView extends View {

    public final static int DEFAULT_WIDTH = 25;
    public final static int DEFAULT_RED = 255;
    public final static int DEFAULT_GREEN = 255;
    public final static int DEFAULT_BLUE = 255;
    public final static int DEFAULT_ALPHA = 255;

    private ArrayList<Line> theLines;
    private int lineWidth = DEFAULT_WIDTH;
    private int red = DEFAULT_RED;
    private int green = DEFAULT_GREEN;
    private int blue = DEFAULT_BLUE;
    private int alpha = DEFAULT_ALPHA;
    private boolean newTouch = true;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theLines = new ArrayList<Line>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){



        if(!newTouch) {
            float x1 = (theLines.get(theLines.size() - 1)).x0;
            float y1 = (theLines.get(theLines.size() - 1)).y0;
            theLines.add(new Line(event.getX(), event.getY(), x1, y1, lineWidth, red, green, blue, alpha));
            if (event.getAction() == android.view.MotionEvent.ACTION_UP){
                newTouch = true;
            }
        } else if(newTouch) {
            theLines.add(new Line(event.getX(), event.getY(), event.getX(), event.getY(), lineWidth, red, green, blue, alpha));
            newTouch = false;
        }

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas){

        for(Line line : theLines){
            line.draw(canvas);
        }
        invalidate();

    }

    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setLineColor(int red, int green, int blue, int alpha){
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public int[] getLineColor(){
        int[] colorArray = {red, green, blue, alpha};
        return colorArray;
    }

    public void clearLines(){
        theLines.clear();
    }

}

