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

import java.util.List;

import exception.CannotFindUserException;
import exceptions.AlreadyLoggedException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;
import filter.Action;
import filter.Filter;
import filter.Rule;

import server.Server;

public abstract class ClientState  {

	public abstract void askEmails(IClient cl) throws NoLoggedUserException, CannotFindUserException, Exception;

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

	public abstract void remove(IClient cl, IContact c) throws NoLoggedUserException ;

	public abstract void includes(IClient cl, IContact c) throws NoLoggedUserException;

	public abstract void addFolder(IClient cl, String name) throws NoLoggedUserException;

	public abstract void remove(IClient cl, IFolder f) throws NoLoggedUserException ;

	public abstract void addToFolder(IClient cl, IFolder f, IEmail e) throws NoLoggedUserException ;

	public abstract void removeFrom(IClient cl, IFolder f, IEmail e) throws NoLoggedUserException;

	public abstract void addFilter(IClient cl, Filter f) throws NoLoggedUserException;

	public abstract void remove(IClient cl, Filter f)throws NoLoggedUserException;

	public abstract List<Filter> getFilters(IClient cl)throws NoLoggedUserException;

	public abstract boolean isExclusive(IClient cl, Filter f) throws NoLoggedUserException;

	public abstract IEmail makeEmail(IClient cl, IHeader h, String b, IAttachment a)throws NoLoggedUserException;

	public abstract Email makeEmail(IClient cl, IHeader h, String b)throws NoLoggedUserException;

	public abstract Email makeEmail(IClient cl, IHeader h, IAttachment a)throws NoLoggedUserException;

	public abstract IEmail makeEmail(IClient cl, IHeader h)throws NoLoggedUserException;

	public abstract boolean includes(IClient cl, IEmail e)throws NoLoggedUserException;

	public abstract void remove(IClient cl, IEmail e)throws NoLoggedUserException, CannotFindEmailException;

	public abstract boolean isReaded(IClient cl, IEmail e)throws NoLoggedUserException;

	public abstract void filtrar(IClient cl, List<IEmail> es)throws NoLoggedUserException, CannotFindEmailException;

	public abstract boolean contains(IClient cl, IEmail e, IFolder f)throws NoLoggedUserException;

	public abstract void addToList(IClient cl, IPerson c, IList list)throws NoLoggedUserException;

	public abstract void removeFromList(IClient cl, IContact c, IList list)throws NoLoggedUserException;

	public abstract boolean includesOnList(IClient cl, IContact c, IList list)throws NoLoggedUserException;

	public abstract void filtrar(IClient cl, IEmail es) throws NoLoggedUserException, CannotFindEmailException ;

	public abstract IEmail find(Client client, IHeader header) throws CannotFindEmailException, NoLoggedUserException;

	public abstract IAccesType getAccesType(IClient cl) throws NoLoggedUserException;

	public abstract List<IEmail> getEmails(Client client) throws NoLoggedUserException;

	public abstract void makeFilter(IClient cl, Action a, Rule r, boolean exclusive) throws NoLoggedUserException;

	public abstract void addToList(Client cl, IContact c, String listName) throws NoLoggedUserException ;

	public abstract List<IList> getLists(Client client) throws NoLoggedUserException;

	public abstract boolean sendMessage(Client client, int number, String text) throws NoLoggedUserException;
}
