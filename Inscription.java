package be.lsinf1225.ezmeal;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
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

public class Inscription extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    DBHelper manager;
    ArrayAdapter adapter3;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinscrire);
        manager = new DBHelper(this);

        //spinner du sexe
        adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner3, android.R.layout.simple_spinner_dropdown_item);
        spinner3 = (Spinner) findViewById(R.id.SPsexe);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Inscription.this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);
        ((TextView) parent.getChildAt(0)).setTextSize(20);

        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.SPsexe)
        {
            TextView spinnerSelected = (TextView) view;
            //Toast.makeText(this, "hello  sexe", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //on en a besoin car on implémente OnItemSlectedListener
    }

    public void onBtnClick(View v){
        if(v.getId() == R.id.bSinscrireForm){
            //add sexe
            TextView prenom = (EditText)findViewById(R.id.ETprenom);  //login
            //TextView nom = (EditText)findViewById(R.id.ETnom);
            TextView age = (EditText)findViewById(R.id.ETage);  //jour de naissance
            TextView email = (EditText)findViewById(R.id.ETemail);  //ville
            TextView password = (EditText)findViewById(R.id.ETmdp);  //mot de passe
            TextView confirmer = (EditText)findViewById(R.id.ETconfirmer);  //confirmer
            TextView mois = (EditText)findViewById(R.id.ETmois);  //mois de naissance
            TextView annee = (EditText)findViewById(R.id.ETannee);  //annee de naissance
            TextView pays = (EditText)findViewById(R.id.ETpays);  //pays

            String prenomstr = prenom.getText().toString();  //login
            //String nomstr = nom.getText().toString();  //
            int agestr = Integer.parseInt(age.getText().toString());  //jour de naissance
            int anneestr = Integer.parseInt(annee.getText().toString());  //anne de naissance
            int moisstr = Integer.parseInt(mois.getText().toString());  //mois de naissance
            String emailstr = email.getText().toString();  //ville
            String passwordstr = password.getText().toString();  //mdp
            String confirmerstr = confirmer.getText().toString();  //mdpconfirmer
            String paysstr = pays.getText().toString();  //pays



            if(!passwordstr.equals(confirmerstr)){  //si les 2 mdp ne sont pas égaux.
                Toast mdp = Toast.makeText(Inscription.this , "Les Mots de passe ne correspondent pas!" , Toast.LENGTH_SHORT);
                mdp.show();
            }
            else{  //si les mdps sont égaux, on crée un user
                Utilisateur u = new Utilisateur();
                u.setLogin(prenomstr);  //login
                u.setMois(moisstr);  //mois
                u.setAnnee(anneestr);  //annee
                u.setPays(paysstr); //pays
                u.setJour(agestr);  //age
                u.setVille(emailstr); //ville
                u.setMdp(passwordstr);  //mdp
                String sexestr = spinner3.getItemAtPosition(spinner3.getSelectedItemPosition()).toString();
                u.setSexe(sexestr);  //sexe
                showMessage(prenomstr+moisstr+anneestr+paysstr+sexestr+passwordstr, Integer.toString(moisstr));
                //manager.insertUser(u);
                showMessage("Apres", "Insert");
                Intent h = new Intent(Inscription.this, Menu.class); //changement d'activity
                startActivity(h);
            }



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
