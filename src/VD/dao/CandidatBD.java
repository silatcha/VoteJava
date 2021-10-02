/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.dao;

import VD.BD.Connect;
import VD.model.Candidat;
import VD.model.Scrutin;
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
public class CandidatBD {
    
    
     static Connection con =null; 
     static int a=0;
     
     public static  List<Candidat> getCandidats(){
		List<Candidat> list = new ArrayList<Candidat>();
		try {
			String sql = "select nom,partis from candidat";
			Connection con =Connect.connect();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Candidat uti = new Candidat();
				uti.setNom(resultSet.getString(1));
                                uti.setPartis(resultSet.getString(2));
                                
                                list.add(uti);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
                 a++;
		return list;
               
	}
    
    
}
