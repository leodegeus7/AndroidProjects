package cursoandroid.com.conversorgasolinaalcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoTransformar;
    private TextView textoResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        precoAlcool = (EditText) findViewById(R.id.editTextAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.editTextGasolinaID);
        botaoTransformar = (Button) findViewById(R.id.buttonTransformarId);
        textoResultado = (TextView) findViewById(R.id.textViewResultId);

        botaoTransformar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                if (Double.parseDouble(textoPrecoAlcool) / Double.parseDouble(textoPrecoGasolina) >= 0.7) {
                    textoResultado.setText("O melhor é a gasolina");
                } else {
                    textoResultado.setText("O melhor é o alcool");
                }
            }
        });
    }
}
