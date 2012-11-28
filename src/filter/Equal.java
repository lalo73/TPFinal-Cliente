package filter;

import client.Rule;
import interfaces.IEmail;

public class Equal extends Rule {
	
	public Equal(String s, Field f) {
		this.seteString(s);
		this.setF(f);
	}

	String string;
	
	public boolean satisfy(IEmail e){
		
		return string.equals(this.getF().getField(e));
	}

	public String geteString() {
		return string;
	}

	public void seteString(String eString) {
		this.string = eString;
	}
	

	

}
