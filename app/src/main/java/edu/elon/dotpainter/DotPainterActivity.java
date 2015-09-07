package edu.elon.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DotPainterActivity extends Activity {

    public final static int WIDTH_DIALOG = 1;
    public final static int COLOR_DIALOG =1;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dot_painter);
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
            startActivityForResult(intent,WIDTH_DIALOG);
            return true;
        }
        if(id == R.id.actions_setcolor){
            Intent intent = new Intent(this,SetColorDialogActivity.class);
            startActivityForResult(intent,COLOR_DIALOG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
