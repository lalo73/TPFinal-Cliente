package filter;

import interfaces.IEmail;

public class Sender extends Field {

	public String getField(IEmail e){
		
		return e.getHead().getSender();
	}
	
	
}
