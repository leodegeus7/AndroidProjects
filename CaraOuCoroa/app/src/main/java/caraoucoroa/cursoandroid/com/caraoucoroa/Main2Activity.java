package caraoucoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    ImageView moeda;
    ImageView voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        moeda = (ImageView) findViewById(R.id.moedaId);
        voltar = (ImageView) findViewById(R.id.voltarID);


        Bundle extra = getIntent().getExtras();

        if (extra != null) {
            Boolean bool = (Boolean) extra.get("moeda");
            if (bool) {
                moeda.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this,R.drawable.moeda_cara));
            } else {
                moeda.setImageDrawable(ContextCompat.getDrawable(Main2Activity.this,R.drawable.moeda_coroa));
            }
        }

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }

        });


    }
}
