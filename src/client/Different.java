package client;

import interfaces.IEmail;

public class Different extends Rule {

	public Different(String s, Field f) {
		super(s, f);
		
	}


	String string;
	
	
	public boolean satisfy(IEmail e){
		
		return f.getField(e)!=string;
	}


	public String getdString() {
		return string;
	}


	public void setdString(String dString) {
		this.string = dString;
	}
	
	
	}
	
	
	

