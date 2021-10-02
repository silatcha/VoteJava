/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.BD.Connect;
import VD.dao.ScrutinBD;
import VD.model.Scrutin;
import VD.model.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
 * @author p
 */
public class ElectionsenCoursController implements Initializable {
    
    @FXML
         private AnchorPane pnitems;
      // les FXML de la table electeur
        @FXML
	 private TableView<Scrutin> tablelec;
        @FXML
	 private TableColumn<Scrutin,String> nom;
        @FXML
	 private TableColumn<Scrutin,String> type;
        @FXML
	 private TableColumn<Scrutin,Integer> nombre;
        @FXML
	 private TableColumn<Scrutin,Date> ddebut;
      @FXML
	 private TableColumn<Scrutin,Date> ddfin;
     
       public ObservableList<Scrutin> data = FXCollections.observableArrayList(); 
       
       
       
    @Override
    public void initialize(URL location, ResourceBundle resources) {
             tableScrutin();
    }
       
       
  public void retour(ActionEvent e)throws IOException,SQLException{
		 new MenuScreen().start(); 
			}
  
        
        class MenuScreen extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(1000);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/user_vote.fxml"));
                                            }catch(IOException e) {
                                            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE,null,e);
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
                                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE,null,e);

              }

       }
                
		}
     public void  tableScrutin(){
	    	
	    	
			try {
				String sql="select * from Scrutin ";
				Connection con = Connect.connect();
				PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs  = preparedStatement.executeQuery();
				while(rs.next()) {
					data.add(new Scrutin(rs.getString(1), rs.getInt(2), rs.getDate(3),rs.getDate(4), rs.getString(5) ));
				System.out.println(data.toString());
				
				}
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			nom.setCellValueFactory(new PropertyValueFactory<Scrutin,String>("id"));
                        nombre.setCellValueFactory(new PropertyValueFactory<Scrutin,Integer>("nombre_candidats"));
                        ddebut.setCellValueFactory(new PropertyValueFactory<Scrutin,Date>("date_debut"));
			ddfin.setCellValueFactory(new PropertyValueFactory<Scrutin,Date>("date_fin"));
			type.setCellValueFactory(new PropertyValueFactory<Scrutin,String>("type"));
			
			
			
			
			
			tablelec.setItems(data);
                        
	    }
	    
    
}
