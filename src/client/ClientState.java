package client;

import java.util.List;

import exceptions.AlreadyLoggedException;
import exceptions.NoLoggedUserException;

import server.Server;

public abstract class ClientState {
	
	//client logging protocol
	public abstract void logIn(IClient client, String user, String password,
			Server e, IAccesType at) throws AlreadyLoggedException;

	public abstract void logOut(Client client) throws NoLoggedUserException;

	// person or person list protocol
	public abstract void createList(IClient client, String listName) throws NoLoggedUserException;

	public abstract void addToList(IClient client, IContact c,
			List<IContact> contacts) throws NoLoggedUserException;

	public abstract void addList(IClient c, String listName) throws NoLoggedUserException;

	public abstract void addToList(IClient c, IContact cn, String listName) throws NoLoggedUserException;

	public abstract void addContact(IClient c, String name, String userEmail) throws NoLoggedUserException;

	public abstract void remove(IClient c, IContact cn) throws NoLoggedUserException;

	public abstract void includes(IClient c, IContact cn) throws NoLoggedUserException;

	// folder protocol
	public abstract void addFolder(IClient c, String name) throws NoLoggedUserException;

	public abstract void remove(IClient c, IFolder f) throws NoLoggedUserException;

	public abstract void addToFolder(IClient c, IFolder f, IEmail e) throws NoLoggedUserException;

	public abstract void removeFrom(IClient c, IFolder f, IEmail e) throws NoLoggedUserException;

	public abstract List<IFolder> getFolders(IClient c) throws NoLoggedUserException;

	// filters protocol
	public abstract void addFilter(IClient c, Filter f) throws NoLoggedUserException;

	public abstract void addFilter(IClient c, Filter f, boolean exclusive) throws NoLoggedUserException;

	public abstract void remove(IClient c, Filter f) throws NoLoggedUserException;

	public abstract List<Filter> getFilters(IClient c) throws NoLoggedUserException;

	public abstract boolean isExclusive(IClient c, Filter f) throws NoLoggedUserException;

	// email protocol

	public abstract void askEmails(IClient client) throws NoLoggedUserException;

	public abstract void makeEmail(IClient c, IHeader h, IBody b, IAttachment a) throws NoLoggedUserException;

	public abstract void makeEmail(IClient c, IHeader h, IBody b) throws NoLoggedUserException;

	public abstract void makeEmail(IClient c, IHeader h, IAttachment a) throws NoLoggedUserException;

	public abstract void makeEmail(IClient c, IHeader h) throws NoLoggedUserException;

	public abstract void sendEmail(IClient c, IEmail e) throws NoLoggedUserException;

	public abstract boolean includes(IClient c, IEmail e) throws NoLoggedUserException;

	public abstract void remove(IClient c, IEmail e) throws NoLoggedUserException;

	public abstract void isReaded(IClient c, IEmail e) throws NoLoggedUserException;

	// Protocolo de manejo del usuario
	public abstract IUser getUser(IClient c) throws NoLoggedUserException;

	// Protocolo interno de manejo de filtros
	public abstract void filtrar(IClient c, List<IEmail> es) throws NoLoggedUserException;

	public abstract boolean contains(Client client, IEmail e, IFolder f) throws NoLoggedUserException;

}
