package filter;

import interfaces.IClient;
import interfaces.IEmail;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

public abstract class Action {

	public abstract boolean act(IEmail e, IClient c) throws NoLoggedUserException, CannotFindEmailException, Exception;
	
	public abstract boolean exclusive();
	
	public abstract void setExclusive(boolean b) throws Exception;
	
	
}
