package client;

import interfaces.IEmail;

public class Countain extends Rule {

	
	public Countain(String s, Field f) {
		super(s, f);
		
	}

	String string;
	
	public boolean satisfy(IEmail e){
		
		return string.contains(f.getField(e));
	}
	
	public String getcString() {
		return string;
	}

	public void setcString(String cString) {
		this.string = cString;
	}
	


}