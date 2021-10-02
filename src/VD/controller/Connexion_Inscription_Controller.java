/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;


import VD.dao.AdministrateurBD;
import VD.dao.UtilisateurBD;
import VD.model.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

public class Connexion_Inscription_Controller implements Initializable {
	
	//interfaces
	    @FXML
            private  AnchorPane apane;
	    @FXML
	    private JFXPasswordField password;
	    @FXML
	    private JFXButton connecter;
	    @FXML
	    private JFXButton inscrire1;
	    @FXML
	    private JFXTextField  nom;
	    @FXML
	    private JFXTextField  prenom;
	    @FXML
	    private JFXTextField  adresse;
	    @FXML
	    private JFXTextField  tel;
             @FXML
	    private JFXTextField  mail;
	    @FXML
	    private JFXTextField  nomuti;
	    @FXML
	    private JFXTextField  cni;
	    @FXML
	    private JFXDatePicker datenaiss;
	    @FXML
	    private JFXComboBox <String> prof;
	    @FXML
	    private JFXButton inscrire;
	    @FXML
	    private JFXButton connecter1;
        @FXML
        private Label comptelabel;
        @FXML
        private Label message;
        @FXML
        private Label message1;
        @FXML
        private Label message11;
        @FXML
        private  Pane pn;
        @FXML
	    private Label inscrirelabel;
        @FXML
         private Label label1;
        @FXML
	private JFXTextField utilisateur;
        
        // codes
        
        private ObservableList<String> list = FXCollections.observableArrayList("Etudiante","Eleve","Medecin","Professeur");
        
        //codes interfaces
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		connecter1.setVisible(false);
		comptelabel.setVisible(false);
                
		RotateTransition slide1 = new RotateTransition();
		slide1.setDuration(Duration.seconds(3));
		slide1.setNode(label1);
		slide1.setByAngle(360);
                slide1.setDelay(Duration.seconds(0));
                slide1.setRate(3);
                slide1.setCycleCount(100);
		slide1.setAutoReverse(true);
		slide1.play();
                prof.setItems(list);
	}
	
	public void inscriptionSH(ActionEvent e)throws IOException,SQLException{
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(pn);
		slide.setToX(632);
		slide.play();
		
		pn.setTranslateX(632);
		
		utilisateur.clear();
		password.clear();
		connecter1.setVisible(true);
		comptelabel.setVisible(true);
		inscrire1.setVisible(false);
		inscrirelabel.setVisible(false);
		slide.setOnFinished((event->{
			
		}));
		
	}
	
	
	public void connecterSH(ActionEvent e)throws IOException,SQLException{
		TranslateTransition slide = new TranslateTransition();
		slide.setDuration(Duration.seconds(0.5));
		slide.setNode(pn);
		slide.setToX(0);
		slide.play();
		
		pn.setTranslateX(600);
		
		nom.clear();
		prenom.clear();
		adresse.clear();
		tel.clear();
		nomuti.clear();
		
		cni.clear();
		connecter1.setVisible(false);
		comptelabel.setVisible(false);
		inscrire1.setVisible(true);
		inscrirelabel.setVisible(true);
		slide.setOnFinished((event->{
			
		}));
		
	}
	
	
	//codes implementation
	
	

public static void printSQLException(SQLException ex) {
	for(Throwable e: ex) {
		if(e instanceof SQLException) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " +((SQLException) e).getSQLState());
			System.err.println("Error Code:" +((SQLException) e).getErrorCode());
			System.err.println("Message:" +e.getMessage());
			Throwable t = ex.getCause();
			while(t != null) {
				System.out.println("Cause :" +t);
				t = t.getCause();
			}
		}
		
	}
}
    
              ///////////connexion/////////////////////////
        //////////////////////////////////////////////
        ///////////////////////////////////////////////

       
	public void methode(ActionEvent event) throws SQLException {
    	
    	Window owner = connecter.getScene().getWindow();
    	System.out.println(utilisateur.getText());
    	System.out.println(password.getText());
    	
    	if(utilisateur.getText().isEmpty()) {
    		showAlert(Alert.AlertType.ERROR, owner,"Form Error!", "S'il vous plait entrer le nom d'utilisateur");
    		return;
    	}
    	
    	if(password.getText().isEmpty()) {
    		showAlert(Alert.AlertType.ERROR, owner,"Form Error!", "S'il vous plait entrer le mot de passe");
    		return;
    	}
    	
    	String Utilisateur1 = utilisateur.getText();
    	String Password1 = password.getText();
    	
        boolean flag;
        
        
        
        
            if(flag = AdministrateurBD.validate(Utilisateur1,Password1)) {
                    
    	             new ConnexionInscriptionScreen1().start(); 
                    
    	           }
            else if(flag = UtilisateurBD.validate(Utilisateur1,Password1)) {
               
                 new ConnexionInscriptionScreen().start(); 
                
            }
             else {
    		infoBox("S'il vous plait entrer un nom d'utilisateur et un mot de passe correct",null,"failed");
                 }
        
        }
        
        

	public  void infoBox(String infoMessage, String headerText,String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setContentText(infoMessage);
    	alert.setTitle(title);
    	alert.setHeaderText(headerText);
    	alert.showAndWait();
 
    }
    
    public void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.initOwner(owner);
    	alert.show();
    }
    
    	


