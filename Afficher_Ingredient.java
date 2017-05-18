package be.lsinf1225.ezmeal;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

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

public class Afficher_Ingredient  extends AppCompatActivity{

    android.support.v7.widget.Toolbar toolbar3;
    ListView listView3;
    DBHelper myManager = new DBHelper(this);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_ingredient);

        String ingredient = getIntent().getStringExtra("souscategories");
        toolbar3 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar3);
        toolbar3.setTitle("Ingrédients");
        ArrayList<String> listeingredient = myManager.getIngredientSC(ingredient);
        listView3 = (ListView) findViewById(R.id.listView3);
        ArrayAdapter<String> mAdapter3 = new ArrayAdapter<>(Afficher_Ingredient.this, android.R.layout.simple_list_item_1, listeingredient);
        listView3.setOnItemClickListener (new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView3, View view3, int i3, long l3){
                Intent intent3 = new Intent(Afficher_Ingredient.this, Afficher_recette2.class);
                intent3.putExtra("ingre", listView3.getItemAtPosition(i3).toString());
                startActivity(intent3);
            }

        });
        listView3.setAdapter(mAdapter3);
    }
    //SHOW MESSAGE
    public void showMessage(String titre, String contenu){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(contenu);
        builder.show();
    }
}
