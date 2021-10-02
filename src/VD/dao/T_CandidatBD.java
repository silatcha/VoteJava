/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.dao;

import VD.BD.Connect;
import VD.controller.T_Candidat;
import static VD.dao.ScrutinBD.a;
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
public class T_CandidatBD {
    
    static Connection con =null; 
    
     public static  List<T_Candidat> getVote(){
		List<T_Candidat> list = new ArrayList<T_Candidat>();
			try {
		String sql="select nom,partis from candidat";
                Connection con = Connect.connect();
                PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs  = preparedStatement.executeQuery();
                        while(rs.next()) {
                                
                                T_Candidat uti = new T_Candidat();
				uti.setName(rs.getString(1));
                                uti.setParti(rs.getString(2));
                                list.add(uti);

                        }
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
                 
		return list;
               
	}
}
