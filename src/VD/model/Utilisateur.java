/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.model;

import java.sql.Date;

/**
 *
 * @author p
 */
public class Utilisateur {
    private String nom;
    private String nomuti;
    private String prenom;
    private String mdp;
    private String adresse;
    private Date datenaiss;
    private String profession;
    private String email;
    private int telphone;

    public Utilisateur(String nom, String prenom, String mdp, String adresse, Date datenaiss, String profession, String email, int telphone, String nomuti) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.adresse = adresse;
        this.datenaiss = datenaiss;
        this.profession = profession;
        this.email = email;
        this.telphone = telphone;
        this.nomuti = nomuti;
    }
    
    public Utilisateur(){
        
    }

    public Utilisateur(String nom, String prenom, String adresse, String email, int telphone, Date datenaiss, String profession) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telphone = telphone;
        this.datenaiss=datenaiss;
        this.profession = profession;
     
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public String getProfession() {
        return profession;
    }

    public String getEmail() {
        return email;
    }

    public int getTelphone() {
        return telphone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelphone(int telphone) {
        this.telphone = telphone;
    }

    public String getNomuti() {
        return nomuti;
    }

    public void setNomuti(String nomuti) {
        this.nomuti = nomuti;
    }

    
    
    
    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", nomuti=" + nomuti + ", prenom=" + prenom + ", mdp=" + mdp + ", adresse=" + adresse + ", datenaiss=" + datenaiss + ", profession=" + profession + ", email=" + email + ", telphone=" + telphone + '}';
    }

    
    
    
}
