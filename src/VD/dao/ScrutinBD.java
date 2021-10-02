/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.dao;

import VD.BD.Connect;
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
public class ScrutinBD {
    
     static Connection con =null; 
     static int a=0;
     
     public static  List<Scrutin> getScrutin(){
		List<Scrutin> list = new ArrayList<Scrutin>();
		try {
			String sql = "select * from scrutin";
			Connection con =Connect.connect();
			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Scrutin uti = new Scrutin();
				uti.setType(resultSet.getString(1));
                                uti.setNombre_candidats(resultSet.getInt(2));
                                uti.setDate_debut(resultSet.getDate(3));
                                uti.setDate_fin(resultSet.getDate(4));
                                uti.setId(resultSet.getString(5));
                                list.add(uti);
			}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
                 a++;
		return list;
               
	}
    
     
     public static int save(Scrutin scrutin) {
		
		int st =0;
		try {
			
			String sql = "INSERT INTO scrutin (type,nbr_candidats,date_debut,date_fin,id) Values (?,?,?,?,?)";
                        Connection con = Connect.connect();
                        PreparedStatement preparedStatement =  con.prepareStatement(sql);
                        preparedStatement.setString(1,scrutin.getType());
                        preparedStatement.setInt(2,scrutin.getNombre_candidats());
                        preparedStatement.setDate(3,scrutin.getDate_debut());
                        preparedStatement.setDate(4,scrutin.getDate_fin());
                        preparedStatement.setString(5,scrutin.getId());
                                                
                        st = preparedStatement.executeUpdate();
                        
                        con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st;
		
	}
     
     
        
    
}
