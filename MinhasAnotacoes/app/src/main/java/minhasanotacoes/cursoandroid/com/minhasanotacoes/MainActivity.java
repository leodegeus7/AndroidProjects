package minhasanotacoes.cursoandroid.com.minhasanotacoes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText texto;
    private ImageView botaoSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.editTextAnotacoes);
        botaoSalvar = (ImageView) findViewById(R.id.buttonSalvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textDigitado = texto.getText().toString();
                gravarNoArquivo(textDigitado);

            }
        });

        if (abrirArquivo() != null) {
            texto.setText(abrirArquivo());
        }
    }

    private void gravarNoArquivo(String texto) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("arquivoAnotacao.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
            Toast.makeText(getApplicationContext(),"Salvo",Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            Log.v("Error:", e.toString());
        }
    }

    private String abrirArquivo() {
        String resultado = "";
        try {
            InputStream inputStream = openFileInput("arquivoAnotacao.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String linhaArquivo = "";
                while ((linhaArquivo = bufferedReader.readLine()) != null) {
                    resultado += linhaArquivo;

                }
                inputStream.close();
                return resultado;
            } else {
                return "";
            }
        }
        catch (IOException e) {
            Log.v("Error:", e.toString());
            return "";
        }

    }
}
