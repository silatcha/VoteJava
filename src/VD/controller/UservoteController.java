/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author p
 */
public class UservoteController {
    
    @FXML
    private AnchorPane pnitems;
    
        
         public void passagepartis(ActionEvent e)throws IOException,SQLException{
            new MenuScreen2().start(); 
			}
       
        class MenuScreen2 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(1000);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/partis.fxml"));
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
        
        public void passageelections(ActionEvent e)throws IOException,SQLException{
            new MenuScreen3().start(); 
			}
       
        class MenuScreen3 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(500);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/ElectionsenCours.fxml"));
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
        
        
        public void passagecandidats(ActionEvent e)throws IOException,SQLException{
            new MenuScreen4().start(); 
			}
       
        class MenuScreen4 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(500);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/candidats.fxml"));
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
        
        
        public void passage(ActionEvent e)throws IOException,SQLException{
             pnitems.getScene().getWindow().hide();
			}
        public void passagevote(ActionEvent e)throws IOException,SQLException{
                 new MenuScreen5().start();
			}
       
        class MenuScreen5 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(500);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/votefait.fxml"));
                                            }catch(IOException e) {
                                            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);
                                        }

                                            Scene scene = new Scene(root);
                                            Stage primaryStage = new Stage();
                                            primaryStage.setScene(scene);
                                            primaryStage.show();
                                            //pnitems.getScene().getWindow().hide();
                                            
                                     
                                            }
                                            
                                                    });

                            } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);

              }

       }
    }
        
         public void passagedetails(ActionEvent e)throws IOException,SQLException{
                 new MenuScreen6().start();
			}
       
        class MenuScreen6 extends Thread{
		
		@Override
		public void run () {
			
                            try {
                            Thread.sleep(500);

                            Platform.runLater(new Runnable() {

                                    @Override
                                     public void run () {
                                            Parent root = null;
                                            
                                            try {
                                                     root = FXMLLoader.load(getClass().getResource("/VD/vue/DetailsCandidats.fxml"));
                                            }catch(IOException e) {
                                            Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);
                                        }

                                            Scene scene = new Scene(root);
                                            Stage primaryStage = new Stage();
                                            primaryStage.setScene(scene);
                                            primaryStage.show();
                                           // pnitems.getScene().getWindow().hide();
                                            
                                     
                                            }
                                            
                                                    });

                            } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);

              }

       }
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
                                           // pnitems.getScene().getWindow().hide();
                                            
                                     
                                            }
                                            
                                                    });

                            } catch (InterruptedException e) {
                                    // TODO Auto-generated catch block
                                    Logger.getLogger(MenuAdminController.class.getName()).log(Level.SEVERE,null,e);

              }

       }
    }   
}
