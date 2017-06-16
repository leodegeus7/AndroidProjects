package tutorial.cursoandroid.com.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;
    private CheckBox cavaloCheck;
    private CheckBox gatoCheck;
    private CheckBox cachorroCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonId);
        textView = (TextView) findViewById(R.id.textViewId);
        cavaloCheck = (CheckBox) findViewById(R.id.cavaloCheck);
        cachorroCheck = (CheckBox) findViewById(R.id.cachorroCheck);
        gatoCheck = (CheckBox) findViewById(R.id.gatoCheck);

        textView.setText("");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                if (cavaloCheck.isChecked()) {
                    text += "Cavalo está selecionado \n";
                }
                if (cachorroCheck.isChecked()) {
                    text += "Cachorro está selecionado \n";
                }
                if (gatoCheck.isChecked()) {
                    text += "Gato está selecionado \n";
                }
                textView.setText(text);
            }
        });
    }
}
