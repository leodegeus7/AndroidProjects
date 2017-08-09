package tutorial.cursoandroid.com.radiobutton;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    Button button;
    RadioButton lasanha;
    RadioButton parmegiana;
    RadioButton macarrao;
    TextView textView;
    RadioGroup radioGroup;
    TextView exibicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.escolheId);
        lasanha = (RadioButton) findViewById(R.id.lasanhaId);
        parmegiana = (RadioButton) findViewById(R.id.parmegianaId);
        macarrao = (RadioButton) findViewById(R.id.macarraoId);
        textView = (TextView) findViewById(R.id.textView);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        exibicao = (TextView) findViewById(R.id.exibicaoId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButton = radioGroup.getCheckedRadioButtonId();
                exibicao.setText("" + idRadioButton);

                RadioButton radioButtonEscolhido = (RadioButton) findViewById(idRadioButton);
                String text = radioButtonEscolhido.getText().toString();
                exibicao.setText(text);
            }
        });

    }
}
