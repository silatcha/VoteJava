/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import static VD.controller.T_Candidat.count;
import static VD.controller.VoteFaitController.a;
import static VD.controller.liste_electeursController.b;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

/**
 *
 * @author 12026
 */
public class Dashboard_controller {
    
 

public class Dashboard_control {
	
	Calendar cal = new GregorianCalendar();
	
	Graphiks G;
	
	forVote_controller F;

	@FXML
    private Label ad;
	
	@FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;

    @FXML
    private LineChart<?, ?> LineChar;
    
    
    @FXML
    @SuppressWarnings({ "unchecked", "rawtypes" })
    void actualiser(ActionEvent event) {
    	
        a=9;
    	int  c= count/a;
    	XYChart.Series series = new XYChart.Series();
		
		
		
			

			series.getData().add(new XYChart.Data(c, b));

		

    }

	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}

}
