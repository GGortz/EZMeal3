package be.lsinf1225.ezmeal;

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

public class Compte extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DBHelper manager = new DBHelper(this);
    ArrayAdapter adapter3;
    Spinner spinner3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte);


        //Mettre toutes les infos de l'utilisateur dans les champs pour qu'il puisse les modifier
        SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String email = sharedInfo.getString("userEmail", "userEmail not found");    //changer en login
        String login = sharedInfo.getString("loginuser",null);  //changer null en login du user


        String loginn = manager.searchData(login, "Login");   //login
        EditText txtlogin = (EditText) findViewById(R.id.MCLogin);
        txtlogin.setText(loginn);

        int jour = Integer.parseInt(manager.searchData(login, "Jour"));  //jour de naissance
        EditText txtjour = (EditText) findViewById(R.id.MCJour);
        txtjour.setText(jour);

        int mois = Integer.parseInt(manager.searchData(login, "Mois"));  //Mois de naissance
        EditText txtmois = (EditText) findViewById(R.id.MCMois);
        txtmois.setText(mois);

        int annnee = Integer.parseInt(manager.searchData(login, "Annee"));  //Annee de naissance
        EditText txtannee = (EditText) findViewById(R.id.MCAnnee);
        txtannee.setText(annnee);

        String mdp = manager.searchData(login, "Password");  //mdp
        EditText txtmdp = (EditText) findViewById(R.id.MCMDP);
        txtmdp.setText(mdp);

        String confirm = manager.searchData(login, "Password");  //mdp confirmer
        EditText txtconfirm = (EditText) findViewById(R.id.MCConfirmer);
        txtconfirm.setText(confirm);


        //PARTIE SPINNER

        adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner3, android.R.layout.simple_spinner_dropdown_item);
        spinner3 = (Spinner) findViewById(R.id.SPsexe);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Compte.this);

        String sexe = manager.searchData(login, "Sexe");
        spinner3.setSelection(adapter3.getPosition(sexe));

        String pays = manager.searchData(login, "Pays");  //Pays
        EditText txtpays = (EditText) findViewById(R.id.MCPays);
        txtpays.setText(pays);

        String ville = manager.searchData(login, "Ville");  //Ville
        EditText txtville = (EditText) findViewById(R.id.MCVille);
        txtville.setText(ville);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void onBtnClick(View v) {
        if (v.getId() == R.id.MCMenu) {
            Intent retour = new Intent(Compte.this, Menu.class); //On revient au menu principal
            startActivity(retour);
        }


        if (v.getId() == R.id.MCEnregistrer){

            TextView login = (EditText)findViewById(R.id.MCLogin);  //login
            TextView jour = (EditText)findViewById(R.id.MCJour);  //jour de naissance
            TextView ville = (EditText)findViewById(R.id.MCVille);  //ville
            TextView password = (EditText)findViewById(R.id.MCMDP);  //mot de passe
            TextView confirmer = (EditText)findViewById(R.id.MCConfirmer);  //confirmer
            TextView mois = (EditText)findViewById(R.id.MCMois);  //mois de naissance
            TextView annee = (EditText)findViewById(R.id.MCAnnee);  //annee de naissance
            TextView pays = (EditText)findViewById(R.id.MCPays);  //pays

            String loginstr = login.getText().toString();  //login
            int jourstr = Integer.parseInt(jour.getText().toString());  //jour de naissance
            int anneestr = Integer.parseInt(annee.getText().toString());  //anne de naissance
            int moisstr = Integer.parseInt(mois.getText().toString());  //mois de naissance
            String villestr = ville.getText().toString();  //ville
            String passwordstr = password.getText().toString();  //mdp
            String confirmerstr = confirmer.getText().toString();  //mdpconfirmer
            String paysstr = pays.getText().toString();  //pays

            if(!passwordstr.equals(confirmerstr)){  //si les 2 mdp ne sont pas Ã©gaux.
                Toast mdp = Toast.makeText(Compte.this , "Les Mots de passe ne correspondent pas!" , Toast.LENGTH_SHORT);
                mdp.show();
            }
            else{  //si les mdp sont les memes
                Utilisateur u = new Utilisateur();
                u.setLogin(loginstr);  //login
                u.setMois(moisstr);  //mois
                u.setAnnee(anneestr);  //annee
                u.setPays(paysstr); //pays
                u.setJour(jourstr);  //jour
                u.setVille(villestr); //ville
                u.setMdp(passwordstr);  //mdp
                String sexestr = spinner3.getItemAtPosition(spinner3.getSelectedItemPosition()).toString();
                u.setSexe(sexestr);  //sexe


                //on a besoin du login  //changer en login
                SharedPreferences info = getSharedPreferences("InfoUser", 0);
                String loginu = info.getString("LoginUser", "0");

                //manager.updateUser(u, loginu);

                Intent gh = new Intent(Compte.this, Menu.class); //changement d'activity
                startActivity(gh);
            }

        }

    }


}


