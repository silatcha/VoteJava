/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.BD.Connect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 12026
 */
public class forVote_controller implements Initializable  {
    
    Calendar cal = new GregorianCalendar();
	
	
	
	 @FXML
	    private Label type_elec;
	 
	 
	 @FXML
	    private AnchorPane pnitems;
	 
	    @FXML
	    private Button but_vote;
	    

	public Button getBut_vote() {
			return but_vote;
		}

	@FXML
    private TableView tab;
    
    ArrayList<T_Candidat> tes = new ArrayList<>();
    
    final ObservableList<T_Candidat> data = FXCollections.observableArrayList();
    	
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		TableColumn nam =new TableColumn("NOMS");
		TableColumn Parti =new TableColumn("PARTI POLITQUE");
		TableColumn selec =new TableColumn("VOTRE CHOIX");
		
		tab.getColumns().addAll(nam,Parti,selec);
		
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
	


    @FXML
    public Graphiks Vote(ActionEvent event)  {
    	
    	Graphiks graph = new Graphiks();
    	
    	for(T_Candidat indi:data) {
    		
    		if(indi.getSelect().isSelected()) {
    			
    			System.out.println("VOTE ENREGISTRER");
    			int minute = cal.get(Calendar.MINUTE);
    			int heure = cal.get(Calendar.HOUR_OF_DAY);
    			String temps = heure+"h"+minute;
    			Graphiks G = new Graphiks(indi,temps);// Ici on recupere la personne qui a ete vote et le temps du vote     			
    			
    			/*if(graph.getListe_vote().add(G)) {
    				System.out.println("ok");
    			}*/
    			return G;
    		}
    		//indi.getSelect().setSelected(false);
    		//break;
    		}
    	
    	
    	
    	return null;
    }
   
    
}
