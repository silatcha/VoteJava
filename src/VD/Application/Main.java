/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.Application;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author p
 */
public class Main extends Application{
    
    private double x,y;
	
	public void start(Stage primaryStage) {
		try {
                            Parent root = FXMLLoader.load(getClass().getResource("/VD/vue/page1.fxml"));
                        Scene scene = new Scene(root,967,677);
                        primaryStage.setScene(scene);
                        root.setOnMousePressed(event -> {
                          x = event.getSceneX();
                          y = event.getSceneY();                       
                        });
                        root.setOnMouseDragged(event -> {
                            primaryStage.setX(event.getScreenX()-x);
                            primaryStage.setX(event.getScreenY()-y);
                            
                        });
			primaryStage.show();	
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
