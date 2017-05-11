package be.lsinf1225.ezmeal;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Gaetan on 11/05/2017.
 */

public class Catalogue_Recette extends AppCompatActivity{

    android.support.v7.widget.Toolbar toolbar4;
    ListView listview4;
    DBHelper myManager = new DBHelper(this);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.catalogue_recette);

        listview4 = (ListView)findViewById(R.id.listView4);
        toolbar4 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar4);
        toolbar4.setTitle("Catalogue");
        ArrayList<String> listerecette = new ArrayList<>();
        listerecette = myManager.getRecetteArray();
        ArrayAdapter<String> mAdapter4 = new ArrayAdapter<>(Catalogue_Recette.this, android.R.layout.simple_list_item_1, listerecette);
        listview4.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView4, View view4, int i4, long l4){
                Intent intent4 = new Intent(Catalogue_Recette.this, Afficher_Recette.class);
                intent4.putExtra("recettes", listview4.getItemAtPosition(i4).toString());
                startActivity(intent4);
            }

        });
        listview4.setAdapter(mAdapter4);
    }
}
