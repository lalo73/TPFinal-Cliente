package client;

import exceptions.NoLoggedUserException;

public class MoveToFolder extends Action {

	Folder f;

	public Folder getF() {
		return f;
	}

	public void setF(Folder f) {
		this.f = f;
	}

	public void act(IEmail e, IClient c) throws NoLoggedUserException {

		c.addToFolder(this.getF(), e);

	}

}
