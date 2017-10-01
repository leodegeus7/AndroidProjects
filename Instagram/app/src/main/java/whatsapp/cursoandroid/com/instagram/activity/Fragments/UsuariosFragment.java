package whatsapp.cursoandroid.com.instagram.activity.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import whatsapp.cursoandroid.com.instagram.R;
import whatsapp.cursoandroid.com.instagram.activity.activity.FeedUsuariosActivity;
import whatsapp.cursoandroid.com.instagram.activity.adaptar.UsuariosAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuariosFragment extends Fragment {


    private ListView listView;
    private ArrayAdapter<ParseUser> adapter;
    private ArrayList<ParseUser> usuarios;
    private ParseQuery<ParseUser> query;

    public UsuariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usuarios, container, false);
        listView = view.findViewById(R.id.listViewUsuarios);
        usuarios = new ArrayList<>();
        adapter = new UsuariosAdapter(getContext(),usuarios);
        listView.setAdapter(adapter);

        getUsuarios();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ParseUser parseUser = usuarios.get(i);

                Intent intent = new Intent(getActivity(), FeedUsuariosActivity.class);

                intent.putExtra("username",parseUser.getUsername());

                startActivity(intent);
            }
        });
        return view;
    }

    private void getUsuarios() {
        query = ParseUser.getQuery();
        query.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());
        query.orderByAscending("username");
        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e==null) {
                    if (objects.size() > 0) {
                        usuarios.clear();
                        for (ParseUser parseUser : objects) {
                            usuarios.add(parseUser);
                        }
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    e.printStackTrace();
                }
            }
        });
    }

}
