package client;

import java.util.ArrayList;

public abstract class Compound extends Rule{

	ArrayList<Rule>reglas=new ArrayList<Rule>();

	public ArrayList<Rule> getReglas() {
		return reglas;
	}

	public void setReglas(ArrayList<Rule> reglas) {
		this.reglas = reglas;
	}
	
	
	public Compound(ArrayList<Rule> r){
		this.setReglas(r);
	}
	
	
}
