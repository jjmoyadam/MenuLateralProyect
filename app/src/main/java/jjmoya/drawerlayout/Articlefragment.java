package jjmoya.drawerlayout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Creacion de la clase de fragment para manejar los articulos
 */
public class Articlefragment extends Fragment {


    //variable estatica para cargar los elementos del articulo que recibimos de la actividad principal
    public static  final  String ARG_ARTICLES_NUMBER="articles_number";

    //constructor vacio obligatorio
    public Articlefragment() {
    }

    //metodo que crea la vista del fragment

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // creacion de la vista y la inflamos con el layout de article frangment
        View rootview =inflater.inflate(R.layout.article_fragment,container,false);

        //recogemos en elemento de articulo
        int i=getArguments().getInt(ARG_ARTICLES_NUMBER);

        //de los recuros sacamos el elemento i del array de tags guardado en strings.xml
        String article=getResources().getStringArray(R.array.Tags)[i];

        //en la actividad cambiamos el titulo de la actividad
        getActivity().setTitle(article);

        //declaramos el textview y lo referenciamos
        TextView headline=rootview.findViewById(R.id.cabecera);

        //lo cargamos con el string de articulo
        headline.append(" "+article);

        return rootview;
    }
}
