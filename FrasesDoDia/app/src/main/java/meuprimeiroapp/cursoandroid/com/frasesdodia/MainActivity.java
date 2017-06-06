package meuprimeiroapp.cursoandroid.com.frasesdodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView textoNovaFrase;
    private Button buttonNovaFrase;
    private String[] frases = {"Teatro1","Cinam2","Cine4","Cine8","Cine0","Cine41","Cine76"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textoNovaFrase = (TextView) findViewById(R.id.textViewNovaFrase);
        buttonNovaFrase = (Button) findViewById(R.id.botaoNovaFrase);
        textoNovaFrase.setText(frases[1]);
        buttonNovaFrase.setText("Testando3");
        buttonNovaFrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Random rand = new Random();
               int rand3 = rand.nextInt(frases.length-1);
                textoNovaFrase.setText(frases[rand3]);
            }
        });
    }
}