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

import exception.CannotFindUserException;
import exceptions.AlreadyLoggedException;
import exceptions.NoLoggedUserException;

import server.Server;

public abstract class ClientState  {

	public abstract void askEmails(IClient cl) throws NoLoggedUserException, CannotFindUserException;

	public abstract void createList(IClient cl, String listName) throws NoLoggedUserException;

	public abstract void addToList(IClient cl, IContact c, IList contacts) throws NoLoggedUserException;

	public abstract List<IFolder> getFolders(IClient cl) throws NoLoggedUserException;

	public abstract void sendEmail(IClient cl, IEmail e) throws NoLoggedUserException;

	public abstract IUser getUser(IClient cl) throws NoLoggedUserException;

	public abstract void logIn(IClient cl, String user, String password, Server e,
			IAccesType at) throws AlreadyLoggedException;

	public abstract void logOut(IClient cl) throws NoLoggedUserException;

	public abstract void addContact(IClient cl, String name, String userEmail) throws NoLoggedUserException ;

	public abstract void addList(IClient cl, String listName) throws NoLoggedUserException;

	public abstract void addToList(IClient cl, IContact c, String listName) throws NoLoggedUserException;

	public abstract void remove(IClient cl, IContact c) throws NoLoggedUserException ;

	public abstract void includes(IClient cl, IContact c) throws NoLoggedUserException;

	public abstract void addFolder(IClient cl, String name) throws NoLoggedUserException;

	public abstract void remove(IClient cl, IFolder f) throws NoLoggedUserException ;

	public abstract void addToFolder(IClient cl, IFolder f, IEmail e) throws NoLoggedUserException ;

	public abstract void removeFrom(IClient cl, IFolder f, IEmail e) throws NoLoggedUserException;

	public abstract void addFilter(IClient cl, Filter f) throws NoLoggedUserException;

	public abstract void addFilter(IClient cl, Filter f, boolean exclusive)throws NoLoggedUserException;

	public abstract void remove(IClient cl, Filter f)throws NoLoggedUserException;

	public abstract List<Filter> getFilters(IClient cl)throws NoLoggedUserException;

	public abstract boolean isExclusive(IClient cl, Filter f) throws NoLoggedUserException;

	public abstract void makeEmail(IClient cl, IHeader h, IBody b, IAttachment a)throws NoLoggedUserException;

	public abstract void makeEmail(IClient cl, IHeader h, IBody b)throws NoLoggedUserException;

	public abstract void makeEmail(IClient cl, IHeader h, IAttachment a)throws NoLoggedUserException;

	public abstract void makeEmail(IClient cl, IHeader h)throws NoLoggedUserException;

	public abstract boolean includes(IClient cl, IEmail e)throws NoLoggedUserException;

	public abstract void remove(IClient cl, IEmail e)throws NoLoggedUserException;

	public abstract void isReaded(IClient cl, IEmail e)throws NoLoggedUserException;

	public abstract void filtrar(IClient cl, List<IEmail> es)throws NoLoggedUserException;

	public abstract boolean contains(IClient cl, IEmail e, IFolder f)throws NoLoggedUserException;

	public abstract void addToList(IClient cl, IPerson c, IList list)throws NoLoggedUserException;

	public abstract void removeFromList(IClient cl, IContact c, IList list)throws NoLoggedUserException;

	public abstract void includesOnList(IClient cl, IContact c, IList list)throws NoLoggedUserException;

	public abstract IAccesType getAccesType() throws NoLoggedUserException;

	public abstract void filtrar(IClient cl, IEmail es) throws NoLoggedUserException ;

}
