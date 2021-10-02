/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;


import VD.BD.Connect;
import VD.dao.ScrutinBD;
import VD.dao.UtilisateurBD;
import VD.model.Scrutin;
import VD.model.Utilisateur;
import animatefx.animation.Bounce;
import animatefx.animation.BounceIn;
import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author 12026
 */
public class MenuController implements Initializable{
    
    //variables
    private  Utilisateur cmpt;
    private ScrutindemController src;
    
        @FXML
	private Label vote;
	@FXML
	private Circle cercle;
        @FXML
        private VBox vboxcont=null;
        @FXML
        private FontAwesomeIconView clock;
        @FXML
        private Label cif;
        @FXML
        private Circle boule;
        @FXML
        private Label notif;
        @FXML
        private Hyperlink lien;
        @FXML
        private AnchorPane pnitems;
        @FXML
        private Button help;
        @FXML
        private ScrollPane scroll;
        @FXML
        private Pane param;
        @FXML
        private Pane aide;
        @FXML
	private JFXTextField oldmotpass;
        @FXML
	private JFXTextField newmotpass;
        int a=0;
      
      
       @Override
	public void initialize(URL arg0, ResourceBundle arg1)  {
         
                // TODO Auto-generated method stub
                
                
                TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(1.5));
                slide.setNode(vote);
                slide.setToX(675);
                slide.setCycleCount(300);
                slide.setAutoReverse(true);
                slide.play();
                vote.setTranslateX(670);
                List<Scrutin>list =ScrutinBD.getScrutin();
                
                for(int i=0; i<list.size();i++){
                    list.get(i);
                    a++;
                }
                if(list.isEmpty()){
                    notif.setVisible(false);
                    
                   clock.setVisible(false);
                }
                
                else{
                    notif.setVisible(true);
                    
                   clock.setVisible(true);
                   new Bounce (clock).setDelay(Duration.minutes(5));
                   new Bounce (clock).play();
                   notif.setText(" Le nombre de scrutin en cours : " +a);
                }
                
                try {
                    Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/bienvenue.fxml"));
                    vboxcont.getChildren().add(node);
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               try {
                    Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/vote.fxml"));
                    vboxcont.getChildren().add(node);
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/sond.fxml"));
                    vboxcont.getChildren().add(node);
                } catch (IOException ex) {
                    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/Details.fxml"));
                vboxcont.getChildren().add(node);
                } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                slide.setOnFinished((event->{
                }));
                
            }
           
        
    
        public void deconnecter(ActionEvent e)throws IOException,SQLException{
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
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/ConnexionETInscription.fxml"));
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
        
         public void aide(ActionEvent e)throws IOException,SQLException{
             
                param.setVisible(false);
                scroll.setVisible(false);
                aide.setVisible(true);
		/* try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/help.fxml"));
                vboxcont.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
                
            }*/
                 
			}
         
          public void home(ActionEvent e)throws IOException,SQLException{
             
                param.setVisible(false);
                scroll.setVisible(true);
                aide.setVisible(false);
		
			}
         
         
        public void compte(ActionEvent e)throws IOException,SQLException{
                aide.setVisible(false);
                scroll.setVisible(false);
                param.setVisible(true);
		
			}
        
        
        
       
           
       }
        


