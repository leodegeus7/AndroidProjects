package firebase.cursoandroid.com.autenticacaofirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        /* REGISTRO DO USUÁRIO
        firebaseAuth.createUserWithEmailAndPassword("leonardodegeus@gmail.com","123456789").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Sucesso",Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_SHORT);
                }
            }
        });
        */

        firebaseAuth.signInWithEmailAndPassword("leonardodegeus@gmail.com","123456789").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Sucesso",Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(),"Erro",Toast.LENGTH_SHORT);
                }
            }
        });

        if (firebaseAuth.getCurrentUser() != null) {
            Toast.makeText(getApplicationContext(),"Usuario logado",Toast.LENGTH_SHORT);
        } else {
            Toast.makeText(getApplicationContext(),"Usuario não logado",Toast.LENGTH_SHORT);
        }

        firebaseAuth.signOut();


    }
}
