/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import VD.model.Utilisateur;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author p
 */
public class MenuAdminController implements Initializable {
    
     
    
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

    public AnchorPane getPnitems() {
        return pnitems;
    }
        
        
        
    
            //variables
           private  Utilisateur cmpt;
        
        @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
                
                lien.setVisible(false);
                notif.setVisible(false);
                boule.setVisible(false); 
                cif.setVisible(false);  
                clock.setVisible(false); 
               
		TranslateTransition slide = new TranslateTransition();
                slide.setDuration(Duration.seconds(1.5));
		slide.setNode(vote);
		slide.setToX(675);
                slide.setCycleCount(300);
                slide.setAutoReverse(true);
		slide.play();
		vote.setTranslateX(670);
                
            try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/bienvenue.fxml"));
                vboxcont.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/candidats.fxml"));
                vboxcont.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
             */try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/sond.fxml"));
                vboxcont.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
              try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/vote1.fxml"));
                vboxcont.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
             try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/electeurs.fxml"));
                vboxcont.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            } 
             try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/scrutin.fxml"));
                vboxcont.getChildren().add(node);
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            } 
             try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/totalvote.fxml"));
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
		/* try {
                Node node = (Node)FXMLLoader.load(getClass().getResource("/VD/vue/parametre.fxml"));
                vboxcont.getChildren().add(node);
                
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
		*/	}
        
        
        
        ////////////////////////Modifier les informations du profile///////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////
        
        //Mot de passe
/*public void motpassModif(ActionEvent e )throws IOException,ParseException{
		Utilisateur cmp = new Utilisateur();
		if(oldmotpass.getText().equals(cmpt.getMdp())) {
				cmp.setMdp(newmotpass.getText());
					int statue = UtilisateurBD.motpassModif(cmp,1);
					if(statue>0) {
						motpassmodifsucce.setText("Vous avez modifier votre mot de passe");
						motpassmodifechec.setVisible(false);
					}else {
						motpassmodifechec.setText("Erreur technique");
						motpassmodifsucce.setVisible(false);
					}
				}
			else {
				motpassmodifechec.setText("Mot de pass different.");
				motpassmodifsucce.setVisible(false);
			}
			}
		else {
			motpassmodifechec.setText("Mot de passe incorrect");
			motpassmodifsucce.setVisible(false);
		}
		
	}
        
   */     
        
}
