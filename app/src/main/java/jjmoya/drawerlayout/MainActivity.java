package jjmoya.drawerlayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //elementos del menu
    private ListView listView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar los elementos Drawer y listview haciendo un cast
        //listo
         listView= (ListView) findViewById(R.id.listviewejemplo);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layoutejemplo);

        //inicio de la actividad
        Toast tostada= Toast.makeText(getApplicationContext(),"Inicio de la actividad",Toast.LENGTH_SHORT);
        tostada.show();


        //creacion de un menu lateral con elementos de un array se puede personalizar con otros elementos
         final String[]opciones= {"Opcion1","Opcion2","Opcion3","Opcion4"};
        //adaptador que mendiante un arrayadapter le pasamos 2 layout de lista simple y de texto , le pasamos un array de opciones
        listView.setAdapter(new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,opciones));


        //funcionalidad de los elementos
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Toast.makeText(MainActivity.this, "Valor : " + opciones[arg2],
                        Toast.LENGTH_SHORT).show();

                //cierrra el menu
                drawerLayout.closeDrawers();

            }
        });
        //implementacion de los eventos de abrir y cerrar del menu lateral


    }
    //mostramos y ocultamos el menu lateral
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
