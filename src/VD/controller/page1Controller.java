package VD.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


import animatefx.animation.BounceIn;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class page1Controller implements Initializable {
	
	@FXML
    private  AnchorPane apane;
	@FXML
    private Label vote;
	@FXML
	private Label label1;
	@FXML
	private Circle cercle;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		TranslateTransition slide = new TranslateTransition();
		
		slide.setDuration(Duration.seconds(1.5));
		slide.setNode(vote);
		slide.setToX(-250);
		slide.play();
		
		vote.setTranslateX(-250);
		
		
		slide.setOnFinished((event->{
        new BounceIn(vote).play();
            	
     		})); 
		RotateTransition slide1 = new RotateTransition();
		slide1.setDuration(Duration.seconds(3));
		slide1.setNode(label1);
		slide1.setByAngle(360);
		slide1.setAutoReverse(true);
		slide1.play();
		
         new Page1Screen().start(); 
	}
	
	

	class Page1Screen extends Thread{
		
		@Override
		public void run () {
			
				try {
					Thread.sleep(3000);
					
					Platform.runLater(new Runnable() {
				
						@Override
						 public void run () {
							Parent root = null;
							try {
								 root = FXMLLoader.load(getClass().getResource("/VD/vue/ConnexionETInscription.fxml"));
							}catch(IOException e) {
							Logger.getLogger(page1Controller.class.getName()).log(Level.SEVERE,null,e);
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
					Logger.getLogger(page1Controller.class.getName()).log(Level.SEVERE,null,e);
	
	          }
	
           }
		}
	}
