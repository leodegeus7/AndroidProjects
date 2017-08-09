package bancodedados.cursoandroid.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bancoDeDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criação de tabela - criar uma tabela pessoas com nome e idade
            //Nome como VARCHAR (texto) e idade como int de 3 para identificar o tamanho do inteiro (até 999)
            //Usa o INTEGER PRIMARY KEY para definir ID
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR,idade INT(3))");

            //Inserir dados
            bancoDeDados.execSQL("INSERT INTO pessoas (nome,idade) VALUES ('Marcos',30)");
            bancoDeDados.execSQL("INSERT INTO pessoas (nome,idade) VALUES ('Ana',29)");

            //Atualiza a idade do marcos para 20 anos
            bancoDeDados.execSQL("UPDATE pessoas SET idade = 20 WHERE nome = 'Marcos'");
            //passar item a item e recueprar valores

            //Colocando % pego todos os caracteres antes e depois de ar
            //Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM pessoas WHERE nome LIKE '%ar%'", null);
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM pessoas", null);

            //recuperar indice da coluna
            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaInt = cursor.getColumnIndex("id");
            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - id ", cursor.getString(indiceColunaInt));
                Log.i("Resultado - nome ", cursor.getString(indiceColunaNome));
                Log.i("Resultado - idade ", cursor.getString(indiceColunaIdade));

                cursor.moveToNext();
            }

            //Apaga a tabela pessoas
            //bancoDeDados.execSQL("DROP TABLE pessoas");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
