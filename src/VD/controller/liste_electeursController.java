/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.BD.Connect;
import VD.dao.UtilisateurBD;
import VD.model.Utilisateur;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 12026
 */
public class liste_electeursController implements Initializable {
    
        @FXML
         private AnchorPane pnitems;
      // les FXML de la table electeur
        @FXML
	 private TableView<Utilisateur> tablelec;
        @FXML
	 private TableColumn<Utilisateur,String> nom;
        @FXML
	 private TableColumn<Utilisateur,String> prenom;
        @FXML
	 private TableColumn<Utilisateur,String> adresse;
        @FXML
	 private TableColumn<Utilisateur,String> email;
        @FXML
	 private TableColumn<Utilisateur,Integer> tel;
        @FXML
	 private TableColumn<Utilisateur,Date> datenaiss;
        @FXML
	 private TableColumn<Utilisateur,String> profession;
        
       static int b = UtilisateurBD.getUtilisateurs().size();
       public ObservableList<Utilisateur> data = FXCollections.observableArrayList(); 
       
       
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
             tablelecteur();
    }
    
    
        
        public void  tablelecteur(){
	    	
	    	tablelec.getItems().clear();
			try {
				String sql="select nom,prenom,adresse,email,tel,datenaiss,profession from utilisateurs where mdp NOT IN ( select mdp from administrateur)";
				Connection con = Connect.connect();
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs  = preparedStatement.executeQuery();
				while(rs.next()) {
					data.add(new Utilisateur(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getDate(6),rs.getString(7)) );
				System.out.println(data.toString());
				
				}
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			nom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Nom"));
			prenom.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Prenom"));
			adresse.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Adresse"));
			email.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Email"));
			tel.setCellValueFactory(new PropertyValueFactory<Utilisateur,Integer>("telphone"));
			datenaiss.setCellValueFactory(new PropertyValueFactory<Utilisateur,Date>("datenaiss"));
			profession.setCellValueFactory(new PropertyValueFactory<Utilisateur,String>("Profession"));
			
			
			tablelec.setItems(data);
                        
	    }
	    
    
       public void retour(ActionEvent e)throws IOException,SQLException{
		  pnitems.getScene().getWindow().hide(); 
			}
}
                

