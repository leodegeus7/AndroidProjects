package whatsapp.cursoandroid.com.instagram.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import whatsapp.cursoandroid.com.instagram.R;
import whatsapp.cursoandroid.com.instagram.activity.helper.ParseError;

public class CadastroActivity extends AppCompatActivity {

    TextView email;
    TextView senha;
    TextView usuario;
    TextView buttonCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        email = (EditText) findViewById(R.id.textEmail);
        senha = (EditText) findViewById(R.id.textSenha);
        usuario = (EditText) findViewById(R.id.text_usuario);
        buttonCadastrar = (Button) findViewById(R.id.textButton);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarUsuario();
            }
        });

    }

    public void abrirLogin(View view) {
        Intent intent = new Intent(CadastroActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    private void cadastrarUsuario() {
        ParseUser usuarioParse = new ParseUser();
        usuarioParse.setUsername(usuario.getText().toString());
        usuarioParse.setPassword(senha.getText().toString());
        usuarioParse.setEmail(email.getText().toString());
        usuarioParse.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null) {
                    Toast.makeText(getApplicationContext(),"Cadastro realizado com sucesso",Toast.LENGTH_SHORT).show();
                    abrirTelaLogin();
                } else {
                    ParseError parseError = new ParseError();

                    Toast.makeText(getApplicationContext(),"Cadastro não realizado! " + parseError.getErro(e.getCode()),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  void abrirTelaLogin() {
        Intent intent = new Intent(CadastroActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
