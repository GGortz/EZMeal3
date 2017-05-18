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

    private static final int DATABASE_VERSION = 1; //version de la DB
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


    //Table des catégories, sous-catégories
    private static final String TABLE_NAME3 = "Categories";
    private static final String COLUMN_CAT = "Categorie";
    private static final String COLUMN_SCAT1 = "Souscategories";

    //Table des ingrédients
    private static final String TABLE_NAME4 = "Ingredients";
    private static final String COLUMN_INGREDIENT1 = "Ingredient";
    private static final String COLUMN_SCAT2 = "Souscategorie";


    //Table des quantites par recette
    private static final String TABLE_NAME5 = "Tquantite";
    private static final String COLUMN_INGREDIENT2 = "Ingredientt2";
    private static final String COLUMN_QUANTITE = "Quantite";
    private static final String COLUMN_NUMR2 = "NumR2";


    //Table des etapes par recette
    private static final String TABLE_NAME6 = "Tetape";
    private static final String COLUMN_NUMR3 = "NumR3";
    private static final String COLUMN_NETAPE = "Netape";
    private static final String COLUMN_ACTION = "Action";


    //Table des reviews par recette
    private static final String TABLE_NAME7 = "Review";
    private static final String COLUMN_USER = "User";
    private static final String COLUMN_NUMR4 = "NumR4";
    private static final String COLUMN_DATE2 = "Date";
    private static final String COLUMN_NOTE = "Note";
    private static final String COLUMN_COMMENT = "Commentaire";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Création de la table utilisateur
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

        //Ajout d'un utilisateur
        db.execSQL("INSERT INTO Utilisateur ('Login', 'Password', 'Ville', 'Pays', 'Sexe', 'Jour', 'Mois', 'Annee') " + "VALUES ('Martin', 'Martin', 'Louvain', 'Belgique', 'Homme', 10, 02, 1996)");


        //Création de la table recettes
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

        //Ajout de quelque recette

        ContentValues recette1 = new ContentValues();
        recette1.put(COLUMN_NOMR, "Poulet aux champignons");
        recette1.put(COLUMN_TPREPARATION, 10);
        recette1.put(COLUMN_TCUISSON, 30);
        recette1.put(COLUMN_NUMR1, 1);
        recette1.put(COLUMN_NCOUV, 4);
        recette1.put(COLUMN_DESCRIPTION, "Très bon repas passe partout. Beaucoup de succès avec les enfants");
        recette1.put(COLUMN_DATE, "05/03/2017");
        recette1.put(COLUMN_DIFFICULTE, "Moyen");
        recette1.put(COLUMN_PHOTO, "r1");
        recette1.put(COLUMN_TYPE, "Principal");
        recette1.put(COLUMN_AUTEUR, "Admin");
        recette1.put(COLUMN_COUT, "Moyen");
        db.insert(TABLE_NAME2, null, recette1);



        //Création de la table des categories
        String queryC = "CREATE TABLE " + TABLE_NAME3 + "(" +
                COLUMN_CAT + " VARCHAR(255), " +
                COLUMN_SCAT1 + " VARCHAR(255) " +
                ");";
        db.execSQL(queryC);

        //Ajout de quelque catégorie
        ContentValues cate1 = new ContentValues();
        cate1.put(COLUMN_CAT, "Viande");
        cate1.put(COLUMN_SCAT1, "Volaille");
        db.insert(TABLE_NAME3, null, cate1);
        ContentValues cate2 = new ContentValues();
        cate2.put(COLUMN_CAT, "Viande");
        cate2.put(COLUMN_SCAT1, "Blanche");
        db.insert(TABLE_NAME3, null, cate2);
        ContentValues cate3 = new ContentValues();
        cate3.put(COLUMN_CAT, "Viande");
        cate3.put(COLUMN_SCAT1, "Gibier");
        db.insert(TABLE_NAME3, null, cate3);
        ContentValues cate4 = new ContentValues();
        cate4.put(COLUMN_CAT, "Viande");
        cate4.put(COLUMN_SCAT1, "Rouge");
        db.insert(TABLE_NAME3, null, cate4);
        ContentValues cate5 = new ContentValues();
        cate5.put(COLUMN_CAT, "Légume");
        cate5.put(COLUMN_SCAT1, "Vert");
        db.insert(TABLE_NAME3, null, cate5);
        ContentValues cate6 = new ContentValues();
        cate6.put(COLUMN_CAT, "Fruits");
        cate6.put(COLUMN_SCAT1, "Exotiques");
        db.insert(TABLE_NAME3, null, cate6);
        ContentValues cate7 = new ContentValues();
        cate7.put(COLUMN_CAT, "Fruits");
        cate7.put(COLUMN_SCAT1, "Pépins");
        db.insert(TABLE_NAME3, null, cate7);
        ContentValues cate8 = new ContentValues();
        cate8.put(COLUMN_CAT, "Fruits");
        cate8.put(COLUMN_SCAT1, "Noyaux");
        db.insert(TABLE_NAME3, null, cate8);
        ContentValues cate9 = new ContentValues();
        cate9.put(COLUMN_CAT, "Fruits");
        cate9.put(COLUMN_SCAT1, "Agrumes");
        db.insert(TABLE_NAME3, null, cate9);
        ContentValues cate10 = new ContentValues();
        cate10.put(COLUMN_CAT, "Fruits");
        cate10.put(COLUMN_SCAT1, "Rouges");
        db.insert(TABLE_NAME3, null, cate10);
        ContentValues cate11 = new ContentValues();
        cate11.put(COLUMN_CAT, "Fruits");
        cate11.put(COLUMN_SCAT1, "Secs");
        db.insert(TABLE_NAME3, null, cate11);
        ContentValues cate12 = new ContentValues();
        cate12.put(COLUMN_CAT, "Fruits");
        cate12.put(COLUMN_SCAT1, "Autres");
        db.insert(TABLE_NAME3, null, cate12);
        ContentValues cate13 = new ContentValues();
        cate13.put(COLUMN_CAT, "Viande");
        cate13.put(COLUMN_SCAT1, "Charcuterie");
        db.insert(TABLE_NAME3, null, cate13);
        ContentValues cate14 = new ContentValues();
        cate14.put(COLUMN_CAT, "Viande");
        cate14.put(COLUMN_SCAT1, "Abat");
        db.insert(TABLE_NAME3, null, cate14);
        ContentValues cate15 = new ContentValues();
        cate15.put(COLUMN_CAT, "Fromage");
        cate15.put(COLUMN_SCAT1, "Frais");
        db.insert(TABLE_NAME3, null, cate15);
        ContentValues cate16 = new ContentValues();
        cate16.put(COLUMN_CAT, "Fromage");
        cate16.put(COLUMN_SCAT1, "Pate pressée");
        db.insert(TABLE_NAME3, null, cate16);
        ContentValues cate17 = new ContentValues();
        cate17.put(COLUMN_CAT, "Fromage");
        cate17.put(COLUMN_SCAT1, "Pate molle");
        db.insert(TABLE_NAME3, null, cate17);
        ContentValues cate18 = new ContentValues();
        cate18.put(COLUMN_CAT, "Fromage");
        cate18.put(COLUMN_SCAT1, "Pate persillée");
        db.insert(TABLE_NAME3, null, cate18);
        ContentValues cate19 = new ContentValues();
        cate19.put(COLUMN_CAT, "Fromage");
        cate19.put(COLUMN_SCAT1, "Chèvre");
        db.insert(TABLE_NAME3, null, cate19);
        ContentValues cate20 = new ContentValues();
        cate20.put(COLUMN_CAT, "Poisson");
        cate20.put(COLUMN_SCAT1, "Gras");
        db.insert(TABLE_NAME3, null, cate20);
        ContentValues cate21 = new ContentValues();
        cate21.put(COLUMN_CAT, "Poisson");
        cate21.put(COLUMN_SCAT1, "Mi gras");
        db.insert(TABLE_NAME3, null, cate21);
        ContentValues cate22 = new ContentValues();
        cate22.put(COLUMN_CAT, "Poisson");
        cate22.put(COLUMN_SCAT1, "Maigre");
        db.insert(TABLE_NAME3, null, cate22);
        ContentValues cate23 = new ContentValues();
        cate23.put(COLUMN_CAT, "Poisson");
        cate23.put(COLUMN_SCAT1, "Mollusque");
        db.insert(TABLE_NAME3, null, cate23);
        ContentValues cate24 = new ContentValues();
        cate24.put(COLUMN_CAT, "Poisson");
        cate24.put(COLUMN_SCAT1, "Crustacé");
        db.insert(TABLE_NAME3, null, cate24);
        ContentValues cate25 = new ContentValues();
        cate25.put(COLUMN_CAT, "Condiment");
        cate25.put(COLUMN_SCAT1, "Bulbe");
        db.insert(TABLE_NAME3, null, cate25);
        ContentValues cate26 = new ContentValues();
        cate26.put(COLUMN_CAT, "Condiment");
        cate26.put(COLUMN_SCAT1, "Plante");
        db.insert(TABLE_NAME3, null, cate26);
        ContentValues cate27 = new ContentValues();
        cate27.put(COLUMN_CAT, "Fruits");
        cate27.put(COLUMN_SCAT1, "Coques");
        db.insert(TABLE_NAME3, null, cate27);
        ContentValues cate28 = new ContentValues();
        cate28.put(COLUMN_CAT, "Charcuterie");
        cate28.put(COLUMN_SCAT1, "Haché");
        db.insert(TABLE_NAME3, null, cate28);
        ContentValues cate29 = new ContentValues();
        cate29.put(COLUMN_CAT, "Légume");
        cate29.put(COLUMN_SCAT1, "Racine");
        db.insert(TABLE_NAME3, null, cate29);
        ContentValues cate30 = new ContentValues();
        cate30.put(COLUMN_CAT, "Légume");
        cate30.put(COLUMN_SCAT1, "Champignon");
        db.insert(TABLE_NAME3, null, cate30);
        ContentValues cate31 = new ContentValues();
        cate31.put(COLUMN_CAT, "Féculent");
        cate31.put(COLUMN_SCAT1, "Féculent");
        db.insert(TABLE_NAME3, null, cate31);
        ContentValues cate32 = new ContentValues();
        cate32.put(COLUMN_CAT, "Condiment");
        cate32.put(COLUMN_SCAT1, "Gousse");
        db.insert(TABLE_NAME3, null, cate32);
        ContentValues cate33 = new ContentValues();
        cate33.put(COLUMN_CAT, "Charcuterie");
        cate33.put(COLUMN_SCAT1, "Saucisse");
        db.insert(TABLE_NAME3, null, cate33);
        ContentValues cate34 = new ContentValues();
        cate34.put(COLUMN_CAT, "Légume");
        cate34.put(COLUMN_SCAT1, "Rhizome");
        db.insert(TABLE_NAME3, null, cate34);
        ContentValues cate35 = new ContentValues();
        cate35.put(COLUMN_CAT, "Légume");
        cate35.put(COLUMN_SCAT1, "Cucurbitacé");
        db.insert(TABLE_NAME3, null, cate35);
        ContentValues cate36 = new ContentValues();
        cate36.put(COLUMN_CAT, "Charcuterie");
        cate36.put(COLUMN_SCAT1, "Jambon");
        db.insert(TABLE_NAME3, null, cate36);
        ContentValues cate37 = new ContentValues();
        cate37.put(COLUMN_CAT, "Poisson");
        cate37.put(COLUMN_SCAT1, "Gastéropode");
        db.insert(TABLE_NAME3, null, cate37);
        ContentValues cate38 = new ContentValues();
        cate38.put(COLUMN_CAT, "Légume");
        cate38.put(COLUMN_SCAT1, "Feuille");
        db.insert(TABLE_NAME3, null, cate38);
        ContentValues cate39 = new ContentValues();
        cate39.put(COLUMN_CAT, "Condiment");
        cate39.put(COLUMN_SCAT1, "Pates");
        db.insert(TABLE_NAME3, null, cate39);
        ContentValues cate40 = new ContentValues();
        cate40.put(COLUMN_CAT, "Confiserie");
        cate40.put(COLUMN_SCAT1, "Bonbon");
        db.insert(TABLE_NAME3, null, cate40);
        ContentValues cate41 = new ContentValues();
        cate41.put(COLUMN_CAT, "Confiserie");
        cate41.put(COLUMN_SCAT1, "Biscuit");
        db.insert(TABLE_NAME3, null, cate41);
        ContentValues cate42 = new ContentValues();
        cate42.put(COLUMN_CAT, "Confiserie");
        cate42.put(COLUMN_SCAT1, "Chocolat");
        db.insert(TABLE_NAME3, null, cate42);
        ContentValues cate43 = new ContentValues();
        cate43.put(COLUMN_CAT, "Confiserie");
        cate43.put(COLUMN_SCAT1, "Massepain");
        db.insert(TABLE_NAME3, null, cate43);
        ContentValues cate44 = new ContentValues();
        cate44.put(COLUMN_CAT, "Condiment");
        cate44.put(COLUMN_SCAT1, "Sauce");
        db.insert(TABLE_NAME3, null, cate44);
        ContentValues cate46 = new ContentValues();
        cate46.put(COLUMN_CAT, "Condiment");
        cate46.put(COLUMN_SCAT1, "Epice");
        db.insert(TABLE_NAME3, null, cate46);
        ContentValues cate47 = new ContentValues();
        cate47.put(COLUMN_CAT, "Condiment");
        cate47.put(COLUMN_SCAT1, "Confit");
        db.insert(TABLE_NAME3, null, cate47);
        ContentValues cate48 = new ContentValues();
        cate48.put(COLUMN_CAT, "Légume");
        cate48.put(COLUMN_SCAT1, "Lentille");
        db.insert(TABLE_NAME3, null, cate48);
        ContentValues cate49 = new ContentValues();
        cate49.put(COLUMN_CAT, "Légume");
        cate49.put(COLUMN_SCAT1, "Chou");
        db.insert(TABLE_NAME3, null, cate49);
        ContentValues cate50 = new ContentValues();
        cate50.put(COLUMN_CAT, "Boisson");
        cate50.put(COLUMN_SCAT1, "Eau");
        db.insert(TABLE_NAME3, null, cate50);
        ContentValues cate51 = new ContentValues();
        cate51.put(COLUMN_CAT, "Boisson");
        cate51.put(COLUMN_SCAT1, "Soda");
        db.insert(TABLE_NAME3, null, cate51);
        ContentValues cate52 = new ContentValues();
        cate52.put(COLUMN_CAT, "Boisson");
        cate52.put(COLUMN_SCAT1, "Alcool");
        db.insert(TABLE_NAME3, null, cate52);
        ContentValues cate54 = new ContentValues();
        cate54.put(COLUMN_CAT, "Boisson");
        cate54.put(COLUMN_SCAT1, "Vin Blanc");
        db.insert(TABLE_NAME3, null, cate54);
        ContentValues cate55 = new ContentValues();
        cate55.put(COLUMN_CAT, "Boisson");
        cate55.put(COLUMN_SCAT1, "Vin Rouge");
        db.insert(TABLE_NAME3, null, cate55);
        ContentValues cate56 = new ContentValues();
        cate56.put(COLUMN_CAT, "Boisson");
        cate56.put(COLUMN_SCAT1, "Vin Rosé");
        db.insert(TABLE_NAME3, null, cate56);
        ContentValues cate57 = new ContentValues();
        cate57.put(COLUMN_CAT, "Boisson");
        cate57.put(COLUMN_SCAT1, "Sirop");
        db.insert(TABLE_NAME3, null, cate57);
        ContentValues cate58 = new ContentValues();
        cate58.put(COLUMN_CAT, "Boisson");
        cate58.put(COLUMN_SCAT1, "Jus");
        db.insert(TABLE_NAME3, null, cate58);
        ContentValues cate59 = new ContentValues();
        cate59.put(COLUMN_CAT, "Confiserie");
        cate59.put(COLUMN_SCAT1, "Glace");
        db.insert(TABLE_NAME3, null, cate59);


        //Création de la table des ingredients
        String queryD = "CREATE TABLE " + TABLE_NAME4 + "(" +
                COLUMN_INGREDIENT1 + " VARCHAR(255) PRIMARY KEY, " +
                COLUMN_SCAT2 + " VARCHAR(255) " +
                ");";
        db.execSQL(queryD);

        //Ajout de quelques ingrédient
        ContentValues ingredient1 = new ContentValues();
        ingredient1.put(COLUMN_INGREDIENT1, "Boulette");
        ingredient1.put(COLUMN_SCAT2, "Haché");
        db.insert(TABLE_NAME4, null, ingredient1);
        ContentValues ingredient2 = new ContentValues();
        ingredient2.put(COLUMN_INGREDIENT1, "Carotte");
        ingredient2.put(COLUMN_SCAT2, "Racine");
        db.insert(TABLE_NAME4, null, ingredient2);
        ContentValues ingredient3 = new ContentValues();
        ingredient3.put(COLUMN_INGREDIENT1, "Fraise");
        ingredient3.put(COLUMN_SCAT2, "Rouges");
        db.insert(TABLE_NAME4, null, ingredient3);
        ContentValues ingredient4 = new ContentValues();
        ingredient4.put(COLUMN_INGREDIENT1, "Poulet");
        ingredient4.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, ingredient4);
        ContentValues ingredient5 = new ContentValues();
        ingredient5.put(COLUMN_INGREDIENT1, "Plie");
        ingredient5.put(COLUMN_SCAT2, "Maigre");
        db.insert(TABLE_NAME4, null, ingredient5);
        ContentValues ingredient6 = new ContentValues();
        ingredient6.put(COLUMN_INGREDIENT1, "Saumon");
        ingredient6.put(COLUMN_SCAT2, "Gras");
        db.insert(TABLE_NAME4, null, ingredient6);
        ContentValues ingredient7 = new ContentValues();
        ingredient7.put(COLUMN_INGREDIENT1, "Champignon de Paris");
        ingredient7.put(COLUMN_SCAT2, "Champignon");
        db.insert(TABLE_NAME4, null, ingredient7);
        ContentValues ingredient8 = new ContentValues();
        ingredient8.put(COLUMN_INGREDIENT1, "Pomme de Terre");
        ingredient8.put(COLUMN_SCAT2, "Féculent");
        db.insert(TABLE_NAME4, null, ingredient8);
        ContentValues ingredient9 = new ContentValues();
        ingredient9.put(COLUMN_INGREDIENT1, "Abricot");
        ingredient9.put(COLUMN_SCAT2, "Noyaux");
        db.insert(TABLE_NAME4, null, ingredient9);
        ContentValues ingredient10 = new ContentValues();
        ingredient10.put(COLUMN_INGREDIENT1, "Agneau");
        ingredient10.put(COLUMN_SCAT2, "Rouge");
        db.insert(TABLE_NAME4, null, ingredient10);
        ContentValues ingredient11 = new ContentValues();
        ingredient11.put(COLUMN_INGREDIENT1, "Airelle");
        ingredient11.put(COLUMN_SCAT2, "Rouges");
        db.insert(TABLE_NAME4, null, ingredient11);
        ContentValues ingredient12 = new ContentValues();
        ingredient12.put(COLUMN_INGREDIENT1, "Ail");
        ingredient12.put(COLUMN_SCAT2, "Gousse");
        db.insert(TABLE_NAME4, null, ingredient12);
        ContentValues ingredient13 = new ContentValues();
        ingredient13.put(COLUMN_INGREDIENT1, "Algue");
        ingredient13.put(COLUMN_SCAT2, "Vert");
        db.insert(TABLE_NAME4, null, ingredient13);
        ContentValues ingredient14 = new ContentValues();
        ingredient14.put(COLUMN_INGREDIENT1, "Amande");
        ingredient14.put(COLUMN_SCAT2, "Coques");
        db.insert(TABLE_NAME4, null, ingredient14);
        ContentValues ingredient15 = new ContentValues();
        ingredient15.put(COLUMN_INGREDIENT1, "Ananas");
        ingredient15.put(COLUMN_SCAT2, "Exotiques");
        db.insert(TABLE_NAME4, null, ingredient15);
        ContentValues ingredient16 = new ContentValues();
        ingredient16.put(COLUMN_INGREDIENT1, "Anchois");
        ingredient16.put(COLUMN_SCAT2, "Gras");
        db.insert(TABLE_NAME4, null, ingredient16);
        ContentValues ingredient17 = new ContentValues();
        ingredient17.put(COLUMN_INGREDIENT1, "Andouillette");
        ingredient17.put(COLUMN_SCAT2, "Saucisse");
        db.insert(TABLE_NAME4, null, ingredient17);
        ContentValues ingredient18 = new ContentValues();
        ingredient18.put(COLUMN_INGREDIENT1, "Artichaut");
        ingredient18.put(COLUMN_SCAT2, "Vert");
        db.insert(TABLE_NAME4, null, ingredient18);
        ContentValues ingredient19 = new ContentValues();
        ingredient19.put(COLUMN_INGREDIENT1, "Asperge blanche");
        ingredient19.put(COLUMN_SCAT2, "Rhizome");
        db.insert(TABLE_NAME4, null, ingredient19);
        ContentValues ingredient20 = new ContentValues();
        ingredient20.put(COLUMN_INGREDIENT1, "Asperge verte");
        ingredient20.put(COLUMN_SCAT2, "Rhizome");
        db.insert(TABLE_NAME4, null, ingredient20);
        ContentValues ingredient21 = new ContentValues();
        ingredient21.put(COLUMN_INGREDIENT1, "Aubergine");
        ingredient21.put(COLUMN_SCAT2, "Cucurbitacé");
        db.insert(TABLE_NAME4, null, ingredient21);
        ContentValues ingredient22 = new ContentValues();
        ingredient22.put(COLUMN_INGREDIENT1, "Autruche");
        ingredient22.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, ingredient22);
        ContentValues ingredient23 = new ContentValues();
        ingredient23.put(COLUMN_INGREDIENT1, "Avocat");
        ingredient23.put(COLUMN_SCAT2, "Noyaux");
        db.insert(TABLE_NAME4, null, ingredient23);
        ContentValues ingredient24 = new ContentValues();
        ingredient24.put(COLUMN_INGREDIENT1, "Bacon");
        ingredient24.put(COLUMN_SCAT2, "Jambon");
        db.insert(TABLE_NAME4, null, ingredient24);
        ContentValues ingredient25 = new ContentValues();
        ingredient25.put(COLUMN_INGREDIENT1, "Banane");
        ingredient25.put(COLUMN_SCAT2, "Exotiques");
        db.insert(TABLE_NAME4, null, ingredient25);
        ContentValues ingredient26 = new ContentValues();
        ingredient26.put(COLUMN_INGREDIENT1, "Basilic");
        ingredient26.put(COLUMN_SCAT2, "Plantes");
        db.insert(TABLE_NAME4, null, ingredient26);
        ContentValues ingredient27 = new ContentValues();
        ingredient27.put(COLUMN_INGREDIENT1, "Béchamel");
        ingredient27.put(COLUMN_SCAT2, "Sauce");
        db.insert(TABLE_NAME4, null, ingredient27);
        ContentValues ingredient28 = new ContentValues();
        ingredient28.put(COLUMN_INGREDIENT1, "Beaufort");
        ingredient28.put(COLUMN_SCAT2, "Pate pressée");
        db.insert(TABLE_NAME4, null, ingredient28);
        ContentValues ingredient29 = new ContentValues();
        ingredient29.put(COLUMN_INGREDIENT1, "Betterave");
        ingredient29.put(COLUMN_SCAT2, "Racine");
        db.insert(TABLE_NAME4, null, ingredient29);
        ContentValues ingredient30 = new ContentValues();
        ingredient30.put(COLUMN_INGREDIENT1, "Beurre");
        ingredient30.put(COLUMN_SCAT2, "Matière grasse");
        db.insert(TABLE_NAME4, null, ingredient30);
        ContentValues ingredient31 = new ContentValues();
        ingredient31.put(COLUMN_INGREDIENT1, "Biche");
        ingredient31.put(COLUMN_SCAT2, "Gibier");
        db.insert(TABLE_NAME4, null, ingredient31);
        ContentValues ingredient32 = new ContentValues();
        ingredient32.put(COLUMN_INGREDIENT1, "Bifteck");
        ingredient32.put(COLUMN_SCAT2, "Rouge");
        db.insert(TABLE_NAME4, null, ingredient32);
        ContentValues ingredient33 = new ContentValues();
        ingredient33.put(COLUMN_INGREDIENT1, "Blé");
        ingredient33.put(COLUMN_SCAT2, "Féculent");
        db.insert(TABLE_NAME4, null, ingredient33);
        ContentValues ingredient34 = new ContentValues();
        ingredient34.put(COLUMN_INGREDIENT1, "Bigorgneau");
        ingredient34.put(COLUMN_SCAT2, "Gastéropode");
        db.insert(TABLE_NAME4, null, ingredient34);
        ContentValues ingredient35 = new ContentValues();
        ingredient35.put(COLUMN_INGREDIENT1, "Bleu d'Auvergne");
        ingredient35.put(COLUMN_SCAT2, "Pate persillée");
        db.insert(TABLE_NAME4, null, ingredient35);
        ContentValues ingredient36 = new ContentValues();
        ingredient36.put(COLUMN_INGREDIENT1, "Bolognaise");
        ingredient36.put(COLUMN_SCAT2, "Sauce");
        db.insert(TABLE_NAME4, null, ingredient36);
        ContentValues ingredient37 = new ContentValues();
        ingredient37.put(COLUMN_INGREDIENT1, "Boudin blanc");
        ingredient37.put(COLUMN_SCAT2, "Saucisse");
        db.insert(TABLE_NAME4, null, ingredient37);
        ContentValues ingredient38 = new ContentValues();
        ingredient38.put(COLUMN_INGREDIENT1, "Boudin noir");
        ingredient38.put(COLUMN_SCAT2, "Saucisse");
        db.insert(TABLE_NAME4, null, ingredient38);
        ContentValues ingredient39 = new ContentValues();
        ingredient39.put(COLUMN_INGREDIENT1, "Boulgour");
        ingredient39.put(COLUMN_SCAT2, "Féculent");
        db.insert(TABLE_NAME4, null, ingredient39);
        ContentValues ingredient40 = new ContentValues();
        ingredient40.put(COLUMN_INGREDIENT1, "Boursin");
        ingredient40.put(COLUMN_SCAT2, "Frais");
        db.insert(TABLE_NAME4, null, ingredient40);
        ContentValues ingredient41 = new ContentValues();
        ingredient41.put(COLUMN_INGREDIENT1, "Céléri");
        ingredient41.put(COLUMN_SCAT2, "Feuille");
        db.insert(TABLE_NAME4, null, ingredient41);
        ContentValues ingredient42 = new ContentValues();
        ingredient42.put(COLUMN_INGREDIENT1, "Bresse Bleu");
        ingredient42.put(COLUMN_SCAT2, "Pate persillée");
        db.insert(TABLE_NAME4, null, ingredient42);
        ContentValues ingredient43 = new ContentValues();
        ingredient43.put(COLUMN_INGREDIENT1, "Brie");
        ingredient43.put(COLUMN_SCAT2, "Pate molle");
        db.insert(TABLE_NAME4, null, ingredient43);
        ContentValues ingredient44 = new ContentValues();
        ingredient44.put(COLUMN_INGREDIENT1, "Brochet");
        ingredient44.put(COLUMN_SCAT2, "Mi gras");
        db.insert(TABLE_NAME4, null, ingredient44);
        ContentValues ingredient45 = new ContentValues();
        ingredient45.put(COLUMN_INGREDIENT1, "Brocoli");
        ingredient45.put(COLUMN_SCAT2, "Chou");
        db.insert(TABLE_NAME4, null, ingredient45);
        ContentValues ingredient46 = new ContentValues();
        ingredient46.put(COLUMN_INGREDIENT1, "Boeuf haché");
        ingredient46.put(COLUMN_SCAT2, "Rouge");
        db.insert(TABLE_NAME4, null, ingredient46);
        ContentValues ingredient47 = new ContentValues();
        ingredient47.put(COLUMN_INGREDIENT1, "Boeuf");
        ingredient47.put(COLUMN_SCAT2, "Rouge");
        db.insert(TABLE_NAME4, null, ingredient47);
        ContentValues ingredient48 = new ContentValues();
        ingredient48.put(COLUMN_INGREDIENT1, "Cabillaud");
        ingredient48.put(COLUMN_SCAT2, "Maigre");
        db.insert(TABLE_NAME4, null, ingredient48);
        ContentValues ingredient49 = new ContentValues();
        ingredient49.put(COLUMN_INGREDIENT1, "Cacahuete");
        ingredient49.put(COLUMN_SCAT2, "Coques");
        db.insert(TABLE_NAME4, null, ingredient49);
        ContentValues ingredient50 = new ContentValues();
        ingredient50.put(COLUMN_INGREDIENT1, "Cacao");
        ingredient50.put(COLUMN_SCAT2, "Exotiques");
        db.insert(TABLE_NAME4, null, ingredient50);
        ContentValues ingredient51 = new ContentValues();
        ingredient51.put(COLUMN_INGREDIENT1, "Caille");
        ingredient51.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, ingredient51);
        ContentValues ingredient52 = new ContentValues();
        ingredient52.put(COLUMN_INGREDIENT1, "Calamar");
        ingredient52.put(COLUMN_SCAT2, "Crustacé");
        db.insert(TABLE_NAME4, null, ingredient52);
        ContentValues ingredient53 = new ContentValues();
        ingredient53.put(COLUMN_INGREDIENT1, "Camembert");
        ingredient53.put(COLUMN_SCAT2, "Pate molle");
        db.insert(TABLE_NAME4, null, ingredient53);
        ContentValues ingredient54 = new ContentValues();
        ingredient54.put(COLUMN_INGREDIENT1, "Cannelle");
        ingredient54.put(COLUMN_SCAT2, "Epice");
        db.insert(TABLE_NAME4, null, ingredient54);
        ContentValues ingredient55 = new ContentValues();
        ingredient55.put(COLUMN_INGREDIENT1, "Canard");
        ingredient55.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, ingredient55);
        ContentValues ingredient56 = new ContentValues();
        ingredient56.put(COLUMN_INGREDIENT1, "Capellini");
        ingredient56.put(COLUMN_SCAT2, "Pates");
        db.insert(TABLE_NAME4, null, ingredient56);
        ContentValues ingredient57 = new ContentValues();
        ingredient57.put(COLUMN_INGREDIENT1, "Caprice des Anges");
        ingredient57.put(COLUMN_SCAT2, "Pate molle");
        db.insert(TABLE_NAME4, null, ingredient57);
        ContentValues ingredient58 = new ContentValues();
        ingredient58.put(COLUMN_INGREDIENT1, "Caprice des dieux");
        ingredient58.put(COLUMN_SCAT2, "Pate molle");
        db.insert(TABLE_NAME4, null, ingredient58);
        ContentValues ingredient59 = new ContentValues();
        ingredient59.put(COLUMN_INGREDIENT1, "Carambar");
        ingredient59.put(COLUMN_SCAT2, "Bonbon");
        db.insert(TABLE_NAME4, null, ingredient59);
        ContentValues ingredient60 = new ContentValues();
        ingredient60.put(COLUMN_INGREDIENT1, "Caramel");
        ingredient60.put(COLUMN_SCAT2, "Bonbon");
        db.insert(TABLE_NAME4, null, ingredient60);
        ContentValues ingredient61 = new ContentValues();
        ingredient61.put(COLUMN_INGREDIENT1, "Caviar");
        ingredient61.put(COLUMN_SCAT2, "Crustacé");
        db.insert(TABLE_NAME4, null, ingredient61);
        ContentValues ingredient62 = new ContentValues();
        ingredient62.put(COLUMN_INGREDIENT1, "Cèpe");
        ingredient62.put(COLUMN_SCAT2, "Champignon");
        db.insert(TABLE_NAME4, null, ingredient62);
        ContentValues ingredient63 = new ContentValues();
        ingredient63.put(COLUMN_INGREDIENT1, "Cerfeuil");
        ingredient63.put(COLUMN_SCAT2, "Feuille");
        db.insert(TABLE_NAME4, null, ingredient63);
        ContentValues ingredient64 = new ContentValues();
        ingredient64.put(COLUMN_INGREDIENT1, "Cerise");
        ingredient64.put(COLUMN_SCAT2, "Rouges");
        db.insert(TABLE_NAME4, null, ingredient64);
        ContentValues ingredient65 = new ContentValues();
        ingredient65.put(COLUMN_INGREDIENT1, "Chataigne");
        ingredient65.put(COLUMN_SCAT2, "Coques");
        db.insert(TABLE_NAME4, null, ingredient65);
        ContentValues ingredient66 = new ContentValues();
        ingredient66.put(COLUMN_INGREDIENT1, "Cheddar");
        ingredient66.put(COLUMN_SCAT2, "Pate pressée");
        db.insert(TABLE_NAME4, null, ingredient66);
        ContentValues ingredient67 = new ContentValues();
        ingredient67.put(COLUMN_INGREDIENT1, "Chèvre");
        ingredient67.put(COLUMN_SCAT2, "Chèvre");
        db.insert(TABLE_NAME4, null, ingredient67);
        ContentValues ingredient68 = new ContentValues();
        ingredient68.put(COLUMN_INGREDIENT1, "Chevreuil");
        ingredient68.put(COLUMN_SCAT2, "Gibier");
        db.insert(TABLE_NAME4, null, ingredient68);
        ContentValues ingredient69 = new ContentValues();
        ingredient69.put(COLUMN_INGREDIENT1, "Chocolat Noir");
        ingredient69.put(COLUMN_SCAT2, "Chocolat");
        db.insert(TABLE_NAME4, null, ingredient69);
        ContentValues ingredient70 = new ContentValues();
        ingredient70.put(COLUMN_INGREDIENT1, "Chocolat Blanc");
        ingredient70.put(COLUMN_SCAT2, "Chocolat");
        db.insert(TABLE_NAME4, null, ingredient70);
        ContentValues ingredient71 = new ContentValues();
        ingredient71.put(COLUMN_INGREDIENT1, "Chocolat au lait");
        ingredient71.put(COLUMN_SCAT2, "Chocolat");
        db.insert(TABLE_NAME4, null, ingredient71);
        ContentValues ingredient72 = new ContentValues();
        ingredient72.put(COLUMN_INGREDIENT1, "Chocolat praliné");
        ingredient72.put(COLUMN_SCAT2, "Chocolat");
        db.insert(TABLE_NAME4, null, ingredient72);
        ContentValues ingredient73 = new ContentValues();
        ingredient73.put(COLUMN_INGREDIENT1, "Cheddar");
        ingredient73.put(COLUMN_SCAT2, "Pate pressée");
        db.insert(TABLE_NAME4, null, ingredient73);
        ContentValues ingredient74 = new ContentValues();
        ingredient74.put(COLUMN_INGREDIENT1, "Chou Blanc");
        ingredient74.put(COLUMN_SCAT2, "Chou");
        db.insert(TABLE_NAME4, null, ingredient74);
        ContentValues ingredient75 = new ContentValues();
        ingredient75.put(COLUMN_INGREDIENT1, "Chou de Bruxelles");
        ingredient75.put(COLUMN_SCAT2, "Chou");
        db.insert(TABLE_NAME4, null, ingredient75);
        ContentValues ingredient76 = new ContentValues();
        ingredient76.put(COLUMN_INGREDIENT1, "Chou Fleur");
        ingredient76.put(COLUMN_SCAT2, "Chou");
        db.insert(TABLE_NAME4, null, ingredient76);
        ContentValues ingredient77 = new ContentValues();
        ingredient77.put(COLUMN_INGREDIENT1, "Chou Rouge");
        ingredient77.put(COLUMN_SCAT2, "Chou");
        db.insert(TABLE_NAME4, null, ingredient77);
        ContentValues ingredient78 = new ContentValues();
        ingredient78.put(COLUMN_INGREDIENT1, "Ciboulette");
        ingredient78.put(COLUMN_SCAT2, "Plante");
        db.insert(TABLE_NAME4, null, ingredient78);
        ContentValues ingredient79 = new ContentValues();
        ingredient79.put(COLUMN_INGREDIENT1, "Choucroute");
        ingredient79.put(COLUMN_SCAT2, "Chou");
        db.insert(TABLE_NAME4, null, ingredient79);
        ContentValues ingredient80 = new ContentValues();
        ingredient80.put(COLUMN_INGREDIENT1, "Citron");
        ingredient80.put(COLUMN_SCAT2, "Agrumes");
        db.insert(TABLE_NAME4, null, ingredient80);
        ContentValues ingredient81 = new ContentValues();
        ingredient81.put(COLUMN_INGREDIENT1, "Clou de girofle");
        ingredient81.put(COLUMN_SCAT2, "Epice");
        db.insert(TABLE_NAME4, null, ingredient81);
        ContentValues ingredient82 = new ContentValues();
        ingredient82.put(COLUMN_INGREDIENT1, "Clémentine");
        ingredient82.put(COLUMN_SCAT2, "Agrumes");
        db.insert(TABLE_NAME4, null, ingredient82);
        ContentValues ingredient83 = new ContentValues();
        ingredient83.put(COLUMN_INGREDIENT1, "Cochon");
        ingredient83.put(COLUMN_SCAT2, "Blanche");
        db.insert(TABLE_NAME4, null, ingredient83);
        ContentValues ingredient84 = new ContentValues();
        ingredient84.put(COLUMN_INGREDIENT1, "Colin");
        ingredient84.put(COLUMN_SCAT2, "Maigre");
        db.insert(TABLE_NAME4, null, ingredient84);
        ContentValues ingredient85 = new ContentValues();
        ingredient85.put(COLUMN_INGREDIENT1, "Comté");
        ingredient85.put(COLUMN_SCAT2, "Pate pressée");
        db.insert(TABLE_NAME4, null, ingredient85);
        ContentValues ingredient86 = new ContentValues();
        ingredient86.put(COLUMN_INGREDIENT1, "Confit d'oignon");
        ingredient86.put(COLUMN_SCAT2, "Confit");
        db.insert(TABLE_NAME4, null, ingredient86);
        ContentValues ingredient87 = new ContentValues();
        ingredient87.put(COLUMN_INGREDIENT1, "Concombre");
        ingredient87.put(COLUMN_SCAT2, "Cucurbitacé");
        db.insert(TABLE_NAME4, null, ingredient87);
        ContentValues ingredient88 = new ContentValues();
        ingredient88.put(COLUMN_INGREDIENT1, "Coppa");
        ingredient88.put(COLUMN_SCAT2, "Jambon");
        db.insert(TABLE_NAME4, null, ingredient88);
        ContentValues ingredient89 = new ContentValues();
        ingredient89.put(COLUMN_INGREDIENT1, "Coq");
        ingredient89.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, ingredient89);
        ContentValues ingredient90 = new ContentValues();
        ingredient90.put(COLUMN_INGREDIENT1, "Coquille St-Jacques");
        ingredient90.put(COLUMN_SCAT2, "Mollusque");
        db.insert(TABLE_NAME4, null, ingredient90);
        ContentValues ingredient91 = new ContentValues();
        ingredient91.put(COLUMN_INGREDIENT1, "Cornichon");
        ingredient91.put(COLUMN_SCAT2, "Cucurbitacé");
        db.insert(TABLE_NAME4, null, ingredient91);
        ContentValues ingredient92 = new ContentValues();
        ingredient92.put(COLUMN_INGREDIENT1, "Courgette");
        ingredient92.put(COLUMN_SCAT2, "Cucurbitacé");
        db.insert(TABLE_NAME4, null, ingredient92);
        ContentValues ingredient93 = new ContentValues();
        ingredient93.put(COLUMN_INGREDIENT1, "Crabe");
        ingredient93.put(COLUMN_SCAT2, "Crustacé");
        db.insert(TABLE_NAME4, null, ingredient93);
        ContentValues ingredient94 = new ContentValues();
        ingredient94.put(COLUMN_INGREDIENT1, "Crevette grise");
        ingredient94.put(COLUMN_SCAT2, "Crustacé");
        db.insert(TABLE_NAME4, null, ingredient94);
        ContentValues ingredient95 = new ContentValues();
        ingredient95.put(COLUMN_INGREDIENT1, "Crevette rose");
        ingredient95.put(COLUMN_SCAT2, "Crustacé");
        db.insert(TABLE_NAME4, null, ingredient95);
        ContentValues ingredient96 = new ContentValues();
        ingredient96.put(COLUMN_INGREDIENT1, "Datte");
        ingredient96.put(COLUMN_SCAT2, "Exotiques");
        db.insert(TABLE_NAME4, null, ingredient96);
        ContentValues ingredient97 = new ContentValues();
        ingredient97.put(COLUMN_INGREDIENT1, "Echalotte");
        ingredient97.put(COLUMN_SCAT2, "Gousse");
        db.insert(TABLE_NAME4, null, ingredient97);
        ContentValues ingredient98 = new ContentValues();
        ingredient98.put(COLUMN_INGREDIENT1, "Ecrevisse");
        ingredient98.put(COLUMN_SCAT2, "Crustacé");
        db.insert(TABLE_NAME4, null, ingredient98);
        ContentValues ingredient99 = new ContentValues();
        ingredient99.put(COLUMN_INGREDIENT1, "Dinde");
        ingredient99.put(COLUMN_SCAT2, "Volaille");
        db.insert(TABLE_NAME4, null, ingredient99);


        //Création de la table quantite par recette
        String queryE = "CREATE TABLE " + TABLE_NAME5 + "(" +
                COLUMN_NUMR2 + " VARCHAR(255), " +
                COLUMN_INGREDIENT2 + " VARCHAR(255), " +
                COLUMN_QUANTITE + " VARCHAR(255) " +
                ");";
        db.execSQL(queryE);

        //Ajout de quelques données quantite
        ContentValues tq1 = new ContentValues();
        tq1.put(COLUMN_INGREDIENT2, "Poulet");
        tq1.put(COLUMN_QUANTITE, "4");
        tq1.put(COLUMN_NUMR2, 1);
        db.insert(TABLE_NAME5, null, tq1);
        ContentValues tq2 = new ContentValues();
        tq2.put(COLUMN_INGREDIENT2, "Champignon de Paris");
        tq2.put(COLUMN_QUANTITE, "150g");
        tq2.put(COLUMN_NUMR2, 1);
        db.insert(TABLE_NAME5, null, tq2);
        ContentValues tq3 = new ContentValues();
        tq3.put(COLUMN_INGREDIENT2, "Oignon");
        tq3.put(COLUMN_QUANTITE, "1");
        tq3.put(COLUMN_NUMR2, 1);
        db.insert(TABLE_NAME5, null, tq3);



        //Création de la table etape par recette
        String queryF = "CREATE TABLE " + TABLE_NAME6 + "(" +
                COLUMN_NUMR3 + " INTEGER, " +
                COLUMN_NETAPE + " INTEGER, " +
                COLUMN_ACTION + " VARCHAR(255) " +
                ");";
        db.execSQL(queryF);

        //Ajout de quelques données etapes
        ContentValues te1 = new ContentValues();
        te1.put(COLUMN_NUMR3, 1);
        te1.put(COLUMN_NETAPE, 1);
        te1.put(COLUMN_ACTION, "Nettoyer et emincer les champignons");
        db.insert(TABLE_NAME6, null, te1);
        ContentValues te2 = new ContentValues();
        te2.put(COLUMN_NUMR3, 1);
        te2.put(COLUMN_NETAPE, 2);
        te2.put(COLUMN_ACTION, "Eplucher et emincer l'oignon");
        db.insert(TABLE_NAME6, null, te2);
        ContentValues te3 = new ContentValues();
        te3.put(COLUMN_NUMR3, 1);
        te3.put(COLUMN_NETAPE, 3);
        te3.put(COLUMN_ACTION, "Saisir les cuisses de poulets");
        db.insert(TABLE_NAME6, null, te3);
        ContentValues te4 = new ContentValues();
        te4.put(COLUMN_NUMR3, 1);
        te4.put(COLUMN_NETAPE, 4);
        te4.put(COLUMN_ACTION, "Ajouter les oignons et les champignons");
        db.insert(TABLE_NAME6, null, te4);
        ContentValues te5 = new ContentValues();
        te5.put(COLUMN_NUMR3, 1);
        te5.put(COLUMN_NETAPE, 5);
        te5.put(COLUMN_ACTION, "Laisser cuire le tout 5 min");
        db.insert(TABLE_NAME6, null, te5);


        //Création de la table Review
        String queryG = "CREATE TABLE " + TABLE_NAME7 + "(" +
                COLUMN_USER + " VARCHAR(255), " +
                COLUMN_NUMR4 + " INTEGER, " +
                COLUMN_DATE2 + " VARCHAR(255), " +
                COLUMN_NOTE + " INTEGER, " +
                COLUMN_COMMENT + " VARCHAR(255) " +
                ");";
        db.execSQL(queryG);

        //Ajout de quelque review
        ContentValues rev1 = new ContentValues();
        rev1.put(COLUMN_USER, "Admin");
        rev1.put(COLUMN_NUMR4, 1);
        rev1.put(COLUMN_DATE2, "05/05/2017");
        rev1.put(COLUMN_NOTE, 2);
        rev1.put(COLUMN_COMMENT, "Toujours très plaisant à manger");
        db.insert(TABLE_NAME7, null, rev1);

    }


    //Création de InsertUser    //NUPLOAD PAS ENCORE DANS LA DB
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
        y = "NOT FOUND";
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
                    y = cu.getString(cu.getColumnIndex(dataColumn))+"\n";
                    break;
                }
            }
            while(cu.moveToNext());
        }
        cu.close();
        return y;
    }

    //On recherche les étapes d'une recette via son ID
    public String etaperecette(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String recquete = "SELECT "+COLUMN_ACTION+" FROM "+TABLE_NAME6+ " WHERE "+COLUMN_NUMR3+" == "+id+" ORDER BY "+COLUMN_NETAPE;  //a vérifier
        Cursor cu = db.rawQuery(recquete, null);
        String y="";
        if(cu.moveToFirst()){
            do{
                String s;
                s=cu.getString(0);
                y=y+s+"\n";
            }while (cu.moveToNext());
        }
        cu.close();
        return y;
    }


    //On recherche les ingrédients d'une recette via son ID
    public String ingredientrecette(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String req = "SELECT "+COLUMN_INGREDIENT2+", "+COLUMN_QUANTITE+" FROM "+TABLE_NAME5+" WHERE "+COLUMN_NUMR2+" == "+id;  //a vérifier
        Cursor cu = db.rawQuery(req, null);
        String y="";
        if (cu.moveToFirst()){
            do{
                String s;
                String p;
                s=cu.getString(0);
                p=cu.getString(1);
                y=y+p+", "+s+"\n";
            }while (cu.moveToNext());
        }
        cu.close();
        return y;
    }



    //Création d'un arraylist qui contient les titres de toutes les recettes pour le catalogue
    public ArrayList<String> getRecetteArray(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NomR FROM " + TABLE_NAME2 + " ORDER BY NomR";
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
    //NE FONCTIONNE PAS
    public ArrayList<String> getRecetteIngredient(String ingre){
        SQLiteDatabase db = this.getReadableDatabase();
        //String query = "SELECT NomR FROM Recette, Tquantite WHERE Tquantite.Ingredientt2 == '"+ingre+"' AND Recette.NumR == Tquantite.NumR2";
        //String query = "SELECT "+COLUMN_NOMR+" FROM "+TABLE_NAME2+", "+TABLE_NAME5+" WHERE "+COLUMN_NUMR1+" == "+COLUMN_NUMR2+" AND "+COLUMN_INGREDIENT2+" == "+ingre;//a verifier
        //String query = "SELECT NomR FROM Recette WHERE NumR == (SELECT NumR2 FROM Tquantite WHERE Ingredient2== '"+ingre+"')";
        String query = "SELECT "+COLUMN_NUMR2+" FROM "+TABLE_NAME5+" WHERE "+COLUMN_INGREDIENT2+" == "+ingre;
        int i;
        Cursor c = db.rawQuery(query, null);
        ArrayList<String> listRecette = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            i=(c.getInt(c.getColumnIndex(COLUMN_NUMR2)));
            String query2 = "SELECT "+COLUMN_NOMR+" FROM "+TABLE_NAME+" WHERE "+COLUMN_NUMR1+" == "+i;
            Cursor c2 = db.rawQuery(query2, null);
            c2.moveToFirst();
            while(!c.isAfterLast()){
                listRecette.add(c2.getString(c2.getColumnIndex(COLUMN_NOMR)));
                c2.moveToNext();
            }
            c2.close();
            c.moveToNext();
        }
        c.close();
        return listRecette;
    }

    //Création d'un arraylist qui contient les ingrédient appartenant a une sous-categorie sc
    public ArrayList<String> getIngredientSC(String sc){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> listIngredientSC = new ArrayList<String>();
        String query = "SELECT "+COLUMN_INGREDIENT1+" FROM "+TABLE_NAME4+" WHERE "+COLUMN_SCAT2+" == '"+sc+"' ORDER BY "+COLUMN_INGREDIENT1;
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
        String query = "SELECT "+COLUMN_SCAT1+" FROM "+TABLE_NAME3+" WHERE "+COLUMN_CAT+" == '"+categorie+"' ORDER BY "+COLUMN_SCAT1;
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
        String query = "SELECT DISTINCT "+COLUMN_CAT+" FROM "+TABLE_NAME3+" ORDER BY "+COLUMN_CAT;
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


    public void insertUtilisateur(String slogin, String spassword, String sville, String spays, String homme, int ijnaissance, int imnaissance, int ianaissance) {
        SQLiteDatabase db = this.getWritableDatabase();
        String partie2 = "VALUES ('"+slogin+"', '"+spassword+"', '"+sville+"', '"+spays+"', '"+homme+"', "+ijnaissance+", "+imnaissance+", "+ianaissance+")";
        String partie1 = "INSERT INTO Utilisateur ('Login', 'Password', 'Ville', 'Pays', 'Sexe', 'Jour', 'Mois', 'Annee') ";
        String complet = partie1+partie2;
        db.execSQL(complet);

    }

    public int getId(String nomrecette) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NumR FROM Recette WHERE NomR == '"+nomrecette+"'";
        int i=0;
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()){
            i=c.getInt(c.getColumnIndex(COLUMN_NUMR1));
            c.close();
        }
        return i;
    }

    public String searchCom(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_COMMENT+" FROM "+TABLE_NAME7+" WHERE "+COLUMN_NUMR4+" == "+i;
        Cursor c = db.rawQuery(query, null);
        String y="";
        if(c.moveToFirst()){
            do {
                y=y+c.getString(c.getColumnIndex(COLUMN_COMMENT))+"\n";
            }while (c.moveToNext());
        }
        return y;
    }

    public float searchRate(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT "+COLUMN_NOTE+" FROM "+TABLE_NAME7+" WHERE "+COLUMN_NUMR4+" == "+i;
        int somme=0;
        int nbre=0;
        String y ="0";
        Cursor c= db.rawQuery(query, null);
        if(c.moveToFirst()){
            do {
                somme = somme+c.getInt(c.getColumnIndex(COLUMN_NOTE));
                nbre++;
            }while(c.moveToNext());
            double moyenne = (double) somme/nbre;
            y=Double.toString(moyenne);
        }
        float b = Float.parseFloat(y);
        return b;

    }
}





/*
        ContentValues ingredient100 = new ContentValues();
        ingredient100.put(COLUMN_INGREDIENT1, "");
        ingredient100.put(COLUMN_SCAT2, "");
        db.insert(TABLE_NAME4, null, ingredient100);
*/

