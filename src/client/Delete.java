package client;

import interfaces.IClient;
import interfaces.IEmail;
import exceptions.NoLoggedUserException;

public class Delete extends Action {

	
	public boolean act(IEmail e,IClient c) throws NoLoggedUserException{
		
		c.remove(e);
		return true; 
	}
	
	public boolean exclusive(){
		return true;
	}
	
	public void setExclusive(boolean b) throws Exception{
		throw new CantSetExclusiveException();
	}
	
}
