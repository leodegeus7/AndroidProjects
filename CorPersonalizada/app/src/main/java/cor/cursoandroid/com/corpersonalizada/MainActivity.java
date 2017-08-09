package cor.cursoandroid.com.corpersonalizada;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RadioGroup group;
    Button button;
    ConstraintLayout layout;

    private static final String ARQUIVO_NOME = "Nome";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        group = (RadioGroup) findViewById(R.id.radioGroup);
        button = (Button) findViewById(R.id.buttonId);
        layout = (ConstraintLayout) findViewById(R.id.layoutId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idChecked = group.getCheckedRadioButtonId();

                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_NOME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                switch (idChecked) {
                    case R.id.laranjaId:
                        editor.putString("cor","laranja");
                        setBackgroundColor("laranja");
                        break;
                    case R.id.verdeId:
                        editor.putString("cor","verde");
                        setBackgroundColor("verde");
                        break;
                    case R.id.azulId:
                        editor.putString("cor","azul");
                        setBackgroundColor("azul");
                        break;
                }
                editor.commit();
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_NOME,0);
        if (sharedPreferences.contains("cor"))
        {
            String cor = sharedPreferences.getString("cor","");
            if (cor != "") {
                setBackgroundColor(cor);
            }
        }


    }

    private void setBackgroundColor(String cor) {
        switch (cor) {
            case "laranja":
                layout.setBackgroundColor(getResources().getColor(R.color.laranjaCor));
                break;
            case "verde":
                layout.setBackgroundColor(getResources().getColor(R.color.verdeCor));
                break;
            case "azul":
                layout.setBackgroundColor(getResources().getColor(R.color.azulCor));
                break;
        }
    }
}
