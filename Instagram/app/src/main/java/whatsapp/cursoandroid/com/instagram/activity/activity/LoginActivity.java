package whatsapp.cursoandroid.com.instagram.activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import whatsapp.cursoandroid.com.instagram.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editUser;
    private EditText editPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUser = (EditText) findViewById(R.id.edit_LoginUser);
        editPassword = (EditText) findViewById(R.id.edit_Senha);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        verificaUsuarioLogado();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editUser.getText().toString();
                String senha = editPassword.getText().toString();

                verificaLogin(usuario,senha);
            }
        });

    }

    public void abrirCadastroUsuario(View view) {
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }

    private void verificaUsuarioLogado() {
        if (ParseUser.getCurrentUser() != null) {
            abrirTelaPrincipalApp();
        }
    }

    private void verificaLogin(String usuario,String senha) {
        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    Toast.makeText(getApplicationContext(),"Login realizado",Toast.LENGTH_SHORT).show();
                    abrirTelaPrincipalApp();
                } else {
                    Toast.makeText(getApplicationContext(),"Login não realizado" + e.getCode(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private  void abrirTelaPrincipalApp() {
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}

