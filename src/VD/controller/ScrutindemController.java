/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import static VD.controller.Connexion_Inscription_Controller.messageWarning;
import VD.dao.ScrutinBD;
import VD.dao.UtilisateurBD;
import VD.model.Scrutin;
import VD.model.Utilisateur;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author p
 */
public class ScrutindemController implements Initializable  {
    
    @FXML
    private JFXComboBox <String> type;
    @FXML
    private JFXTextField nombrecand;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXDatePicker ddebut;
    @FXML
    private JFXDatePicker ddfin;
    @FXML
    private Label message;
    @FXML
    private Label message1;
    @FXML
    private Label message11;
    
     // codes
        
        private ObservableList<String> list = FXCollections.observableArrayList("Presidentielle","Legislative","Municipale");
     
     
        
        @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		                type.setItems(list);
	}
	
        
        
        
     /////////////////alertes//////////////////////////
   //////////////////////////////////////////////////
                        public static void messageWarning() {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Message");
				alert.setContentText("Il faut remplire tous les champs ");
				
				alert.showAndWait();

		         }
                        
     
   /////////////////////////verifications////////////////////
   ////////////////////////////////////////////////////////
   
    public  boolean verificationScrutin() {
			 List<Scrutin>list =ScrutinBD.getScrutin();//from sql 
			 Map<Date,Date> map = new HashMap<Date,Date>();
			 Map<String,String> map1 = new HashMap<String,String>();
			
			//remplir le Map
			for(Scrutin a:list) {
				map.put(a.getDate_debut(),a.getDate_fin());
                                map1.put(a.getId(), a.getType());
			}
			
			//tester le nom
			if(map1.containsKey(nom.getText()) || ( map.containsKey(ddebut.getValue()) && map.containsKey(ddfin.getValue()) )) {return true;}
			else return false;
                      
		}                   
     
     public String demarrerscrutin() {
			message1.setVisible(false);
			message.setVisible(false);
			message11.setVisible(false);
                        
                        
                       
                        
                        if(nombrecand.getText().isEmpty() || nom.getText().isEmpty() ) {
                             messageWarning();
                             
                        }

                            if (ddebut.getValue()== null  || type.getValue()==null|| ddfin.getValue()== null){
                                messageWarning();
                              
                            }
                        else {


                        if(this.verificationScrutin()) {
                                message.setVisible(true);
                                message.setText("Le nom du scrutin et/ou les dates sont deja utilises.");
                                
                        }

                        else {
                                //enregistrer les informations
                                Scrutin adh= new Scrutin();
                                String  motpass;
                                int statut ;
                                
                                adh.setId(nom.getText());
                                adh.setNombre_candidats(Integer.parseInt(nombrecand.getText()));
                                adh.setDate_debut(Date.valueOf(ddebut.getValue()));
                                adh.setDate_fin(Date.valueOf(ddfin.getValue()));
                                adh.setType(type.getValue());

                               
                                if(ddebut.getValue().isBefore(ddfin.getValue())  ){
                                statut = ScrutinBD.save(adh);
                                          
                                //statut = ScrutinBD.save(adh);

                                if(statut>0) {
                                        message1.setVisible(true);
                                        message.setVisible(false);
                                        message11.setVisible(false);
                                        message1.setText("Vous avez demarre un scrutin ");
                                        
                                }else {
                                message.setVisible(true);
                                message1.setVisible(false);
                                message11.setVisible(false);
                                message.setText("Desole, il ya un probleme.");
                                }
                                }
                                else{
                                      message11.setVisible(true);
                                      message1.setVisible(false);
                                      message.setVisible(false);                
                                      message11.setText("Erreur sur les dates.");
                                }
                        }



        }
            return "Un Scrutin a  demarre ";  
     }
     
     public String affichage(){
         demarrerscrutin();
      return "Un Scrutin a  demarre ";   
     }
}
