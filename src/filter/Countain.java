package filter;

import interfaces.IEmail;

public class Countain extends Rule {

	String string;
	
	public boolean satisfy(IEmail e){
		
		return this.getString().contains(f.getField(e));
	}
	
	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public Countain(String s, Field f) {
		this.setString(s);
		this.setF(f);
		
	}


}