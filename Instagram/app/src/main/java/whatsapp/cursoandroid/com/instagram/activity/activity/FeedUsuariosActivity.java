package whatsapp.cursoandroid.com.instagram.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import whatsapp.cursoandroid.com.instagram.R;
import whatsapp.cursoandroid.com.instagram.activity.adaptar.HomeAdaptar;

public class FeedUsuariosActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    private String username;
    private ArrayAdapter<ParseObject> adapter;
    private ArrayList<ParseObject> postagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_usuarios);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        postagens = new  ArrayList<ParseObject>();
        toolbar = (Toolbar) findViewById(R.id.toolbarFeed);
        toolbar.setTitle(username);

        toolbar.setNavigationIcon(R.drawable.ic_keyboard_arrow_left);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listViewFeedUsuarios);

        adapter = new HomeAdaptar(getApplicationContext(),postagens);
        listView.setAdapter(adapter);

        getPostagens();

    }

    private void getPostagens() {
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Imagem");
        query.whereEqualTo("username",username);
        query.orderByAscending("createdAt");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e==null) {
                    if (objects.size() == 0) {
                        postagens.clear();
                    } else {
                        postagens.clear();
                        for (ParseObject parseObject:objects) {
                            postagens.add(parseObject);

                        }
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Erro ao recuperar postagens",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
