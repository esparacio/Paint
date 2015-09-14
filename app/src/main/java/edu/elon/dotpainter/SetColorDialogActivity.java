//Author: Elena Sparacio & Patrick Lathan

package edu.elon.dotpainter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class SetColorDialogActivity extends Activity {

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;
    private SeekBar seekBarAlpha;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_color_dialog);

        Intent data = getIntent();
        int red = data.getIntExtra("red", DoodleView.DEFAULT_RED);
        int green = data.getIntExtra("green", DoodleView.DEFAULT_GREEN);
        int blue = data.getIntExtra("blue", DoodleView.DEFAULT_BLUE);
        int alpha = data.getIntExtra("alpha", DoodleView.DEFAULT_ALPHA);

        seekBarRed = (SeekBar) findViewById(R.id.seekbarred);
        seekBarGreen = (SeekBar) findViewById(R.id.seekbargreen);
        seekBarBlue = (SeekBar) findViewById(R.id.seekbarblue);
        seekBarAlpha = (SeekBar) findViewById(R.id.seekbaralpha);
        seekBarRed.setProgress(red);
        seekBarGreen.setProgress(green);
        seekBarBlue.setProgress(blue);
        seekBarAlpha.setProgress(alpha);
        seekBarRed.setOnSeekBarChangeListener(seekBarListener);
        seekBarGreen.setOnSeekBarChangeListener(seekBarListener);
        seekBarBlue.setOnSeekBarChangeListener(seekBarListener);
        seekBarAlpha.setOnSeekBarChangeListener(seekBarListener);

        imageView = (ImageView) findViewById(R.id.colorImageView);
        updateImageView();
    }

    void updateImageView() {
        Paint p = new Paint();
        p.setColor(Color.rgb(seekBarRed.getProgress(),seekBarGreen.getProgress(),seekBarBlue.getProgress()));
        Bitmap bitmap = Bitmap.createBitmap(1000, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(0, 0, 1000, 200, p);
        imageView.setImageBitmap(bitmap);
    }

    SeekBar.OnSeekBarChangeListener seekBarListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    updateImageView();
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            };

    public void onCancelClick(View view) {
        setResult(RESULT_CANCELED);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_set_color_dialog, menu);
        return true;
    }

    public void onSetColorClick(View view){
        Intent data = new Intent();
        data.putExtra("red", seekBarRed.getProgress());
        data.putExtra("green", seekBarGreen.getProgress());
        data.putExtra("blue", seekBarBlue.getProgress());
        data.putExtra("alpha", seekBarAlpha.getProgress());
        setResult(RESULT_OK, data);
        finish();
    }

}
