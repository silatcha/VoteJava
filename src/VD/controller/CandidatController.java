/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.BD.Connect;
import java.util.ArrayList;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import VD.model.Candidat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author p
 */
public class CandidatController implements Initializable{
    

@FXML private Button retour;
@FXML private Label candidat1;
@FXML private Label candidat2;
@FXML private Label candidat3;
@FXML private Label candidat4;
@FXML private Label candidat5;
@FXML private Label candidat6;
@FXML private Label candidat7;
@FXML private Label candidat8;
@FXML private Label candidat9;
@FXML private TextField nom;
@FXML private TextField prenom;
@FXML private TextField partis;
@FXML private TextField email;
@FXML private TextField sexe;
@FXML private TextField ville;
@FXML private TextField nationalite;
@FXML
    private AnchorPane pnitems;

private ArrayList<Candidat> list = new ArrayList<Candidat>();
private ArrayList<Label> lists = new ArrayList<>();
ArrayList<Candidat> liste = new ArrayList<Candidat>();
ArrayList<Label> listes = new ArrayList<>();

  @Override
public void initialize(URL location, ResourceBundle resources) {
	
	try {
		
		Connection con = Connect.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT nom,prenom,partis,sexe,ville,nationalite FROM `candidat`");
		while(rs.next()) {
		list.add( new Candidat(rs.getString("nom"),rs.getString("prenom"),rs.getString("partis"),rs.getString("sexe"),rs.getString("ville"),rs.getString("nationalite")));
		lists.add(candidat1);
		lists.add(candidat2);
		lists.add(candidat3);
		lists.add(candidat4);
		lists.add(candidat5);
		lists.add(candidat6);
		lists.add(candidat7);
		lists.add(candidat8);
		lists.add(candidat9);
		}
		for(int i=0;i<list.size();i++) {
			lists.get(i).setText(list.get(i).toString());;
		}
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void vers_retour(ActionEvent me) {
		new MenuScreen3().start(); 
	}

  
       
        class MenuScreen3 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(500);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/user_vote.fxml"));
                                            }catch(IOException e) {
                                            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);
                                        }

                                            Scene scene = new Scene(root);
                                            Stage primaryStage = new Stage();
                                            primaryStage.setScene(scene);
                                            primaryStage.show();
                                            pnitems.getScene().getWindow().hide();
                                            
                                     
                                            }
                                            
                                                    });

                            } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);

              }

       }
    }
    
}

