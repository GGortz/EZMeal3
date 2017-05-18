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



public class Afficher_recette2 extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar4;
    ListView listView4;
    DBHelper myManager = new DBHelper(this);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_recette2);

        String ingredient = getIntent().getStringExtra("ingre");
        toolbar4 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar4);
        toolbar4.setTitle("Recettes");
        ArrayList<String> listerecette = myManager.getRecetteIngredient(ingredient);
        listView4 = (ListView) findViewById(R.id.listView4);
        ArrayAdapter<String> mAdapter4 = new ArrayAdapter<>(Afficher_recette2.this, android.R.layout.simple_list_item_1, listerecette);
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView4, View view4, int i4, long l4){
                Intent intent4 = new Intent(Afficher_recette2.this, Afficher_Recette.class);
                intent4.putExtra("recettes", listView4.getItemAtPosition(i4).toString());
                startActivity(intent4);
            }

        });
        listView4.setAdapter(mAdapter4);
    }
}