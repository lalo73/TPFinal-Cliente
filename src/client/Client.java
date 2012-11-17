package client;

import java.util.List;

import server.Server;

public class Client implements IClient {

	private ClientState clientState;

	public Client(ClientState state) {
		this.setClientState(state);
	}

	public void logIn(String user, String password, Server server, IAccesType at) {
		this.getClientState().logIn(this, user, password, server, at);
	}

	@Override
	public void askEmails() {
		this.getClientState().askEmails(this);

	}

	@Override
	public void createList(String listName) {
		this.getClientState().createList(this, listName);
	}

	@Override
	public void addToList(IContact c, List<IContact> contacts) {
		this.getClientState().addToList(this, c, contacts);
	}

	@Override
	public List<IFolder> getFolders() {
		return this.getClientState().getFolders(this);
	}

	@Override
	public void sendEmail(IEmail e) {
		this.getClientState().sendEmail(this, e);
	}

	@Override
	public IUser getUser() {
		return this.getClientState().getUser(this);
	}

	public ClientState getClientState() {
		return clientState;
	}

	public void setClientState(ClientState clientState) {
		this.clientState = clientState;
	}

	@Override
	public void logIn(String user, String password, IServer e, IAccesType at) {
		// TODO Auto-generated method stub

	}

}
