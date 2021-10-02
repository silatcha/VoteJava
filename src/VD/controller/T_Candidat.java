/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VD.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author p
 */
public class T_Candidat {
    
    	
	private final SimpleStringProperty name;
	private final SimpleStringProperty parti;
	private  CheckBox select;
        static int count=0;
     
	public T_Candidat(String name, String parti) {
		super();
		this.name = new SimpleStringProperty(name);
		this.parti = new SimpleStringProperty(parti);
		this.select=new CheckBox();
                count++;
	}

           
        public T_Candidat(){
            this.name = null;
		this.parti =null;
        }
	
	
	public String getName() {
		return name.toString();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getParti() {
		return parti.get();
	}

	public void setParti(String parti) {
		this.parti.set(parti);;
	}

	public CheckBox getSelect() {
		return select;
	}

	public void setSelect(CheckBox select) {
		this.select = select;
	}



	@Override
	public String toString() {
		return "T_Candidat[name=" + name + ", parti=" + parti + "]";
	}
	
	
	

}

