package passdata.cursoandroid.com.passsatabetweenviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    private TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        texto = (TextView) findViewById(R.id.textViewId);

        Bundle extra = getIntent().getExtras();

        if (extra != null) {

            String text = extra.getString("NAME");
            texto.setText(text);
        }

    }
}
