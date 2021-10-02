package VD.BD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author p
 */
public class Connect {
	
	private static final String DATABASE_URL="jdbc:mysql://localhost:3306/bd_elections?useUnicode=true&useJDBCCompilantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DATABASE_USERNAME="root";
	private static final String DATABASE_PASSWORD="";
	
	
	
private  static Connection connect;
	
	public static  Connection connect() {
		try {
			
			connect = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Chargement reussi");
		}
		return connect;
		
	}
	
	
}
