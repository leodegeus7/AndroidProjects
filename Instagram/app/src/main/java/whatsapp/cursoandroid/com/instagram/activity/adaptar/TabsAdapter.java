package whatsapp.cursoandroid.com.instagram.activity.adaptar;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;

import whatsapp.cursoandroid.com.instagram.activity.fragments.HomeFragment;
import whatsapp.cursoandroid.com.instagram.activity.fragments.UsuariosFragment;

/**
 * Created by leodegeus on 20/09/17.
 */

public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] abas = new String[]{"Home","Usuários"};
    private HashMap<Integer,Fragment> fragmentsUtilizados;

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        context = c;
        this.fragmentsUtilizados = new HashMap<>();
    }


    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        fragmentsUtilizados.clear();
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                fragmentsUtilizados.put(position,fragment);
                break;
            case 1:
                fragment = new UsuariosFragment();
                fragmentsUtilizados.put(position,fragment);
                break;
            default:
                break;
        }

        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        fragmentsUtilizados.remove(position);
    }

    public Fragment getFragment(Integer position) {
        return fragmentsUtilizados.get(position);
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
