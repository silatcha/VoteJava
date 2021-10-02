/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.BD.Connect;
import static VD.controller.T_Candidat.count;
import static VD.controller.VoteFaitController.a;
import static VD.controller.liste_electeursController.b;
import VD.dao.T_CandidatBD;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import static java.util.Collections.list;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author p
 */
public class StatController implements Initializable{
    
    @FXML
    private Label message;
    @FXML
    private Label message1;
    @FXML TableColumn nam;
    @FXML TableColumn Parti;
    @FXML TableColumn selec;
     @FXML
	private Label type_elec;
	@FXML
	    private AnchorPane pnitems;
        @FXML
	    private Button but_vote;
    int a =9;
    int  c= count/a;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        message.setVisible(true);
        message1.setVisible(true);
        message.setText("Le total de votes:"+c);
       message1.setText("Le total d'electeurs:"+b);
    }
    
    
	Calendar cal = new GregorianCalendar();
	
	
	
	
	 
	  

	/*public Button getBut_vote() {
			return but_vote;
		}

	@FXML
    private TableView tab;
    
    ArrayList<T_Candidat> tes = new ArrayList<>();
    
    final ObservableList<T_Candidat> data = FXCollections.observableArrayList();
    		  
	    	
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
	
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		TableColumn nam =new TableColumn("NOMS");
		TableColumn Parti =new TableColumn("PARTI POLITQUE");
		TableColumn selec =new TableColumn("VOTRE CHOIX");
		
		tab.getColumns().addAll(nam,Parti,selec);
		
		
		nam.setCellValueFactory(new PropertyValueFactory<T_individu,String>("name"));
		Parti.setCellValueFactory(new PropertyValueFactory<T_individu,String>("parti"));
		selec.setCellValueFactory(new PropertyValueFactory<T_individu,CheckBox>("select"));
		
		tab.setItems(data);
		
	}
	


    @FXML
    public Graphiks Vote(ActionEvent event)  {
    	
    	Graphiks graph = new Graphiks();
    	
    	for(T_individu indi:data) {
    		
    		if(indi.getSelect().isSelected()) {
    			
    			System.out.println("VOTE ENREGISTRER");
    			int minute = cal.get(Calendar.MINUTE);
    			int heure = cal.get(Calendar.HOUR_OF_DAY);
    			String temps = heure+"h"+minute;
    			Graphiks G = new Graphiks(indi,temps);// Ici on recupere la personne qui a ete vote et le temps du vote     			
    			
    			/*if(graph.getListe_vote().add(G)) {
    				System.out.println("ok");
    			}
    			return G;
    		}
    		//indi.getSelect().setSelected(false);
    		//break;
    		}
    	
    	
    	
    	return null;
    }
    
    @FXML
    void stat(ActionEvent event)throws IOException {
    	

		Parent pane=FXMLLoader.load(getClass().getResource("/vue/admin.fxml"));
		Stage ac=new Stage();
		Scene sc=new Scene(pane);
		ac.setScene(sc);
		ac.show();
		pnitems.getScene().getWindow().hide();

    }
    */
}