//utilisateur
   class ConnexionInscriptionScreen extends Thread{
		
		@Override
		public void run () {
			
				try {
                                Thread.sleep(3000);

                                Platform.runLater(new Runnable() {

                            @Override
                             public void run () {
                                    Parent root = null;
                                    try {
                                             root = FXMLLoader.load(getClass().getResource("/VD/vue/Menu.fxml"));
                                             Scene scene = new Scene(root);
                                                Stage primaryStage = new Stage();
                                                primaryStage.setScene(scene);
                                                primaryStage.show();
                                                apane.getScene().getWindow().hide();
                                    }catch(IOException e) {
                                    Logger.getLogger(Connexion_Inscription_Controller.class.getName()).log(Level.SEVERE,null,e);
                                }

                                    
                                    }
                             
                                                        });
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Logger.getLogger(Connexion_Inscription_Controller.class.getName()).log(Level.SEVERE,null,e);
	
	          }
	
           }
		}
   
   
   //Admin
   class ConnexionInscriptionScreen1 extends Thread{
		
		@Override
		public void run () {
			
				try {
                                Thread.sleep(3000);

                                Platform.runLater(new Runnable() {

                            @Override
                             public void run () {
                                    Parent root = null;
                                    try {
                                             root = FXMLLoader.load(getClass().getResource("/VD/vue/MenuAdmin.fxml"));
                                    }catch(IOException e) {
                                    Logger.getLogger(Connexion_Inscription_Controller.class.getName()).log(Level.SEVERE,null,e);
                                }

                                    Scene scene = new Scene(root);
                                    Stage primaryStage = new Stage();
                                    primaryStage.setScene(scene);
                                    primaryStage.show();
                                    apane.getScene().getWindow().hide();
                                    }
                             
                                                        });
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Logger.getLogger(Connexion_Inscription_Controller.class.getName()).log(Level.SEVERE,null,e);
	
	          }
	
           }
		}
   
   
   
   
   /////////////////alertes//////////////////////////
   //////////////////////////////////////////////////
   public static void messageWarning() {
							Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Message");
				alert.setContentText("Il faut remplire tous les champs ");
				
				alert.showAndWait();

		}
   
   
   
   
   
   /////////////////////////verifications////////////////////
   ////////////////////////////////////////////////////////
   
    public  boolean verificationCompte() {
			 List<Utilisateur>list =UtilisateurBD.getUtilisateurs();//from sql 
			Map<String,String> map = new HashMap<String,String>();
			
			
			//remplir le Map
			for(Utilisateur a:list) {
				map.put(a.getNomuti(),a.getMdp());
			}
			
			//tester le mot de passe
			if(map.containsKey(nomuti.getText())) {return true;}
			else return false;
		}
   
   
   


            ///////////inscription/////////////////////////
        //////////////////////////////////////////////
        ///////////////////////////////////////////////


		//fonction inscrire

		public void inscrire(ActionEvent e) throws IOException,SQLException{
			message1.setVisible(false);
			message.setVisible(false);
			message11.setVisible(false);
                        
                        
                       
                        
                        if(nom.getText().isEmpty() || prenom.getText().isEmpty() || adresse.getText().isEmpty() || tel.getText().isEmpty() || cni.getText().isEmpty() || nomuti.getText().isEmpty() || mail.getText().isEmpty() ) {

                                messageWarning();
                                return;
                        }

                            if (datenaiss.getValue()== null  || prof.getValue()==null){
                                messageWarning();
                                return;
                            }
                        else {


                        if(this.verificationCompte()) {
                                message.setVisible(true);
                                message.setText("Le nom d'utilisateur est deja utilise.");
                                return;
                        }

                        else {
                                //enregistrer les informations
                                Utilisateur adh= new Utilisateur();
                                String  motpass;
                                int statut ;
                                
                                adh.setNom(nom.getText());
                                adh.setPrenom(prenom.getText());
                                adh.setAdresse(adresse.getText());
                                adh.setEmail(mail.getText());
                                adh.setMdp(cni.getText());                             
                                adh.setTelphone(Integer.parseInt(tel.getText()));
                                adh.setNomuti(nomuti.getText());
                                adh.setDatenaiss(Date.valueOf(datenaiss.getValue()));
                                adh.setProfession(prof.getValue());

                               
                                motpass= adh.getMdp();
                                statut = UtilisateurBD.save(adh);

                                if(statut>0) {
                                        message1.setVisible(true);
                                        message11.setVisible(true);
                                        message1.setText("Vous etes inscrit, votre mot de passe est : ");
                                        message11.setText(motpass);
                                }else {
                                message.setVisible(true);
                                message.setText("Desole, il ya un probleme.");
                                }

                        }



        }
        }		
}		