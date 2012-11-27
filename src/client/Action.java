package client;

import interfaces.IClient;
import interfaces.IEmail;
import exceptions.NoLoggedUserException;

public abstract class Action {

	public abstract boolean act(IEmail e, IClient c) throws NoLoggedUserException;
	
	public abstract boolean exclusive();
	
	public abstract void setExclusive(boolean b) throws Exception;
	
	
}