/*
















package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by elthe on 24-04-17.
 */
/*
public class UserInfo extends Defin implements AdapterView.OnItemSelectedListener {

    DBHelper myManager = new DBHelper(this);

    ArrayAdapter adapter;
    Spinner spinner1;
    ArrayAdapter adapter2;
    Spinner spinner2;
    ArrayAdapter adapter3;
    Spinner spinner3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte);


        //mettre toutes les infos de l'utilisateur dans les champs pour qu'il puisse les modifier
        SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String emailDeUser = sharedInfo.getString("userEmail", "userEmail not found");
       // EditText bjt = (EditText) findViewById(R.id.ETprenom);
       // bjt.setText(emailDeUser);


        String prenomFromBDD = myManager.searchData(emailDeUser, "prenom");
        EditText prenom = (EditText) findViewById(R.id.ETprenom);
        prenom.setText(prenomFromBDD);

        String nomFromBDD = myManager.searchData(emailDeUser, "nom");
        EditText nom = (EditText) findViewById(R.id.ETnom);
        nom.setText(nomFromBDD);

        String ageFromBDD = myManager.searchData(emailDeUser, "age");
        EditText age = (EditText) findViewById(R.id.ETage);
        age.setText(ageFromBDD);

        //String emailFuck = sharedInfo.getString("userEmail", "userEmail not found");
        //String emailFromBDD = myManager.searchData(emailDeUser, "email");
        //EditText email = (EditText) findViewById(R.id.ETemail);
        //email.setText(emailDeUser);

        String mdpFromBDD = myManager.searchData(emailDeUser, "mdp");
        EditText mdp = (EditText) findViewById(R.id.ETmdp);
        mdp.setText(mdpFromBDD);

        String confirmerFromBDD = myManager.searchData(emailDeUser, "mdp");
        EditText confirmer = (EditText) findViewById(R.id.ETconfirmer);
        confirmer.setText(mdpFromBDD);

        //PARTIE SPINNER
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_dropdown_item);
        spinner1 = (Spinner) findViewById(R.id.SPlangue);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) UserInfo.this);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner2, android.R.layout.simple_spinner_dropdown_item);
        spinner2 = (Spinner) findViewById(R.id.SPnationalite);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) UserInfo.this);

        adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner3, android.R.layout.simple_spinner_dropdown_item);
        spinner3 = (Spinner) findViewById(R.id.SPsexe);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) UserInfo.this);

        String langueFromBDD = myManager.searchData(emailDeUser, "langue");
        spinner1.setSelection(adapter.getPosition(langueFromBDD));

        String nationnaliteFromBDD = myManager.searchData(emailDeUser, "nationnalite");
        spinner2.setSelection(adapter2.getPosition(nationnaliteFromBDD));

        String sexeFromBDD = myManager.searchData(emailDeUser, "sexe");
        spinner3.setSelection(adapter3.getPosition(sexeFromBDD));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void onBtnClick(View v) {
        if (v.getId() == R.id.bMenu) {
            Intent gh = new Intent(UserInfo.this, Menu.class); //changement d'activity
            startActivity(gh);
        }


        if (v.getId() == R.id.bEnregistrer){
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
            }

        }

    }


}
*/