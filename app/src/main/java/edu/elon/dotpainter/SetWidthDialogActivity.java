//Author: Elena Sparacio

package edu.elon.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SetWidthDialogActivity extends Activity {

    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_width_dialog);

        Intent data = getIntent();
        int width = data.getIntExtra("width", DoodleView.DEFAULT_WIDTH);

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setProgress(width);
        seekBar.setOnSeekBarChangeListener(seekBarListener);

        imageView = (ImageView) findViewById(R.id.imageView);
        updateImageView();
    }

    void updateImageView(){
        Paint p = new Paint();
        p.setColor(Color.WHITE);
        Bitmap bitmap = Bitmap.createBitmap(250,250,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(125,125,seekBar.getProgress(),p);
        imageView.setImageBitmap(bitmap);
    }

    SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener(){
                @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                    updateImageView();
                }
                @Override
            public void onStartTrackingTouch(SeekBar seekbar) {

                }
                @Override
            public void onStopTrackingTouch(SeekBar seekBar){

                }
            };

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