package client;

import interfaces.IAccesType;
import interfaces.IAttachment;
import interfaces.IBody;
import interfaces.IClient;
import interfaces.IContact;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;
import interfaces.IUser;

import java.util.List;

import server.Server;
import exceptions.AlreadyLoggedException;
import exceptions.NoLoggedUserException;

public class NoLoggedUserClientState extends ClientState {

	@Override
	public void logIn(IClient client, String user, String password, Server e,
			IAccesType at) throws AlreadyLoggedException {
		client.setLoggedUser(new User(user, password, e, at));
		client.setClientState(new LoggedUserClientState());
	}

	@Override
	public void logOut(Client client) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void createList(IClient client, String listName)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addToList(IClient client, IContact c, List<IContact> contacts)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addList(IClient c, String listName)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addToList(IClient c, IContact cn, String listName)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addContact(IClient c, String name, String userEmail)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void remove(IClient c, IContact cn) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void includes(IClient c, IContact cn) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addFolder(IClient c, String name) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void remove(IClient c, IFolder f) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addToFolder(IClient c, IFolder f, IEmail e)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void removeFrom(IClient c, IFolder f, IEmail e)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public List<IFolder> getFolders(IClient c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addFilter(IClient c, Filter f) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addFilter(IClient c, Filter f, boolean exclusive)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void remove(IClient c, Filter f) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public List<Filter> getFilters(IClient c) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public boolean isExclusive(IClient c, Filter f)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void askEmails(IClient client) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void makeEmail(IClient c, IHeader h, IBody b, IAttachment a)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void makeEmail(IClient c, IHeader h, IBody b)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void makeEmail(IClient c, IHeader h, IAttachment a)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void makeEmail(IClient c, IHeader h) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void sendEmail(IClient c, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public boolean includes(IClient c, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void remove(IClient c, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void isReaded(IClient c, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public IUser getUser(IClient c) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void filtrar(IClient c, List<IEmail> es)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public boolean contains(Client client, IEmail e, IFolder f)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

}
