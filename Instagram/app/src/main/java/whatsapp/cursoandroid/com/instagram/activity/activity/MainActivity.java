package whatsapp.cursoandroid.com.instagram.activity.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import whatsapp.cursoandroid.com.instagram.R;
import whatsapp.cursoandroid.com.instagram.activity.adaptar.TabsAdapter;
import whatsapp.cursoandroid.com.instagram.activity.util.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbarPrincipal;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbarPrincipal = (Toolbar) findViewById(R.id.toolbarPrincipal);
        toolbarPrincipal.setLogo(R.drawable.instagramlogo);
        setSupportActionBar(toolbarPrincipal);


        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidingTabMain);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(tabsAdapter);
        slidingTabLayout.setCustomTabView(R.layout.tab_view,R.id.textItemTab);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.colorCinza));
        slidingTabLayout.setViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionCompartilhar:
                return true;
            case R.id.actionConfiguracoes:
                return true;
            case R.id.actionSair:
                deslogarUsuario();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void deslogarUsuario() {
        ParseUser.logOut();
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
