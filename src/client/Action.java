package client;

import exceptions.NoLoggedUserException;

public abstract class Action {

	public abstract void act(IEmail e, IClient c) throws NoLoggedUserException;
	
	
}
