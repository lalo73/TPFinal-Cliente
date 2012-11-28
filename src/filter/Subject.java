package filter;

import interfaces.IEmail;

public class Subject extends Field {
	
	
	public String getField(IEmail e){
		
		return e.getHead().getSubject();
	}

}
