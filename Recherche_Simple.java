package be.lsinf1225.ezmeal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Gaetan on 11/05/2017.
 */

public class Recherche_Simple extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recherche_simple);  //xml ok pour bouton mais pas couleur

    }


    public void onBtnClick(View v) {
        if (v.getId() == R.id.bMotclef) {
            Intent affciherlisterecette2 = new Intent(Recherche_Simple.this, Afficher_recette2.class); //changement d'activity
            EditText ingredientvoulu = (EditText) findViewById(R.id.ETmotClef); //le mot clef tappé
            String stringredientvoulu = ingredientvoulu.getText().toString();
            affciherlisterecette2.putExtra("ingredients", stringredientvoulu); //On envoie le mot clef dans l'activité d'affichage
            startActivity(affciherlisterecette2);
        }
    }
}