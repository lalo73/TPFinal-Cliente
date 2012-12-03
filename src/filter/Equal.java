package filter;

import interfaces.IEmail;

public class Equal extends Rule {
	
	String string;
	
	//Devuelve True si el campo del Email es igual a mi string.
	public boolean satisfy(IEmail e){
		
		return this.geteString().equals(this.getF().getField(e));
	}

	
	//Getters y Setters.
	public String geteString() {
		return string;
	}

	public void seteString(String eString) {
		this.string = eString;
	}
	

	//Constructor de Equal.
	public Equal(String s, Field f) {
		this.seteString(s);
		this.setF(f);
	}	

}
