package tutorial.cursoandroid.com.tocarmusica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.tocarId);
        mediaPlayer = MediaPlayer.create(this,R.raw.musica);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tocarMusica();
                if (mediaPlayer.isPlaying()) {
                    button.setText("Pausar");
                } else {
                    button.setText("Tocar");
                }

            }
        });
    }

    private void tocarMusica() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            } else {
                mediaPlayer.start();
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}
