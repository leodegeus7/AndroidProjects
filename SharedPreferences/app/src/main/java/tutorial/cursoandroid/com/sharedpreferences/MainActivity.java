package tutorial.cursoandroid.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    TextView textViewResult;
    EditText editText;

    private final static String ARQUIVO_PREFERENCIA = "ArquivoPreferencia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);
        textViewResult = (TextView) findViewById(R.id.textViewResultId);
        editText = (EditText) findViewById(R.id.editTextId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (editText.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Por favor, preencha o nome",Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("name",editText.getText().toString());
                    editor.commit();
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (sharedPreferences.contains("name")) {
            String nomeUser = sharedPreferences.getString("name","User não definido");
            textViewResult.setText(nomeUser);
        } else {
            textViewResult.setText("Ola user");
        }

    }
}
