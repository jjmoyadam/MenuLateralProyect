package jjmoya.drawerlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * clase que crea el adaptador de elementos del menu lateral
 */
public class DrawerListAdapter extends ArrayAdapter<DrawerItem> {

    //constructor
    public DrawerListAdapter(Context context, List<DrawerItem> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //cargamos el layout de elementos personalizados
            convertView = inflater.inflate(R.layout.element_menu, null);
        }

        //referenciamos los elementos de layout
        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        //obtenemos el elemento de menu
        DrawerItem item = getItem(position);
        // y cargamos los elementos de iconos y nombre
        icon.setImageResource(item.getIconId());
        name.setText(item.getName());


        return convertView;
    }
}