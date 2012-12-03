package filter;

import interfaces.IClient;
import interfaces.IEmail;

public class MarkRead extends Action {

	boolean exclusive;

	//Se encarga de marcar como leido a un Email
	public boolean act(IEmail e, IClient c) {
		e.setReaded(true);
		return false;
	}

	
	//Getters y Setters
	public boolean exclusive() {
		return exclusive;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	//Constructor de MarkRead
	public MarkRead(boolean b) {

		this.setExclusive(b);
	}

}
