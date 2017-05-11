package be.lsinf1225.ezmeal;

/**
 * Created by Gaetan on 11/05/2017.
 */

public class Utilisateur {

    String login, mdp, sexe, pays, ville;
    int jour, mois, annee;

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }  //sexe

    public void setLogin(String prenom) {
        this.login = login;
    }   //login

    public void setVille(String email) {
        this.ville = ville;
    }  //ville

    public void setPays(String pays) { this.pays = pays; } //pays

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }  //mdp

    public void setJour(int jour) {
        this.jour = jour;
    }   //jour de naissance

    public void setMois(int mois) { this.mois = mois; }  //mois de naissance

    public void setAnnee(int annee) { this.annee = annee; }  //annee de naissance


    public String getSexe() {
        return this.sexe;
    }  //sexe

    public String getLogin() {return this.login;}  //login

    public String getVille() {
        return this.ville;
    }  //ville

    public String getPays() { return  this.pays; }  //pays

    public String getMdp() {
        return this.mdp;
    }  //mdp

    public int getJour() { return this.jour; }   //jour de naissance

    public int getMois() { return this.mois; }  //mois de naissance

    public int getAnnee() { return  this.annee; }  //annee de naissance


}
