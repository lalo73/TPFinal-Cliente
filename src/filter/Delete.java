package filter;

import interfaces.IClient;
import interfaces.IEmail;
import exceptions.CantSetExclusiveException;

public class Delete extends Action {

	
	public boolean act(IEmail e,IClient c) throws Exception{
		
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
