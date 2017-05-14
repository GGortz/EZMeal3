package be.lsinf1225.ezmeal;

/**
 * Created by Gaetan on 11/05/2017.
 */

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1; //version de la DB  (136 old)
    private static final String DATABASE_NAME = "DB.db";  //nom de la db

    //Table d'utilisateur
    private static final String TABLE_NAME = "Utilisateur";
    private static final String COLUMN_LOGIN = "Login";
    private static final String COLUMN_PASSWORD = "Password";
    private static final String COLUMN_CITY = "Ville";
    private static final String COLUMN_COUNTRY = "Pays";
    private static final String COLUMN_SEXE = "Sexe";
    private static final String COLUMN_JOUR = "Jour";
    private static final String COLUMN_MOIS = "Mois";
    private static final String COLUMN_ANNEE = "Annee";

    //private static final String TABLE_CREATE = "CREATE TABLE" + TABLE_NAME;

    //Table de recette
    private static final String TABLE_NAME2 = "Recette";
    private static final String COLUMN_NOMR = "NomR";
    private static final String COLUMN_TPREPARATION = "Tpreparation";
    private static final String COLUMN_TCUISSON = "Tcuisson";
    private static final String COLUMN_NUMR1 = "NumR";
    private static final String COLUMN_NCOUV = "NbreCouv";
    private static final String COLUMN_DESCRIPTION = "Description";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_DIFFICULTE = "Difficulte";
    private static final String COLUMN_COUT = "Cout";
    private static final String COLUMN_PHOTO = "Photo";
    private static final String COLUMN_TYPE = "Type";
    private static final String COLUMN_CHAUD = "Chaud_froid";
    private static final String COLUMN_AUTEUR = "Auteur";


    //Table des catÃ©gories, sous-catÃ©gories
    private static final String TABLE_NAME3 = "Categorie";
    private static final String COLUMN_CAT = "Categorie";
    private static final String COLUMN_SCAT1 = "Souscategorie";

    //Table des ingrÃ©dients
    private static final String TABLE_NAME4 = "Ingredient";
    private static final String COLUMN_INGREDIENT1 = "Ingredient";
    private static final String COLUMN_SCAT2 = "Souscategorie";


    //Table des quantites par recette
    private static final String TABLE_NAME5 = "Tquantite";
    private static final String COLUMN_INGREDIENT2 = "Ingredient";
    private static final String COLUMN_QUANTITE = "Quantite";
    private static final String COLUMN_NUMR2 = "NumR";


    //Table des etapes par recette
    private static final String TABLE_NAME6 = "Tetape";
    private static final String COLUMN_NUMR3 = "NumR";
    private static final String COLUMN_NETAPE = "Netape";
    private static final String COLUMN_ACTION = "Action";


    //Table des reviews par recette
    private static final String TABLE_NAME7 = "Review";
    private static final String COLUMN_USER = "User";
    private static final String COLUMN_NUMR4 = "NumR";
    private static final String COLUMN_DATE2 = "Date";
    private static final String COLUMN_NOTE = "Note";
    private static final String COLUMN_COMMENT = "Commentaire";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        //CrÃ©ation de la table utilisateur, qui est initialement vide
        String queryB = "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_LOGIN + " VARCHAR(255) PRIMARY KEY, " +
                COLUMN_PASSWORD + " VARCHAR(255), " +
                COLUMN_CITY + " VARCHAR(255), " +
                COLUMN_COUNTRY + " VARCHAR(255), " +
                COLUMN_SEXE + " VARCHAR(255), " +
                COLUMN_JOUR + " INTEGER, " +
                COLUMN_MOIS + " INTEGER, " +
                COLUMN_ANNEE + " INTEGER " +
                ");";
        db.execSQL(queryB);

        db.execSQL("INSERT INTO Utilisateur ('Login', 'Password', 'Ville', 'Pays', 'Sexe', 'Jour', 'Mois', 'Annee') " + "VALUES ('Martin', 'Martin', 'Louvain', 'Belgique', 'Homme', 10, 02, 1996)");


        //CrÃ©ation de la table recettes
        String query = "CREATE TABLE " + TABLE_NAME2 + "(" +
                COLUMN_NOMR + " VARCHAR(255), " +
                COLUMN_TPREPARATION + " INTEGER, " +
                COLUMN_TCUISSON + " INTEGER, " +
                COLUMN_NUMR1 + " INTEGER PRIMARY KEY, " +
                COLUMN_NCOUV + " INTEGER, " +
                COLUMN_DESCRIPTION + " VARCHAR(255), " +
                COLUMN_DATE + " VARCHAR(255), " +
                COLUMN_DIFFICULTE + " VARCHAR(255), " +
                COLUMN_COUT + " VARCHAR(255), " +
                COLUMN_PHOTO + " VARCHAR(255), " +
                COLUMN_TYPE + " VARCHAR(255), " +
                COLUMN_CHAUD + " VARCHAR(255), " +
                COLUMN_AUTEUR + " VARCHAR(255) " +
                ");";
        db.execSQL(query);


        //CrÃ©ation de la table des categories
        String queryC = "CREATE TABLE " + TABLE_NAME3 + "(" +
                COLUMN_CAT + " VARCHAR(255), " +
                COLUMN_SCAT1 + " VARCHAR(255) " +
                ");";
        db.execSQL(queryC);



        ContentValues champi = new ContentValues();
        champi.put(COLUMN_INGREDIENT1, "Champignon de Paris");
        champi.put(COLUMN_SCAT2, "Champignon");
        db.insert(TABLE_NAME4, null, champi);
        ContentValues volaille = new ContentValues();
        volaille.put(COLUMN_CAT, "Viande");
        volaille.put(COLUMN_SCAT1, "Volaille");
        db.insert(TABLE_NAME3, null, volaille);
        ContentValues veau = new ContentValues();
        veau.put(COLUMN_CAT, "Viande");
        veau.put(COLUMN_SCAT1, "Veau");
        db.insert(TABLE_NAME3, null, veau);
        ContentValues gras = new ContentValues();
        gras.put(COLUMN_CAT, "Poisson");
        gras.put(COLUMN_SCAT1, "Gras");
        db.insert(TABLE_NAME3, null, gras);
        ContentValues rouge = new ContentValues();
        rouge.put(COLUMN_CAT, "Fruit");
        rouge.put(COLUMN_SCAT1, "Rouge");
        db.insert(TABLE_NAME3, null, rouge);
        ContentValues eau = new ContentValues();
        eau.put(COLUMN_CAT, "Boisson");
        eau.put(COLUMN_SCAT1, "Eau");
        db.insert(TABLE_NAME3, null, eau);
        ContentValues Pouletchampi = new ContentValues();
        Pouletchampi.put(COLUMN_NOMR, "Poulet aux champignons");
        Pouletchampi.put(COLUMN_TPREPARATION, 10);
        Pouletchampi.put(COLUMN_TCUISSON, 30);
        Pouletchampi.put(COLUMN_NUMR1, 1);
        Pouletchampi.put(COLUMN_NCOUV, 4);
        Pouletchampi.put(COLUMN_DESCRIPTION, "Très bon repas passe partout. Beaucoup de succès avec les enfants");
        Pouletchampi.put(COLUMN_DATE, "05/03/2017");
        Pouletchampi.put(COLUMN_DIFFICULTE, "Moyen");
        Pouletchampi.put(COLUMN_COUT, "Moyen");
        Pouletchampi.put(COLUMN_PHOTO, "imgPoulet");
        Pouletchampi.put(COLUMN_TYPE, "Principal");
        Pouletchampi.put(COLUMN_CHAUD, 1);
        Pouletchampi.put(COLUMN_AUTEUR, "Admin");
        db.insert(TABLE_NAME2, null, Pouletchampi);
        ContentValues pouletchampi2 = new ContentValues();
        pouletchampi2.put(COLUMN_QUANTITE, "4 cuisses");
        pouletchampi2.put(COLUMN_NUMR2, 1);
        pouletchampi2.put(COLUMN_INGREDIENT2, "Poulet");
        db.insert(TABLE_NAME5, null, pouletchampi2);
        ContentValues pouletchampi3 = new ContentValues();
        pouletchampi3.put(COLUMN_QUANTITE, "150g");
        pouletchampi3.put(COLUMN_NUMR2, 1);
        pouletchampi3.put(COLUMN_INGREDIENT2, "Champignons de Paris");
        db.insert(TABLE_NAME5, null, pouletchampi3);
        ContentValues pouletchampi4 = new ContentValues();
        pouletchampi4.put(COLUMN_QUANTITE, "1");
        pouletchampi4.put(COLUMN_NUMR2, 1);
        pouletchampi4.put(COLUMN_INGREDIENT2, "Oignon");
        db.insert(TABLE_NAME5, null, pouletchampi4);
        ContentValues pouletchampi5 = new ContentValues();
        db.insert(TABLE_NAME3, null, pouletchampi5);
        ContentValues pouletchampi6 = new ContentValues();
        pouletchampi6.put(COLUMN_CAT, "Légume");
        pouletchampi6.put(COLUMN_SCAT1, "Gousse");
        db.insert(TABLE_NAME3, null, pouletchampi6);
        ContentValues pouletchampi7 = new ContentValues();
        db.insert(TABLE_NAME3, null, pouletchampi7);
        ContentValues pouletchampi9 = new ContentValues();
        pouletchampi9.put(COLUMN_INGREDIENT1, "Oignon");
        pouletchampi9.put(COLUMN_SCAT1, "Gousse");
        db.insert(TABLE_NAME4, null, pouletchampi9);
        ContentValues pouletchampi10 = new ContentValues();
        pouletchampi10.put(COLUMN_INGREDIENT1, "Poulet");
        pouletchampi10.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, pouletchampi10);
        ContentValues pomme = new ContentValues();
        pomme.put(COLUMN_INGREDIENT1, "Pomme");
        pomme.put(COLUMN_SCAT2, "Rouge");
        db.insert(TABLE_NAME4, null, pomme);




        //CrÃ©ation de la table des ingredients
        String queryD = "CREATE TABLE " + TABLE_NAME4 + "(" +
                COLUMN_INGREDIENT1 + " VARCHAR(255) PRIMARY KEY, " +
                COLUMN_SCAT2 + " VARCHAR(255) " +
                ");";
        db.execSQL(queryD);

        //CrÃ©ation de la table quantite par recette
        String queryE = "CREATE TABLE " + TABLE_NAME5 + "(" +
                COLUMN_NUMR2 + " VARCHAR(255), " +
                COLUMN_INGREDIENT2 + " VARCHAR(255), " +
                COLUMN_QUANTITE + " VARCHAR(255) " +
                ");";
        db.execSQL(queryE);

        //CrÃ©ation de la table etape par recette
        String queryF = "CREATE TABLE " + TABLE_NAME6 + "(" +
                COLUMN_NUMR3 + " INTEGER, " +
                COLUMN_NETAPE + " INTEGER, " +
                COLUMN_ACTION + " VARCHAR(255) " +
                ");";
        db.execSQL(queryF);

        //CrÃ©ation de la table Review
        String queryG = "CREATE TABLE " + TABLE_NAME7 + "(" +
                COLUMN_USER + " VARCHAR(255), " +
                COLUMN_NUMR4 + " INTEGER, " +
                COLUMN_DATE2 + " VARCHAR(255), " +
                COLUMN_NOTE + " INTEGER, " +
                COLUMN_COMMENT + " VARCHAR(255) " +
                ");";
        db.execSQL(queryG);
    }


    //Création de InsertUser    //NUPLOAD PAS DANS LA DB
    public void insertUser(Utilisateur u){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOGIN, u.getLogin());  //login
        values.put(COLUMN_PASSWORD, u.getMdp());  //mdp
        values.put(COLUMN_CITY, u.getVille());    //ville
        values.put(COLUMN_COUNTRY, u.getPays());  //pays
        values.put(COLUMN_SEXE, u.getSexe());  //sexe
        values.put(COLUMN_JOUR, u.getJour());  //jour
        values.put(COLUMN_MOIS, u.getMois());  //mois
        values.put(COLUMN_ANNEE, u.getAnnee());  //annee
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    //Création de searchMpd()   Récupérer le mot de passe de l'utilisateur  SEULEMENT SI ECRIT AVEC db.execSQL
    public String searchMdp(String login){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Login, Password from "+TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        String x, y;
        y = "Pas trouvé";
        if(c.moveToFirst()){
            do{
                x = c.getString(c.getColumnIndex(COLUMN_LOGIN));
                if(x.equals(login)){
                    y = c.getString(c.getColumnIndex(COLUMN_PASSWORD));
                    break;
                }
            }
            while(c.moveToNext());
        }
        c.close();
        return y;
    }


    //Search une donnée de l'utilisateur grâce à son login
    public String searchData(String login, String dataColumn){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT Login, " + dataColumn +" FROM "+TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        String x, y;
        y = "NOT FOUND";
        if(c.moveToFirst()){
            do{
                x = c.getString(c.getColumnIndex(COLUMN_LOGIN));

                if(x.equals(login)){
                    y = c.getString(c.getColumnIndex(dataColumn));
                    break;
                }
            }
            while(c.moveToNext());
        }
        c.close();
        return y;
    }

    //On recherche des données liées à une recette identifiée par son ID
    public String searchData2(int id, String dataColumn){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NumR, " + dataColumn +" FROM "+TABLE_NAME2;
        Cursor cu = db.rawQuery(query, null);
        int x;
        String y;
        y = "NOT FOUND";
        if(cu.moveToFirst()){
            do{
                x = cu.getInt(cu.getColumnIndex(COLUMN_NUMR1));
                if(x==id){
                    y = cu.getString(cu.getColumnIndex(dataColumn));
                    break;
                }
            }
            while(cu.moveToNext());
        }
        cu.close();
        return y;
    }

    //Création d'un arraylist qui contient les titres de toutes les recettes pour le catalogue
    public ArrayList<String> getRecetteArray(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NomR FROM " + TABLE_NAME2;
        Cursor c = db.rawQuery(query, null);
        ArrayList<String> listData = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            listData.add(c.getString(c.getColumnIndex(COLUMN_NOMR)));
            c.moveToNext();
        }
        c.close();
        return listData;
    }

    //Création d'un arraylist qui contient les titres des recettes en fct d'un des ingredients présents
    public ArrayList<String> getRecetteIngredient(String ingre){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NomR FROM Recette WHERE NomR, Tquantite WHERE Tquantite.Ingredient == '"+ingre+"' AND Recette.NumR == Tquantite.NumR";   //a verifier
        Cursor c = db.rawQuery(query, null);
        ArrayList<String> listRecette = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            listRecette.add(c.getString(c.getColumnIndex(COLUMN_NOMR)));
            c.moveToNext();
        }
        c.close();
        return listRecette;
    }

    //Création d'un arraylist qui contient les ingrédient appartenant a une sous-categorie sc
    public ArrayList<String> getIngredientSC(String sc){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> listIngredientSC = new ArrayList<String>();
        String query = "SELECT "+COLUMN_INGREDIENT1+" FROM "+TABLE_NAME4+" WHERE "+COLUMN_SCAT2+" == '"+sc+"'";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            listIngredientSC.add(c.getString(c.getColumnIndex(COLUMN_INGREDIENT1)));
            c.moveToNext();
        }
        c.close();
        return listIngredientSC;

    }

    //Création d'un arraylist qui contient les sous-categories d'une catégorie passée en argument
    public ArrayList<String> getSousCategorie(String categorie){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> listesouscategorie = new ArrayList<String>();
        String query = "SELECT "+COLUMN_SCAT1+" FROM "+TABLE_NAME3+" WHERE "+COLUMN_CAT+" == '"+categorie+"'";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            listesouscategorie.add(c.getString(c.getColumnIndex(COLUMN_SCAT1)));
            c.moveToNext();
        }
        c.close();
        return listesouscategorie;
    }


    //Création d'un arraylist qui contient les catégories

    public ArrayList<String> getCategorie(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> listecategorie = new ArrayList<String>();
        String query = "SELECT DISTINCT "+COLUMN_CAT+" FROM "+TABLE_NAME3;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            listecategorie.add(c.getString(0));   //c.getString(0)
            c.moveToNext();
        }
        c.close();
        return listecategorie;



    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // delete the existing database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6);
        db.execSQL("DROP TABLE IF EXITS  " + TABLE_NAME7);
        onCreate(db);

    }


}



