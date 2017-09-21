package whatsapp.cursoandroid.com.instagram.activity.adaptar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import whatsapp.cursoandroid.com.instagram.activity.Fragments.HomeFragment;
import whatsapp.cursoandroid.com.instagram.activity.Fragments.UsuariosFragment;

/**
 * Created by leodegeus on 20/09/17.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] abas = new String[]{"Home","Usuários"};

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        context = c;

    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new UsuariosFragment();
                break;
            default:
                break;
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return abas[position];
    }

    @Override
    public int getCount() {
        return abas.length;
    }


}
