package filter;

import interfaces.IEmail;

public class Countain extends Rule {

	String string;
	
	
	//Devuelve True si el campo del Email es igual a mi string.
	public boolean satisfy(IEmail e){
		
		return this.getString().contains(f.getField(e));
	}
	
	
	//Getters y Setters
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	
	//Constructor de Countain.
	public Countain(String s, Field f) {
		this.setString(s);
		this.setF(f);
		
	}


}