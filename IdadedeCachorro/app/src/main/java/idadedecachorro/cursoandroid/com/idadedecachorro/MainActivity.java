package idadedecachorro.cursoandroid.com.idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewDog;
    private Button buttonDog;
    private EditText editTextDog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewDog = (TextView) findViewById(R.id.resultadoIdade);
        buttonDog = (Button) findViewById(R.id.buttonIdadeId);
        editTextDog = (EditText) findViewById(R.id.editTextId);

        buttonDog.setOnClickListener(new View.OnClickListener() { //coloca a palavra new view
            @Override
            public void onClick(View v) {
                String text = editTextDog.getText().toString();
            }
        });
    }
}
