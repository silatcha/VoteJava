/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.dao;

import VD.BD.Connect;
import static VD.controller.Connexion_Inscription_Controller.printSQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author p
 */
public class AdministrateurBD {
    
     private static final String SELECT_QUERY="select * from utilisateurs,administrateur where nom_uti= ? AND utilisateurs.mdp =? AND administrateur.mdp=utilisateurs.mdp ";
    
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
 
    
}
