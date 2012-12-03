package filter;

import interfaces.IEmail;

public class Subject extends Field {
	
	//Se encarga de tomar el campo Subject del Head del Email.
	public String getField(IEmail e){
		
		return e.getHead().getSubject();
	}

}
