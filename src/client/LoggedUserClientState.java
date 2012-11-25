package client;

import java.util.List;

import exceptions.AlreadyLoggedException;

import server.Server;

public class LoggedUserClientState extends ClientState {

	@Override
	public void askEmails(IClient client) {
		// TODO Auto-generated method stub

	}

	public void createList(IClient client, String listName) {
		client.getContancts().add(new ContactList(listName));

	}

	public IUser getUser(IClient client) {
		return client.getLoggedUser();
	}

	public void logIn(IClient client, String user, String password, Server e, IAccesType at) throws AlreadyLoggedException {
		throw new AlreadyLoggedException();
	}

	public void addToList(IClient client, IContact c, List<IContact> contacts) {
		contacts.add(c);
	}

	public List<IFolder> getFolders(IClient client) {
		
		return null;
	}

	@Override
	public void sendEmail(IClient client, IEmail e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logOut(Client client) {
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
	public boolean includes(IClient c, IEmail e) {
		return false;
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
	public void filtrar(IClient c, List<IEmail> es) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(Client client, IEmail e, IFolder f) {
		// TODO Auto-generated method stub
		return false;
	}

}
