package somdosbichos.cursoandroid.com.somdosbichos;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView cachorro;
    private ImageView gato;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView leao;
    private ImageView vaca;

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cachorro = (ImageView) findViewById(R.id.cachorroId);
        gato = (ImageView) findViewById(R.id.gatoId);
        ovelha = (ImageView) findViewById(R.id.ovelhaId);
        macaco = (ImageView) findViewById(R.id.macacoId);
        leao = (ImageView) findViewById(R.id.leaoId);
        vaca = (ImageView) findViewById(R.id.vacaId);

        cachorro.setOnClickListener(this);
        gato.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        macaco.setOnClickListener(this);
        leao.setOnClickListener(this);
        vaca.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.cachorroId:
                mediaPlayer = MediaPlayer.create(this,R.raw.cao);
                break;
            case R.id.macacoId:
                mediaPlayer = MediaPlayer.create(this,R.raw.macaco);
                break;
            case R.id.gatoId:
                mediaPlayer = MediaPlayer.create(this,R.raw.gato);
                break;
            case R.id.leaoId:
                mediaPlayer = MediaPlayer.create(this,R.raw.leao);
                break;
            case R.id.vacaId:
                mediaPlayer = MediaPlayer.create(this,R.raw.vaca);
                break;
            case R.id.ovelhaId:
                mediaPlayer = MediaPlayer.create(this,R.raw.ovelha);
                break;
        }
        tocarSom();
    }

    private void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
