/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.BD.Connect;
import static VD.controller.VoteFaitController.a;
import VD.dao.CandidatBD;
import VD.model.Candidat;
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
import static java.util.Collections.list;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author p
 */
public class VoteFaitController implements Initializable{
    
    @FXML
    private Label type_elec;
     @FXML
    private Label message;
    @FXML
    private TableView tab;
    @FXML TableColumn nam;
    @FXML TableColumn Parti;
    @FXML TableColumn selec;
        @FXML
        private AnchorPane pnitems;
    
    static int a;
    
    ArrayList<T_Candidat> tes = new ArrayList<>();
    
    final ObservableList<T_Candidat> data = FXCollections.observableArrayList( );
    
    
    	@SuppressWarnings({ "rawtypes", "unchecked" })	 
	 public void  tablvote(){
	    	
		 nam =new TableColumn("NOMS");
		Parti =new TableColumn("PARTI POLITQUE");
		selec =new TableColumn("VOTRE CHOIX");
                
                tab.getColumns().addAll(nam,Parti,selec);
                
	    	tab.getItems().clear();
			try {
		String sql="select nom,partis from candidat";
                Connection con = Connect.connect();
                PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs  = preparedStatement.executeQuery();
                        while(rs.next()) {
                                 data.add(new T_Candidat(rs.getString(1), rs.getString(2)) );
                                System.out.println(data.toString());
                                T_Candidat uti = new T_Candidat();
				
                        }
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		nam.setCellValueFactory(new PropertyValueFactory<T_Candidat,String>("name"));
		Parti.setCellValueFactory(new PropertyValueFactory<T_Candidat,String>("parti"));
		selec.setCellValueFactory(new PropertyValueFactory<T_Candidat,CheckBox>("select"));
			
			
			tab.setItems(data);
                        
	    }
	    
    
    int c = data.size();
     
                 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		tablvote();
		
	}
	
  

    @FXML
    public T_Candidat Vote(ActionEvent event) {
    	
    	
    	for(T_Candidat indi:data) {
    		
    		if(indi.getSelect().isSelected()) {
    			System.out.println("VOTE ENREGISTRER");
                        message.setVisible(true);
                        message.setText("VOTE ENREGISTRER");
    			System.out.println(indi.toString());
    			return indi;
    		}
    		//indi.getSelect().setSelected(false);
    		//break;
    		}
    	
    	return null;
    	
    }
     
     
     public void passagestat(ActionEvent e)throws IOException,SQLException{
                 new MenuScreen7().start();
			}
       
        class MenuScreen7 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(500);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/Stat.fxml"));
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
