package be.lsinf1225.ezmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ezmeal);
    }

    DBHelper db = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        SharedPreferences info = getSharedPreferences("InfoUser", 0);
        String login = info.getString("LoginUser", "0");
    }

    public void onBtnClick(View v) {

        if (v.getId() == R.id.bCatalogue) {   //Si on clique sur catalogue, on ouvre l'activité catalogue
            Intent catalogue = new Intent(Menu.this, Catalogue.class);
            startActivity(catalogue);
        }  //OK

        if (v.getId() == R.id.bRecherche) {
            Intent recherche = new Intent(Menu.this, RechercheSimple.class); //Pour rechercher      Si on clique sur recherche, on ouvre l'activite recherche
            startActivity(recherche);
        }  //OK affichageresultalistview

        if (v.getId() == R.id.bDeconnexion) {
            Intent deco = new Intent(Menu.this, MainActivity.class); //Pour deco     On revient au layout de base + on reinitialise le sharepreference login a 0

            SharedPreferences info = getSharedPreferences("InfoUser",0);
            SharedPreferences.Editor editeur = info.edit();
            editeur.remove("LoginUser");//A checker si fonctionne bien, erreur surement de la
            editeur.apply();

            startActivity(deco);
        }

        if(v.getId() == R.id.bProfil){
            Intent profil = new Intent(Menu.this, UserInfo.class); //Si on clique sur compte, on peut visualiser son compte (et changer des donnees)
            startActivity(profil);
        }
        if(v.getId() == R.id.bRechercheAvancee){
            Intent rechavan = new Intent(Menu.this, RechercheAvancee.class); //changement d'activity   CHANGER
            startActivity(rechavan);
        }

        if(v.getId() == R.id.bCategories){  //     Pour les cate        Si on clique sur categorie, on ouvre l'activite categorie
            Intent categorie = new Intent(Menu.this, AfficherCategorie.class);
            startActivity(categorie);

        }
    }
}
