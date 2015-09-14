//Author: Elena Sparacio & Patrick Lathan

package edu.elon.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DotPainterActivity extends Activity {

    public final static int WIDTH_DIALOG = 1;
    public final static int COLOR_DIALOG =2;

    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_painter);

        doodleView = (DoodleView) findViewById(R.id.doodleview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dot_painter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actions_setwidth) {
            Intent intent = new Intent(this,SetWidthDialogActivity.class);
            intent.putExtra("width", doodleView.getLineWidth());
            startActivityForResult(intent,WIDTH_DIALOG);
            return true;
        }
        if(id == R.id.actions_setcolor){
            Intent intent = new Intent(this,SetColorDialogActivity.class);
            int[] colorArray = doodleView.getLineColor();
            intent.putExtra("red", colorArray[0]);
            intent.putExtra("green", colorArray[1]);
            intent.putExtra("blue", colorArray[2]);
            intent.putExtra("alpha", colorArray[3]);
            startActivityForResult(intent,COLOR_DIALOG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickClear(View view){

        doodleView.clearLines();

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == WIDTH_DIALOG) {
            if (resultCode == RESULT_OK) {
                // get the new pen width and tell the DoodleView
                int lineWidth = data.getIntExtra("width", doodleView.getLineWidth());
                doodleView.setLineWidth(lineWidth);
            }
        }
        if (requestCode == COLOR_DIALOG) {
            if (resultCode == RESULT_OK) {
                int[] colorArray = doodleView.getLineColor();
                int red = data.getIntExtra("red", colorArray[0]);
                int green = data.getIntExtra("green", colorArray[1]);
                int blue = data.getIntExtra("blue", colorArray[2]);
                int alpha = data.getIntExtra("alpha", colorArray[3]);
                doodleView.setLineColor(red, green, blue, alpha);
            }
        }
    }


}
