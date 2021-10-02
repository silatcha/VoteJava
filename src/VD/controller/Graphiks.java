/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;

/**
 *
 * @author 12026
 */
public class Graphiks {
    
    	
	private T_Candidat indi;
	
	private String time;
	private static int count;
	private ArrayList<Graphiks> liste_vote;

	

	public Graphiks(T_Candidat indi, String time) {
		super();
		this.indi = indi;
		this.time = time;
		count++;
	}

	public Graphiks() {
		super();
		// TODO Auto-generated constructor stub
	}

	public T_Candidat getIndi() {
		return indi;
	}


	public String getTime() {
		return time;
	}


	public int nombre_vote() {
		
		return count;
	}

	public ArrayList<Graphiks> getListe_vote() {
		return liste_vote;
	}

	@Override
	public String toString() {
		return "Graphiks [indi=" + indi + ", time=" + time + "]";
	}
	
	
	
	
}
