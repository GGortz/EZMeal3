package be.lsinf1225.ezmeal;

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

public class Afficher_Categorie  extends AppCompatActivity{

    android.support.v7.widget.Toolbar toolbar;
    ListView listView;
    DBHelper myManager = new DBHelper(this);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_liste_categorie);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Catégories");
        listView =(ListView) findViewById(R.id.listView);
        ArrayList<String> listecategorie = myManager.getCategorie(); //Afficher toute les caté
        ArrayAdapter<String> mAdapter = new ArrayAdapter<>(AfficherCategorie.this, android.R.layout.simple_list_item_1, listecategorie);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent(AfficherCategorie.this, AfficherSousCategorie.class);
                intent.putExtra("categories", listView.getItemAtPosition(i).toString());  //envoie le nom de la sous cate choisie
                startActivity(intent);
            }

        });
        listView.setAdapter(mAdapter);
    }
}


