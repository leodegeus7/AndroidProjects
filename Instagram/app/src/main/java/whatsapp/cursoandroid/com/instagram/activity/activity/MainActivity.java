package whatsapp.cursoandroid.com.instagram.activity.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import whatsapp.cursoandroid.com.instagram.R;
import whatsapp.cursoandroid.com.instagram.activity.adaptar.TabsAdapter;
import whatsapp.cursoandroid.com.instagram.activity.fragments.HomeFragment;
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
                compartilharFoto();
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

    private void compartilharFoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri localImagemSelecionada = data.getData();
            try {
                Bitmap imagem = MediaStore.Images.Media.getBitmap(getContentResolver(),localImagemSelecionada);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                imagem.compress(Bitmap.CompressFormat.PNG, 75,byteArrayOutputStream);

                byte[] bytes = byteArrayOutputStream.toByteArray();


                SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyyyhhmmss");
                String nomeImagem = dateFormat.format(new Date());
                ParseFile parseFile = new ParseFile(nomeImagem + "imagem.png", bytes);

                ParseObject parseObject = new ParseObject("Imagem");
                parseObject.put("username",ParseUser.getCurrentUser().getUsername());
                parseObject.put("imagem",parseFile);

                parseObject.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(getApplicationContext(),"Imagem Upada",Toast.LENGTH_SHORT).show();
                            TabsAdapter tabsAdapter = (TabsAdapter) viewPager.getAdapter();
                            HomeFragment homeFragment = (HomeFragment) tabsAdapter.getFragment(0);
                            homeFragment.atualizaPostagens();
                        } else {
                            Toast.makeText(getApplicationContext(),"Imagem não Upada. Error code:" + e.getCode(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
