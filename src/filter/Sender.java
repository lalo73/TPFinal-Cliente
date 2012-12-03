package filter;

import interfaces.IEmail;

public class Sender extends Field {

	
	
	//Se encarga de tomar el campo Sender del Head del Email.
	public String getField(IEmail e){
		
		return e.getHead().getSender();
	}
	
	
}
