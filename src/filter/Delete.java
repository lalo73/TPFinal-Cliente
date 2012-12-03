package filter;

import interfaces.IClient;
import interfaces.IEmail;
import exceptions.CantSetExclusiveException;

public class Delete extends Action {

	//Se encarga de que cliente borre el Email.
	public boolean act(IEmail e,IClient c) throws Exception{
		
		c.remove(e);
		return true; 
	}
	
    //Getters y Setters.
	public boolean exclusive(){
		//La accion Delete ya considera exclisiva.
		return true;
	}
	
	public void setExclusive(boolean b) throws Exception{
		throw new CantSetExclusiveException();
	}
	
}
