//Author: Elena Sparacio

package edu.elon.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

public class SetWidthDialogActivity extends Activity {

    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_width_dialog);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
    }

    public void onCancelClick(View view){
        setResult(RESULT_CANCELED);
        finish();

    }

    public void onOKClick(View view){
        Intent data = new Intent();
        data.putExtra("width", seekBar.getProgress());
        setResult(RESULT_OK);
        finish();

    }


}