package whatsapp.cursoandroid.com.instagram.activity.adaptar;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import whatsapp.cursoandroid.com.instagram.R;

/**
 * Created by leodegeus on 29/09/2017.
 */


public class UsuariosAdapter extends ArrayAdapter<ParseUser>{

    private Context context;
    private ArrayList<ParseUser> arrayList;

    public UsuariosAdapter(@NonNull Context c, @NonNull ArrayList<ParseUser> objects) {
        super(c, 0, objects);
        this.context = c;
        this.arrayList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_usuarios,parent,false);
        }

        TextView textView = (TextView) view.findViewById(R.id.textViewUsuarios);

        ParseUser parseUser = arrayList.get(position);
        textView.setText(parseUser.getUsername());
        return view;
    }
}
