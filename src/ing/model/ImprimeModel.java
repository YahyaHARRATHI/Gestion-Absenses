/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ing.model;

/**
 *
 * @author yayan
 */
public class ImprimeModel {

    public ImprimeModel() {
    }
    
    
    private String nom;
    private String prenom;
    private String cin;
    private String nbrAbsence;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNbrAbsence() {
        return nbrAbsence;
    }

    public void setNbrAbsence(String nbrAbsence) {
        this.nbrAbsence = nbrAbsence;
    }
    
    
}
