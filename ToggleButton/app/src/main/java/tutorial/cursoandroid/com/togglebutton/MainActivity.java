package tutorial.cursoandroid.com.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toogleButton;
    private TextView textViewStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toogleButton = (ToggleButton) findViewById(R.id.toggleButtonId);
        textViewStatus = (TextView) findViewById(R.id.textView2);
        textViewStatus.setText("");
        toogleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewStatus.setText("Ligado");
                } else {
                    textViewStatus.setText("Desligado");
                }
            }
        });

    }
}
