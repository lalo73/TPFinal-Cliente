package client;

import exceptions.NoLoggedUserException;

public class Delete extends Action {

	
	public void act(IEmail e,IClient c) throws NoLoggedUserException{
		
		c.remove(e);
		
	}
	
	
	
}
