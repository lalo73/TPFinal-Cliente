package filter;

import java.util.ArrayList;

import client.Rule;

public abstract class Compound extends Rule{

	ArrayList<Rule>reglas=new ArrayList<Rule>();

	public ArrayList<Rule> getReglas() {
		return reglas;
	}

	public void setReglas(ArrayList<Rule> reglas) {
		this.reglas = reglas;
	}
	
	
	public Compound(ArrayList<Rule> r){
		super();
		this.setReglas(r);
	}
	
	
}
