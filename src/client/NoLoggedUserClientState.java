package client;

import interfaces.IAccesType;
import interfaces.IAttachment;
import interfaces.IBody;
import interfaces.IClient;
import interfaces.IContact;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;
import interfaces.IList;
import interfaces.IPerson;
import interfaces.IUser;

import java.util.List;

import server.Server;
import exceptions.NoLoggedUserException;

public class NoLoggedUserClientState extends ClientState {

	@Override
	public void askEmails(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void createList(IClient cl, String listName) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void addToList(IClient cl, IContact c, List<IContact> contacts) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public List<IFolder> getFolders(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void sendEmail(IClient cl, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public IUser getUser(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void logIn(IClient cl, String user, String password, Server e,
			IAccesType at){
		cl.setLoggedUser(new User(user, password, e, at));
		cl.setClientState(new LoggedUserClientState());
	}

	@Override
	public void logOut(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addContact(IClient cl, String name, String userEmail) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addList(IClient cl, String listName) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addToList(IClient cl, IContact c, String listName) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void remove(IClient cl, IContact c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void includes(IClient cl, IContact c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addFolder(IClient cl, String name) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void remove(IClient cl, IFolder f) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addToFolder(IClient cl, IFolder f, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void removeFrom(IClient cl, IFolder f, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addFilter(IClient cl, Filter f) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addFilter(IClient cl, Filter f, boolean exclusive) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void remove(IClient cl, Filter f) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public List<Filter> getFilters(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public boolean isExclusive(IClient cl, Filter f) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void makeEmail(IClient cl, IHeader h, IBody b, IAttachment a) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void makeEmail(IClient cl, IHeader h, IBody b) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void makeEmail(IClient cl, IHeader h, IAttachment a) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void makeEmail(IClient cl, IHeader h) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public boolean includes(IClient cl, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void remove(IClient cl, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void isReaded(IClient cl, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void filtrar(IClient cl, List<IEmail> es) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public boolean contains(IClient cl, IEmail e, IFolder f) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addToList(IClient cl, IPerson c, IList list) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void removeFromList(IClient cl, IContact c, IList list) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void includesOnList(IClient cl, IContact c, IList list) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public IAccesType getAccesType() throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

}
