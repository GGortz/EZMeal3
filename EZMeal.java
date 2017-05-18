package be.lsinf1225.ezmeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Gaetan on 11/05/2017.
 */

public class EZMeal extends AppCompatActivity {

    DBHelper manager = new DBHelper(this);  //construit la db (appelle le constructor)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ezmeal);

    }


    //Click sur le bouton Menu pr chts de activity
    public void onBtnClick(View v){


        if(v.getId() == R.id.bLogin){


            EditText e = (EditText)findViewById(R.id.ETemail); //On recupère le login
            String stre = e.getText().toString();

            EditText f = (EditText)findViewById(R.id.ETmdp); //On recupère le mdp
            String strf = f.getText().toString();

            //On vérifie la concordance du login et du mdp
            String mdp = manager.searchMdp(stre);

            if(strf.equals(mdp)){
                showMessage("Bienvenue", stre);
                //On enregisre le Login de l'utilisateur afin de savoir acceder a ses donnees
                SharedPreferences info = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editeur = info.edit();
                editeur.putString("LoginUser",((EditText)findViewById(R.id.ETemail)).getText().toString());
                editeur.commit();
                Toast.makeText(this, "Login Sauvé", Toast.LENGTH_LONG).show();
                Intent i = new Intent(EZMeal.this, Menu.class);
                startActivity(i);
            }
            else{
                Toast tryAgain = Toast.makeText(EZMeal.this , "Mauvais mot de passe ou login..." , Toast.LENGTH_SHORT);
                tryAgain.show();
            }
        }

        if(v.getId() == R.id.bSinscrire){  //ok
            Intent g = new Intent(EZMeal.this, Inscription.class); //changement d'activity
            startActivity(g);
        }
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
