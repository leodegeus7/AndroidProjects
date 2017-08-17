package firebase.cursoandroid.com.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference databaseUsuarios = databaseReference.child("usuarios");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseUsuarios.setValue("Oi");

        /*
        Usuario usuario = new Usuario();
        usuario.setNome("Ana");
        usuario.setSobrenome("Helena");
        usuario.setSexo("Feminino");
        usuario.setIdade(25);

        Produto produto1 = new Produto();
        produto1.setNome("Iphone 6");
        produto1.setCor("Azul");
        produto1.setCod(738833);

        databaseUsuarios.child("001").setValue(usuario);
        databaseReference.child("produtos").child("001").setValue(produto1);
        */

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("Firebase",dataSnapshot.child("produtos").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
