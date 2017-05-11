package be.lsinf1225.ezmeal;

import android.app.AlertDialog;
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
        setContentView(R.layout.activity_main);

    }


    //Click sur le bouton Menu pr chts de activity
    public void onBtnClick(View v){


        if(v.getId() == R.id.bLogin){


            EditText e = (EditText)findViewById(R.id.ETemail); //on choppe ce qui est mit dans le field login
            String stre = e.getText().toString(); //et on le transfo en String

            EditText f = (EditText)findViewById(R.id.ETmdp); //on choppe ce qui est mit dans le field mdp
            String strf = f.getText().toString(); //et on le transfo en String
            //on regarde si le login et le mdp correspondent dans la bdd
            String mdp = manager.searchMdp(stre);
            showMessage(stre, stre);
            //if(true){
            if(strf.equals(mdp)){
                //On enregisre le Login de l'utilisateur afin de savoir acceder a ses donnees
                SharedPreferences info = getSharedPreferences("InfoUser",0);
                SharedPreferences.Editor editeur = info.edit();
                editeur.putString("LoginUser",((EditText)findViewById(R.id.ETemail)).getText().toString());//changer Email
                editeur.apply();

                Toast.makeText(this, "Login Sauvé", Toast.LENGTH_LONG).show();

                //changement d'activity
                Intent i = new Intent(MainActivity.this, Menu.class);
                startActivity(i);
            }
            else{
                Toast tryAgain = Toast.makeText(MainActivity.this , "Mauvais mot de passe ou email..." , Toast.LENGTH_SHORT);
                tryAgain.show();
            }

        }


        if(v.getId() == R.id.bSinscrire){  //ok
            Intent g = new Intent(MainActivity.this, Inscription.class); //changement d'activity
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
