package be.lsinf1225.ezmeal;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Gaetan on 11/05/2017.
 * A Faire
 */

public class Afficher_Recette extends AppCompatActivity {

/*
    DBHelper myManager = new DBHelper(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_recette);


        String titreFlag = getIntent().getStringExtra("titreFlag"); //on choppe la lettre qui vient de l'activité précédente
        Toast.makeText(Afficher_Recette.this, titreFlag, Toast.LENGTH_SHORT).show();

        //titre
        TextView titre = (TextView) findViewById(R.id.TVtitre);
        titre.setText(titreFlag);

        //image
        //String imgBDD = myManager.searchData2(titreFlag, "image");
        //Toast.makeText(Afficher_Recette.this, imgBDD, Toast.LENGTH_SHORT).show();

        ImageView iv = (ImageView) findViewById(IVbig);;
        int[] IMAGES = {R.mipmap.imgbig1, R.mipmap.imgbig2, R.mipmap.imgbig3, R.mipmap.imgbig4, R.mipmap.imgbig5, R.mipmap.imgbig6, R.mipmap.imgbig7, R.mipmap.imgbig8, R.mipmap.imgbig9, R.mipmap.imgbig10,
                R.mipmap.imgbig11, R.mipmap.imgbig12, R.mipmap.imgbig13, R.mipmap.imgbig14, R.mipmap.imgbig15, R.mipmap.imgbig16, R.mipmap.imgbig17, R.mipmap.imgbig18};
        //R.mipmap.img13 R.mipmap.img14, R.mipmap.img15, R.mipmap.img16};
        for(int m=1; m<=IMAGES.length; m++){
            if(imgBDD.equals("img"+m)){
                //if(Integer.toString(IMAGES[m]).equals(imgFromBDD)){  //Si l'image correspond dans la bdd
                iv.setImageResource(IMAGES[m-1]);
            }
            else{

            }
        }

        //les aliments de la recette ok
        ArrayList arr = new ArrayList();
        ArrayList arr2 = new ArrayList();
        //arr = myManager.getAlimentsRecette(titreFlag,"aliment");
        //arr2 = myManager.getAlimentsRecette(titreFlag,"quantite");
        TextView aliments = (TextView) findViewById(R.id.TValiments);
        String result = TextUtils.join(System.getProperty("line.separator"), arr);
        aliments.setText(result);
        TextView quantite = (TextView) findViewById(R.id.TVquantite);
        String result2 = TextUtils.join(System.getProperty("line.separator"), arr2);
        quantite.setText(result2);
        //le reste
        String descriptionFromBDD = myManager.searchData2(titreFlag, "description");
        TextView description = (TextView) findViewById(R.id.TVdescription);
        description.setText(descriptionFromBDD);

        String etapeFromBDD = myManager.searchData2(titreFlag, "etape");
        TextView etape = (TextView) findViewById(R.id.TVetapes);
        etape.setText(etapeFromBDD);

        String tpreparatoinFromBDD = myManager.searchData2(titreFlag, "Tpreparation");
        TextView tprepa = (TextView) findViewById(R.id.TVpreparation);
        tprepa.setText(tpreparatoinFromBDD);

        String tcuissonFromBDD = myManager.searchData2(titreFlag, "Tcuisson");
        TextView tcuiss = (TextView) findViewById(R.id.TVcuisson);
        tcuiss.setText(tcuissonFromBDD);

        String diffFromBDD = myManager.searchData2(titreFlag, "facilite");
        TextView diff = (TextView) findViewById(R.id.TVdiff);
        diff.setText(diffFromBDD);

        String persFromBDD = myManager.searchData2(titreFlag, "nbr");
        TextView nbr = (TextView) findViewById(R.id.TVnbr);
        nbr.setText(persFromBDD);
    }

    public void onBtnClick(View v) {
        if (v.getId() == R.id.bRetour) {
            onBackPressed();
        }
    }







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

public class AfficherRecette extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar4;
    ListView listView4;
    DBHelper myManager = new DBHelper(this);



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afficher_liste_recette);


        String ingredient = getIntent().getStringExtra("ingredients");
        toolbar4 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar4);
        toolbar4.setTitle("Recettes");
        ArrayList<String> listerecette = new ArrayList<String>();
        listerecette = myManager.getRecetteIngredient(ingredient);
        listView4 = (ListView) findViewById(R.id.listView4);
        ArrayAdapter<String> mAdapter4 = new ArrayAdapter<>(AfficherRecette.this, android.R.layout.simple_list_item_1, listerecette);
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView4, View view4, int i4, long l4){
                Intent intent4 = new Intent(AfficherRecette.this, Main5Activity.class);
                intent4.putExtra("recettes", listView4.getItemAtPosition(i4).toString());
                startActivity(intent4);
            }

        });
        listView4.setAdapter(mAdapter4);
    }
}

    */
}
