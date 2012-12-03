package filter;

import interfaces.IEmail;

public abstract class Field {
	
	
	//Metodo a implementar por:Sender,Subjetc y Date.
	public abstract String getField(IEmail e);

}
