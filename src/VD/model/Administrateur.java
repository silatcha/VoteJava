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
public class Administrateur extends Utilisateur{

    public Administrateur(String nom, String prenom, String mdp, String adresse, Date datenaiss, String profession, String email, int telphone, String nomuti) {
        super(nom, prenom, mdp, adresse, datenaiss, profession, email, telphone, nomuti);
    }
    
    
    
}
