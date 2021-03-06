package interfaces;

import java.util.ArrayList;
import java.util.List;

import client.ClientState;

import exception.CannotFindUserException;
import exceptions.AlreadyLoggedException;
import exceptions.CannotFindEmailException;
import exceptions.NoFolderException;
import exceptions.NoLoggedUserException;
import filter.Filter;

import server.Server;
import servers.SMS;
import servers.SMTP;

public interface IClient {

	public void changeToHolidayState(int number) throws NoLoggedUserException;

	public void changeToHolidayState(String email) throws NoLoggedUserException;

	public void changeToOnlineState() throws NoLoggedUserException;
	
	public void changeTo() throws NoLoggedUserException;

	// Log in and Log out client protocol
	public void logIn(String user, String password, Server e, IAccesType at)
			throws AlreadyLoggedException;

	public void logOut() throws NoLoggedUserException;

	// give emails protocol
	public void askEmails() throws NoLoggedUserException,
			CannotFindUserException, Exception;

	// people and people list protocol
	public void addContact(String name, String userEmail)
			throws NoLoggedUserException, NoFolderException;

	public void addList(String listName) throws NoLoggedUserException;

	public void addToList(IPerson c, IList list) throws NoLoggedUserException;

	public void remove(IList c) throws NoLoggedUserException;
	
	public void includesOnList(IContact c, IList list)
			throws NoLoggedUserException;

	// folders protocol
	public void addFolder(String name) throws NoLoggedUserException;

	public void remove(IFolder f) throws NoLoggedUserException;

	public void addToFolder(IFolder f, IEmail e) throws NoLoggedUserException;

	public void removeFrom(IFolder f, IEmail e) throws NoLoggedUserException;

	public ArrayList<IFolder> getFolders() throws NoLoggedUserException;

	public boolean contains(IEmail e, IFolder f) throws NoLoggedUserException;

	public boolean includesEmail(IEmail e) throws NoLoggedUserException;

	// Filters protocol
	public void addFilter(Filter f) throws NoLoggedUserException;

	public void addFilter(Filter f, boolean exclusive)
			throws NoLoggedUserException;

	public void remove(Filter f) throws NoLoggedUserException;

	public List<Filter> getFilters() throws NoLoggedUserException;

	public boolean isExclusive(Filter f) throws NoLoggedUserException;

	// Emails protocol
	public void makeEmail(IHeader h, String b, IAttachment a)
			throws NoLoggedUserException;

	public void makeEmail(IHeader h, String b) throws NoLoggedUserException;

	public void makeEmail(IHeader h, IAttachment a)
			throws NoLoggedUserException;

	public void makeEmail(IHeader h) throws NoLoggedUserException;

	public void sendEmail(IEmail e) throws NoLoggedUserException;

	public boolean sendMessage(int number, String text)
			throws NoLoggedUserException;

	public void includes(IEmail e) throws NoLoggedUserException;

	public void remove(IEmail e) throws NoLoggedUserException,
			CannotFindEmailException, Exception;

	public void isReaded(IEmail e) throws NoLoggedUserException;

	// User protocol
	public IUser getUser() throws NoLoggedUserException;

	// internal filter protocol
	public void filtrar(List<IEmail> es) throws NoLoggedUserException,
			CannotFindEmailException, Exception;

	public void filtrar(IEmail es) throws NoLoggedUserException,
			CannotFindEmailException, Exception;

	// Getters and setters

	public List<IList> getContancts();

	public List<IList> getLists() throws NoLoggedUserException;

	public void setContancts(List<IList> contancts);

	public IUser getLoggedUser();

	public void setLoggedUser(IUser loggedUser);

	public List<IEvent> getEvents();

	public void setEvents(List<IEvent> events);

	public void setFolders(ArrayList<IFolder> folders);

	public void setFilters(List<Filter> filters);

	public ClientState getClientState();

	public void setClientState(ClientState clientState);

	public ArrayList<IFolder> getRealFolders();

	public IEmail find(IHeader header) throws CannotFindEmailException,
			NoLoggedUserException;

	public List<Filter> getRealFiltesr();

	public ArrayList<IEmail> getRealEmails();

	public IUser getRealUser();

	public SMS getSms();

	public void setSms(SMS sms);

	public SMTP getSmtp();

	public void setSmtp(SMTP smtp);

	void addToList(IPerson c, String listName) throws NoLoggedUserException;

	void remove(IPerson person) throws NoLoggedUserException;

	void includes(IPerson person) throws NoLoggedUserException;

	void includes(IList list) throws NoLoggedUserException;

	void removeFromList(IPerson person, IList list)
			throws NoLoggedUserException;

	public IList getDefaultList() throws NoFolderException, NoLoggedUserException;

}
