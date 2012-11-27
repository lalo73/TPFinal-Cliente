package client;

import interfaces.IEmail;

public class Equal extends Rule {
	
	public Equal(String s, Field f) {
		super(s, f);
	}

	String string;
	
	public boolean satisfy(IEmail e){
		
		return string.equals(f.getField(e));
	}

	public String geteString() {
		return string;
	}

	public void seteString(String eString) {
		this.string = eString;
	}
	

	

}
