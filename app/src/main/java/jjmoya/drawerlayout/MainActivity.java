package jjmoya.drawerlayout;
import android.support.v4.app.FragmentManager;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //elementos del menu


    //modifico esto


    private ListView listView;
    private DrawerLayout drawerLayout;

    //para el menu con elementos personalizados
    private String[] tagTitles;


    //otra cosa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar los elementos Drawer y listview haciendo un cast
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layoutejemplo);

        //obtenemos el listview
        listView = (ListView) findViewById(R.id.listviewejemplo);


        //inicio de la actividad
        Toast tostada= Toast.makeText(getApplicationContext(),"Inicio de la actividad",Toast.LENGTH_SHORT);
        tostada.show();

        //POBLAMOS EL LISTVIEW EN EL NAVIGATION DRAWER

        //obtenemos el arreglo de strings desde los recursos en el xml strings.xml
        tagTitles=getResources().getStringArray(R.array.Tags);


        //creacion de la lista de drawer items
        ArrayList<DrawerItem> items= new ArrayList<DrawerItem>();

        //cargamos el array con los string del array del xml y elementos icono del menu
        items.add(new DrawerItem(tagTitles[0],R.drawable.pimiento));
        items.add(new DrawerItem(tagTitles[2],R.drawable.pimiento));
        items.add(new DrawerItem(tagTitles[3],R.drawable.pimiento));
        items.add(new DrawerItem(tagTitles[4],R.drawable.pimiento));

        //Relacionamos el adaptador y la escucha de la lista del drawer
        listView.setAdapter(new DrawerListAdapter(this,items));

        //seteamos una instancia de esta escucha del navigation drawer
        listView.setOnItemClickListener(new DrawerItemClickListener());

        // Habilitar el icono de la app por si hay algún estilo que lo deshabilitó y
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    /**
     * clase que esta a la escucha del Drawer Inte, llama al select item que carga el nuevo fragment
     */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {

        // Reemplazar el contenido del layout principal por un fragmento creado
        Articlefragment fragment = new Articlefragment();
        //bundle par apasar los argunemos
        Bundle args = new Bundle();
        //pasamos la posicion seleccionaba en el menu a la clase de fragment para crearlo
        args.putInt(Articlefragment.ARG_ARTICLES_NUMBER, position);

        //cambiamos los argumentos
        fragment.setArguments(args);

        //creacion  fragment manager para manejar los datos OJO con el error de fragment
        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        // Se actualiza el item seleccionado y el título, después de cerrar el drawer
        listView.setItemChecked(position, true);
        setTitle(tagTitles[position]);
        drawerLayout.closeDrawer(listView);
    }


    /**
     * Abre y cierra el menu lateral si pulsamos el boton de home de nuestro android
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //recogemos el item del menu
        switch (item.getItemId()){
            //si pulsamos el boton de home de telefono
            case android.R.id.home:

                //si esta abierto
                if(drawerLayout.isDrawerOpen(listView)){
                    //inicio de la actividad
                    Toast tostada= Toast.makeText(getApplicationContext(),"Cierro Menu",Toast.LENGTH_SHORT);
                    tostada.show();


                    drawerLayout.closeDrawers();
                }else{
                    //inicio de la actividad
                    Toast tostada= Toast.makeText(getApplicationContext(),"Abro Menu",Toast.LENGTH_SHORT);
                    tostada.show();

                    drawerLayout.openDrawer(listView);
                }
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
