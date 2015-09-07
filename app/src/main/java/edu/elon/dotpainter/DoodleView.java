package edu.elon.dotpainter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Elena on 9/2/15.
 */
public class DoodleView extends View {

    private ArrayList<Dot> theDots;
    private ArrayList<Line> theLines;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        theDots = new ArrayList<Dot>();
        theLines = new ArrayList<Line>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){

        theDots.add(new Dot(event.getX(), event.getY()));

        //this is wrong, needs to get for touch down and move event//
        theLines.add(new Line(event.getX(), event.getY(), event.getX(), event.getY()));


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas){

        for (Dot dot: theDots){
            dot.draw(canvas);
        }

        invalidate();

        for(Line line: theLines){
            line.draw(canvas);
        }
        invalidate();

    }

    public void onClickClear(){

        Canvas canvas = new Canvas();


    }
}

