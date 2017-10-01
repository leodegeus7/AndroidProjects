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

import com.parse.ParseObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import whatsapp.cursoandroid.com.instagram.R;

/**
 * Created by leodegeus on 27/09/17.
 */

public class HomeAdaptar extends ArrayAdapter<ParseObject> {

    private Context context;
    private ArrayList<ParseObject> postagens;

    public HomeAdaptar(@NonNull Context c, @NonNull ArrayList<ParseObject> objects) {
        super(c, 0, objects);
        this.context = c;
        this.postagens = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_postagem,parent,false);
        }

        if (postagens.size() > 0 ) {
            ImageView imageView = (ImageView) view.findViewById(R.id.image_lista_postagem);
            ParseObject object = postagens.get(position);

            Picasso.with(getContext()).load(object.getParseFile("imagem").getUrl()).fit().into(imageView);

        }
        return view;
    }
}
