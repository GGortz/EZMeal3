package be.lsinf1225.ezmeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gaetan on 11/05/2017.
 */

public class Compte extends AppCompatActivity {

    DBHelper manager = new DBHelper(this);
    ArrayAdapter adapter3;
    Spinner spinner3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte);


        //Mettre toutes les infos de l'utilisateur dans les champs pour qu'il puisse les modifier
        SharedPreferences info = getPreferences(Context.MODE_PRIVATE);
        String login = info.getString("LoginUser", "Martin");  //changer null en login du user
        showMessage(login, login);

        String loginn = manager.searchData(login, "Login");   //login
        //String loginn = "login";
        EditText txtlogin = (EditText) findViewById(R.id.MCLogin);
        txtlogin.setText(loginn);

        String jour = manager.searchData(login, "Jour");  //jour de naissance
        //String jour = "26";
        EditText txtjour = (EditText) findViewById(R.id.MCJour);
        txtjour.setText(jour);

        String mois = manager.searchData(login, "Mois");  //Mois de naissance
        //String mois = "06";
        EditText txtmois = (EditText) findViewById(R.id.MCMois);
        txtmois.setText(mois);

        String annnee = manager.searchData(login, "Annee");  //Annee de naissance
        //String annnee = "1997";
        EditText txtannee = (EditText) findViewById(R.id.MCAnnee);
        txtannee.setText(annnee);

        String mdp = manager.searchData(login, "Password");  //mdp
        //String mdp = "GG";
        EditText txtmdp = (EditText) findViewById(R.id.MCMDP);
        txtmdp.setText(mdp);

        String confirm = manager.searchData(login, "Password");  //mdp confirmer
        //String confirm = "GG";
        EditText txtconfirm = (EditText) findViewById(R.id.MCConfirmer);
        txtconfirm.setText(confirm);


        String pays = manager.searchData(login, "Pays");  //Pays
        //String pays = "Belgique";
        EditText txtpays = (EditText) findViewById(R.id.MCPays);
        txtpays.setText(pays);

        String ville = manager.searchData(login, "Ville");  //Ville
        //String ville = "Ath";
        EditText txtville = (EditText) findViewById(R.id.MCVille);
        txtville.setText(ville);

    }

    public void onBtnClick(View v) {
        if (v.getId() == R.id.MCMenu) {
            Intent gh = new Intent(Compte.this, Menu.class); //changement d'activity
            startActivity(gh);
        }


        if (v.getId() == R.id.MCEnregistrer){
            showMessage("Non développé", "");
        }
        /*
            //add langue
            //add nationalité
            //add sexe
            TextView prenom = (EditText)findViewById(R.id.ETprenom);
            TextView nom = (EditText)findViewById(R.id.ETnom);
            TextView age = (EditText)findViewById(R.id.ETage);
            //TextView email = (EditText)findViewById(R.id.ETemail);
            TextView password = (EditText)findViewById(R.id.ETmdp);
            TextView confirmer = (EditText)findViewById(R.id.ETconfirmer);

            String prenomstr = prenom.getText().toString();
            String nomstr = nom.getText().toString();
            String agestr = age.getText().toString();
            //String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String confirmerstr = confirmer.getText().toString();

            if(!passwordstr.equals(confirmerstr)){  //si les 2 mdp ne sont pas égaux.
                Toast mdp = Toast.makeText(UserInfo.this , "Les Mots de passe ne correspondent pas!" , Toast.LENGTH_SHORT);
                mdp.show();
            }
            else{
                User uMod = new User();
                uMod.setPrenom(prenomstr);
                uMod.setNom(nomstr);
                uMod.setAge(agestr);
                //uMod.setEmail(emailstr);
                uMod.setMdp(passwordstr);


                String nationnalitestr = spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString();
                uMod.setNationnalite(nationnalitestr);
                String languestr = spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString();
                uMod.setLangue(languestr);
                String sexestr = spinner3.getItemAtPosition(spinner3.getSelectedItemPosition()).toString();
                uMod.setSexe(sexestr);


                //on a besoin de l'email pour savoir quel utilisateur updater
                SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String emailDeUser = sharedInfo.getString("userEmail", "userEmail not found");

                myManager.updateUser(uMod, emailDeUser);

                Intent gh = new Intent(UserInfo.this, Menu.class); //changement d'activity
                startActivity(gh);
                */
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