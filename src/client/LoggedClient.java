package client;

import java.util.List;

import exceptions.AlreadyLoggedException;

import server.Server;

public class LoggedClient extends ClientState {

	public void logIn(IClient client, String user, String password, Server e,
			IAccesType at) throws AlreadyLoggedException {
		throw new AlreadyLoggedException();

	}

	@Override
	public void askEmails(IClient client) {
		

	}

	public void createList(IClient client, String listName) {
		client.getFolders().add(new Folder(listName));

	}

	@Override
	public void addToList(IClient client, IContact c, List<IContact> contacts) {
		

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

	@Override
	public IUser getUser(IClient client) {
		// TODO Auto-generated method stub
		return null;
	}

}
