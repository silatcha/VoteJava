/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.model;

import javafx.scene.control.CheckBox;

/**
 *
 * @author p
 */
public class Candidat {
    
    private String nom;
	private String prenom;
	private String partis;
	
	private String sexe;
	private String ville;
	private String nationalite;
        private  CheckBox select;
	/**
	 * @param nom
	 * @param prenom
	 * @param partis
	 * @param email
	 * @param sexe
	 * @param ville
	 * @param nationalite
	 */
	
        
        public Candidat(String nom, String prenom, String partis,  String sexe, String ville, String nationalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.partis = partis;
		
		this.sexe = sexe;
		this.ville = ville;
		this.nationalite = nationalite;
	}

        public Candidat(Candidat C) {
            super();
        }
        
    public Candidat() {
        
    }
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the partis
	 */
	public String getPartis() {
		return partis;
	}
	/**
	 * @param partis the partis to set
	 */
	public void setPartis(String partis) {
		this.partis = partis;
	}
	/**
	 * @return the email
	 */
	
	/**
	 * @return the sexe
	 */
	public String getSexe() {
		return sexe;
	}
	/**
	 * @param sexe the sexe to set
	 */
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the nationalite
	 */
	public String getNationalite() {
		return nationalite;
	}
	/**
	 * @param nationalite the nationalite to set
	 */
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + nom + " " + prenom + " " + partis + "  "
				+ sexe + " " + ville + " " + nationalite + "";
	}
        
        public CheckBox getSelect() {
		return select;
	}
}

