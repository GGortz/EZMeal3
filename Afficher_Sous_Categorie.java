package be.lsinf1225.ezmeal;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Gaetan on 11/05/2017.
 */

public class Afficher_Sous_Categorie  extends AppCompatActivity{

    android.support.v7.widget.Toolbar toolbar2;
    ListView listView2;
    DBHelper myManager = new DBHelper(this);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_liste_sous_categorie);
        String sc = getIntent().getStringExtra("categories");

        toolbar2 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar2);
        toolbar2.setTitle("Sous-catégories");
        listView2 = (ListView) findViewById(R.id.listView2);
        ArrayList<String> listesouscategorie = myManager.getSousCategorie(sc);
        ArrayAdapter<String> mAdapter2 = new ArrayAdapter<>(AfficherSousCategorie.this, android.R.layout.simple_list_item_1, listesouscategorie);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView2, View view2, int i2, long l2){
                Intent intent2 = new Intent(AfficherSousCategorie.this, AfficherIngredient.class);
                intent2.putExtra("souscategories", listView2.getItemAtPosition(i2).toString());
                startActivity(intent2);
            }

        });
        listView2.setAdapter(mAdapter2);
    }
}
