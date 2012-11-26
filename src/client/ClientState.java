package client;

import java.util.List;

import exceptions.AlreadyLoggedException;

import server.Server;

public abstract class ClientState {
	
	//client logging protocol
	public abstract void logIn(IClient client, String user, String password,
			Server e, IAccesType at) throws AlreadyLoggedException;

	public abstract void logOut(Client client);

	// Protocolo de manejo de personas o lista de personas
	public abstract void createList(IClient client, String listName);

	public abstract void addToList(IClient client, IContact c,
			List<IContact> contacts);

	public abstract void addList(IClient c, String listName);

	public abstract void addToList(IClient c, IContact cn, String listName);

	public abstract void addContact(IClient c, String name, String userEmail);

	public abstract void remove(IClient c, IContact cn);

	public abstract void includes(IClient c, IContact cn);

	// Protocolo de manejo de carpetas
	public abstract void addFolder(IClient c, String name);

	public abstract void remove(IClient c, IFolder f);

	public abstract void addToFolder(IClient c, IFolder f, IEmail e);

	public abstract void removeFrom(IClient c, IFolder f, IEmail e);

	public abstract List<IFolder> getFolders(IClient c);

	// Protocolo de manejo de filtros
	public abstract void addFilter(IClient c, Filter f);

	public abstract void addFilter(IClient c, Filter f, boolean exclusive);

	public abstract void remove(IClient c, Filter f);

	public abstract List<Filter> getFilters(IClient c);

	public abstract boolean isExclusive(IClient c, Filter f);

	// Protocolo de manejo de Emails

	public abstract void askEmails(IClient client);

	public abstract void makeEmail(IClient c, IHeader h, IBody b, IAttachment a);

	public abstract void makeEmail(IClient c, IHeader h, IBody b);

	public abstract void makeEmail(IClient c, IHeader h, IAttachment a);

	public abstract void makeEmail(IClient c, IHeader h);

	public abstract void sendEmail(IClient c, IEmail e);

	public abstract boolean includes(IClient c, IEmail e);

	public abstract void remove(IClient c, IEmail e);

	public abstract void isReaded(IClient c, IEmail e);

	// Protocolo de manejo del usuario
	public abstract IUser getUser(IClient c);

	// Protocolo interno de manejo de filtros
	public abstract void filtrar(IClient c, List<IEmail> es);

	public abstract boolean contains(Client client, IEmail e, IFolder f);

}
