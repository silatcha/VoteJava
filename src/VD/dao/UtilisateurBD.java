package VD.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import VD.BD.Connect;
import static VD.controller.Connexion_Inscription_Controller.printSQLException;
import VD.model.Utilisateur;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p
 */
public class UtilisateurBD {
    
   
    private static final String SELECT_QUERY="select * from utilisateurs where nom_uti= ? AND mdp =? and mdp NOT IN ( select mdp from administrateur)";
    
      static Connection con =null; 
    
    
    

   
   public static boolean validate(String Utilisateur1 , String Password1 ) throws SQLException {
    	
    	try(Connection connection=Connect.connect(); PreparedStatement prepareStatement = connection.prepareStatement(SELECT_QUERY)){
    		
    		prepareStatement.setNString(1, Utilisateur1);
    		prepareStatement.setNString(2, Password1);
    		System.out.println(prepareStatement);
    		
    		ResultSet resultSet = prepareStatement.executeQuery();
    		if(resultSet.next()) {
    			return true;
    		}
    	}catch(SQLException e) {
    		printSQLException(e);
    	}
    	
    	return false;
  
    }
 
    public static  List<Utilisateur> getUtilisateurs(){
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		try {
			String sql = "select * from utilisateurs";
			Connection con =Connect.connect();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Utilisateur uti = new Utilisateur();
				
                                uti.setNom(resultSet.getString(1));
                                uti.setPrenom(resultSet.getString(2));
                                uti.setAdresse(resultSet.getString(3));
                                uti.setEmail(resultSet.getString(4));
                                uti.setMdp(resultSet.getString(5));
                                uti.setTelphone(resultSet.getInt(6));
                                uti.setNomuti(resultSet.getString(7));
                                uti.setDatenaiss(resultSet.getDate(8));
				uti.setProfession(resultSet.getString(9));
				
			
				list.add(uti);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
    
    
	public static int save(Utilisateur utilisateur) {
		
		int st =0;
		try {
			
			String sql = "INSERT INTO utilisateurs (nom,prenom,adresse,email,mdp,tel,nom_uti,datenaiss,profession) Values (?,?,?,?,?,?,?,?,?)";
                        Connection con = Connect.connect();
                        PreparedStatement preparedStatement =  con.prepareStatement(sql);
                        preparedStatement.setString(1,utilisateur.getNom());
                        preparedStatement.setString(2,utilisateur.getPrenom());
                        preparedStatement.setString(3,utilisateur.getAdresse());
                        preparedStatement.setString(4,utilisateur.getEmail());
                        preparedStatement.setString(5,utilisateur.getMdp());
                        preparedStatement.setInt(6,utilisateur.getTelphone());
                        preparedStatement.setString(7,utilisateur.getNomuti());
                        preparedStatement.setDate(8,utilisateur.getDatenaiss());
                        preparedStatement.setString(9,utilisateur.getProfession());
                        
                        st = preparedStatement.executeUpdate();
                        System.out.println(preparedStatement.toString());
                        con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st;
		
	}
        
    
}
