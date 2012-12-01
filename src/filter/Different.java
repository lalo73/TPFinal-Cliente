package filter;

import interfaces.IEmail;

public class Different extends Rule {



	String string;
	
	
	public boolean satisfy(IEmail e){
		
		return f.getField(e)!=string;
	}


	public String getString() {
		return string;
	}


	public void setString(String dString) {
		this.string = dString;
	}
	
	
	public Different(String s, Field f) {
        this.setString(s); 
		this.setF(f);		
	}

	}
	
	
	

