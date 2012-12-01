package filter;

import client.Folder;
import interfaces.IClient;
import interfaces.IEmail;
import exceptions.NoLoggedUserException;

public class MoveToFolder extends Action {

	Folder f;
	boolean exclusive;

	public Folder getF() {
		return f;
	}

	public void setF(Folder f) {
		this.f = f;
	}

	public boolean act(IEmail e, IClient c) throws NoLoggedUserException {

		c.addToFolder(this.getF(), e);
		return false;

	}

	public void setExclusive(boolean b) {
		this.exclusive = b;
	}

	public boolean exclusive() {
		return exclusive;
	}

	public MoveToFolder(Folder f, boolean b) {
		this.setF(f);
		this.setExclusive(b);

	}

}
