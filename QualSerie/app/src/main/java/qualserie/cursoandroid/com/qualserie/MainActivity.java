package qualserie.cursoandroid.com.qualserie;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBarId);
        image = (ImageView) findViewById(R.id.imageId);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 0:
                        image.setImageResource(0);
                    case 1:
                        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pouco));
                        break;
                    case 2:
                        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.medio));
                        break;
                    case 3:
                        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.muito));
                        break;
                    case 4:
                        image.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.susto));
                        break;
                    default:
                        break;


                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
