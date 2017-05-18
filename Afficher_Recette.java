package be.lsinf1225.ezmeal;

import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import static be.lsinf1225.ezmeal.R.id.arcom;
import static be.lsinf1225.ezmeal.R.id.arcomplexite;
import static be.lsinf1225.ezmeal.R.id.arcouv;
import static be.lsinf1225.ezmeal.R.id.ardescription;
import static be.lsinf1225.ezmeal.R.id.aretape;
import static be.lsinf1225.ezmeal.R.id.arimage;
import static be.lsinf1225.ezmeal.R.id.aringredient;
import static be.lsinf1225.ezmeal.R.id.arrating;
import static be.lsinf1225.ezmeal.R.id.artcuis;
import static be.lsinf1225.ezmeal.R.id.artitre;
import static be.lsinf1225.ezmeal.R.id.artprep;
import static be.lsinf1225.ezmeal.R.id.text;
import static be.lsinf1225.ezmeal.R.layout.afficher_recette;

/**
 * Created by Gaetan on 11/05/2017.
 * A Faire
 */

public class Afficher_Recette extends AppCompatActivity {
        DBHelper db = new DBHelper(this);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(afficher_recette);

        String nomrecette = getIntent().getStringExtra("recettes");
        int i = db.getId(nomrecette);


        //Titre
        TextView titre = (TextView) findViewById(artitre);
        String rtitre = db.searchData2(i,"NomR");
        titre.setText(rtitre);

        //Image  a finir
        ImageView image = (ImageView) findViewById(arimage);
        int idimage = R.drawable.r1;
        image.setImageResource(idimage);

        //Description
        TextView description = (TextView) findViewById(ardescription);
        String rdescription = db.searchData2(i, "Description");
        //String rdescription = "redescription";
        description.setText(rdescription);

        //Prix
        TextView prix = (TextView) findViewById(R.id.arprix);
        String rprix = db.searchData2(i, "Cout");
        //String rprix = "rprix";
        prix.setText(rprix);

        //Temps préparation
        TextView tprep = (TextView) findViewById(artprep);
        String rtprep = db.searchData2(i, "Tpreparation");
        //String rtprep = "rtprep";
        tprep.setText(rtprep);

        //Temps cuisson
        TextView tcuis = (TextView) findViewById(artcuis);
        String rtcuis = db.searchData2(i, "Tcuisson");
        //String rtcuis = "rtcuis";
        tcuis.setText(rtcuis);

        //Nbre couv
        TextView ncouv = (TextView) findViewById(arcouv);
        String rncouv = db.searchData2(i, "NbreCouv");
        //String rncouv = "rncouv";
        ncouv.setText(rncouv);

        //Complexité
        TextView complex = (TextView) findViewById(arcomplexite);
        String rcomplexite = db.searchData2(i, "Difficulte");
        //String rcomplexite = "rcomplexité";
        complex.setText(rcomplexite);

        //Ingredient
        TextView ingredient = (TextView) findViewById(aringredient);
        String ringredient = db.ingredientrecette(i);
        //String ringredient = "ringredient";
        ingredient.setText(ringredient);

        //Etape
        TextView etape = (TextView) findViewById(aretape);
        String retape = db.etaperecette(i);
        //String retape = "retape";
        etape.setText(retape);

        //Rating
        RatingBar rate = (RatingBar) findViewById(arrating);
        Float rrate = db.searchRate(i);
        //Float rrate = Float.parseFloat("1");
        rate.setRating(rrate);


        //Commentaire
        TextView commentaire = (TextView) findViewById(arcom);
        String rcom = db.searchCom(i);
        //String rcom = "rcom";
        commentaire.setText(rcom);

    }
}
