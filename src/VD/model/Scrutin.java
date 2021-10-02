/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.model;

import java.sql.Date;

/**
 *
 * @author 12026
 */
public class Scrutin {
    
    private String id;
    private String type;
    private int nombre_candidats;
    private Date date_debut;
    private Date date_fin;
    

    public Scrutin(String id) {
        this.id = id;
    }

    public Scrutin(String type,int nombre_candidats, Date date_debut,Date date_fin,  String id) {
        this.id = id;
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nombre_candidats=nombre_candidats;
       
    }
    
    public Scrutin(){
        this.id = null;
        this.type = null;
        this.date_debut = null;
        this.date_fin = null;
         this.nombre_candidats=0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNombre_candidats() {
        return nombre_candidats;
    }

    public void setNombre_candidats(int nombre_candidats) {
        this.nombre_candidats = nombre_candidats;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

  
    
    
    
}
