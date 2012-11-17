package client;

import java.util.List;

import exceptions.AlreadyLoggedException;

import server.Server;

public class LoggedUser extends ClientState {

	@Override
	public void askEmails(IClient client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createList(IClient client, String listName) {
		// TODO Auto-generated method stub

	}

	@Override
	public IUser getUser(IClient client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logIn(IClient client, String user, String password, Server e, AccesType at) {
		throw new AlreadyLoggedException();
	}

	@Override
	public void addToList(IClient client, IContact c, List<IContact> contacts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IFolder> getFolders(IClient client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEmail(IClient client, IEmail e) {
		// TODO Auto-generated method stub
		
	}

}
