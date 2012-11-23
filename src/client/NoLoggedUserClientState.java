package client;

import java.util.List;

import server.Server;
import exceptions.AlreadyLoggedException;

public class NoLoggedUserClientState extends ClientState {

	@Override
	public void logIn(IClient client, String user, String password, Server e,
			IAccesType at) throws AlreadyLoggedException {
		client.setLoggedUser(new User(user,password,e,at));
		client.setClientState(new LoggedUserClientState());
	}

	@Override
	public void logOut(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createList(IClient client, String listName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToList(IClient client, IContact c, List<IContact> contacts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addList(IClient c, String listName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToList(IClient c, IContact cn, String listName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addContact(IClient c, String name, String userEmail) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(IClient c, IContact cn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void includes(IClient c, IContact cn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFolder(IClient c, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(IClient c, IFolder f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToFolder(IClient c, IFolder f, IEmail e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeFrom(IClient c, IFolder f, IEmail e) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IFolder> getFolders(IClient c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFilter(IClient c, Filter f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFilter(IClient c, Filter f, boolean exclusive) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(IClient c, Filter f) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Filter> getFilters(IClient c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExclusive(IClient c, Filter f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void askEmails(IClient client) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeEmail(IClient c, IHeader h, IBody b, IAttachment a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeEmail(IClient c, IHeader h, IBody b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeEmail(IClient c, IHeader h, IAttachment a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeEmail(IClient c, IHeader h) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEmail(IClient c, IEmail e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void includes(IClient c, IEmail e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(IClient c, IEmail e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void isReaded(IClient c, IEmail e) {
		// TODO Auto-generated method stub

	}

	@Override
	public IUser getUser(IClient c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void filtrar(IClient c, List<IEmail> es) {
		// TODO Auto-generated method stub

	}

}
