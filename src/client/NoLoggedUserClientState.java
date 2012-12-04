package client;

import interfaces.IAccesType;
import interfaces.IAttachment;
import interfaces.IClient;
import interfaces.IContact;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;
import interfaces.IList;
import interfaces.IPerson;
import interfaces.IUser;

import java.util.ArrayList;
import java.util.List;

import server.Server;
import exceptions.CannotFindEmailException;
import exceptions.NoFolderException;
import exceptions.NoLoggedUserException;
import filter.Action;
import filter.Filter;
import filter.Rule;

public class NoLoggedUserClientState extends ClientState {

	@Override
	public void askEmails(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public void createList(IClient cl, String listName)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public ArrayList<IFolder> getFolders(IClient cl) throws NoLoggedUserException {
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
			IAccesType at) {
		cl.setLoggedUser(new User(user, password, e, at));
		cl.setClientState(new LoggedUserClientState());
	}

	@Override
	public void logOut(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addContact(IClient cl, String name, String userEmail)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addList(IClient cl, String listName)
			throws NoLoggedUserException {
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
	public void addToFolder(IClient cl, IFolder f, IEmail e)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void removeFrom(IClient cl, IFolder f, IEmail e)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addFilter(IClient cl, Filter f) throws NoLoggedUserException {
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
	public boolean isExclusive(IClient cl, Filter f)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public Email makeEmail(IClient cl, IHeader h, IAttachment a)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public IEmail makeEmail(IClient cl, IHeader h) throws NoLoggedUserException {
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
	public boolean isReaded(IClient cl, IEmail e) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void filtrar(IClient cl, List<IEmail> es)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public boolean contains(IClient cl, IEmail e, IFolder f)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void addToList(IClient cl, IPerson c, IList list)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public boolean includesOnList(IClient cl, IContact c, IList list)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void filtrar(IClient cl, IEmail es) throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public IEmail find(Client client, IHeader header)
			throws CannotFindEmailException, NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public IEmail makeEmail(IClient cl, IHeader h, String b, IAttachment a)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public Email makeEmail(IClient cl, IHeader h, String b)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public IAccesType getAccesType(IClient cl) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public List<IEmail> getEmails(Client client) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void makeFilter(IClient cl, Action a, Rule r, boolean exclusive)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();

	}

	@Override
	public List<IList> getLists(Client client) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public boolean sendMessage(Client client, int number, String text) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void changeToHolidayState(Client client, int number) throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public void changeToHolidayState(Client client, String email) throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public void changeToOnlineState(Client client) throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public void remove(IClient cl, IPerson c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public void remove(IClient cl, IList c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public boolean includes(IClient cl, IPerson c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
	}

	@Override
	public void includes(IClient cl, IList c) throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public void removeFromList(IClient cl, IPerson c, IList list)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public void addToList(IClient cl, IPerson c, String listName)
			throws NoLoggedUserException {
		throw new NoLoggedUserException();
		
	}

	@Override
	public IList getDefaultList(IClient cl) throws NoFolderException, NoLoggedUserException {
		throw new NoLoggedUserException();
	}

}
