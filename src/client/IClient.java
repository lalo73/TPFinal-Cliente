package client;

import java.util.List;

import exceptions.AlreadyLoggedException;

import server.Server;

public interface IClient {
	// Log in and Log out client protocol
	public void logIn(String user, String password, Server e, IAccesType at)
			throws AlreadyLoggedException;

	public void logOut();

	// give emails protocol
	public void askEmails();

	// people and people list protocol
	public void addContact(String name, String userEmail);

	public void addList(String listName);

	public void addToList(IContact c, String listName);

	public void remove(IContact c);

	public void includes(IContact c);

	// folders protocol
	public void addFolder(String name);

	public void remove(IFolder f);

	public void addToFolder(IFolder f, IEmail e);

	public void removeFrom(IFolder f, IEmail e);

	public List<IFolder> getFolders();

	// Filters protocol
	public void addFilter(Filter f);

	public void addFilter(Filter f, boolean exclusive);

	public void remove(Filter f);

	public List<Filter> getFilters();

	public boolean isExclusive(Filter f);

	// Emails protocol
	public void makeEmail(IHeader h, IBody b, IAttachment a);

	public void makeEmail(IHeader h, IBody b);

	public void makeEmail(IHeader h, IAttachment a);

	public void makeEmail(IHeader h);

	public void sendEmail(IEmail e);

	public void includes(IEmail e);

	public void remove(IEmail e);

	public void isReaded(IEmail e);

	// User protocol
	public IUser getUser();

	// internal filter protocol
	public void filtrar(List<IEmail> es);

	// Getters and setters

	public List<IContact> getContancts();

	public void setContancts(List<IContact> contancts);

	public IUser getLoggedUser();

	public void setLoggedUser(IUser loggedUser);

	public List<IEvent> getEvents();

	public void setEvents(List<IEvent> events);

	public void setFolders(List<IFolder> folders);

	public void setFilters(List<Filter> filters);
	
	public ClientState getClientState();

	public void setClientState(ClientState clientState);

}
