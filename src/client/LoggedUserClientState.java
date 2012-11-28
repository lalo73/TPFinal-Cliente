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

public class LoggedUserClientState extends ClientState {

	@Override
	public void askEmails(IClient cl) throws NoLoggedUserException, CannotFindUserException {
		List<IEmail> emails = this.getAccesType().askEmails(cl, false);
		this.filtrar(cl, emails);
		
	}

	@Override
	public void createList(IClient cl, String listName) {
		cl.getContancts().add(new ContactList(listName));
		
	}

	@Override
	public void addToList(IClient cl, IContact c, IList contacts) {
		contacts.add(c);
	}

	@Override
	public List<IFolder> getFolders(IClient cl) {
		return cl.getRealFolders();
	}

	@Override
	public void sendEmail(IClient cl, IEmail e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IUser getUser(IClient cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logIn(IClient cl, String user, String password, Server e,
			IAccesType at) throws AlreadyLoggedException {
		throw new AlreadyLoggedException();
		
	}

	@Override
	public void logOut(IClient cl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addContact(IClient cl, String name, String userEmail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addList(IClient cl, String listName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToList(IClient cl, IContact c, String listName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(IClient cl, IContact c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void includes(IClient cl, IContact c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFolder(IClient cl, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(IClient cl, IFolder f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToFolder(IClient cl, IFolder f, IEmail e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFrom(IClient cl, IFolder f, IEmail e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFilter(IClient cl, Filter f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addFilter(IClient cl, Filter f, boolean exclusive) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(IClient cl, Filter f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Filter> getFilters(IClient cl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExclusive(IClient cl, Filter f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeEmail(IClient cl, IHeader h, IBody b, IAttachment a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeEmail(IClient cl, IHeader h, IBody b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeEmail(IClient cl, IHeader h, IAttachment a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeEmail(IClient cl, IHeader h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean includes(IClient cl, IEmail e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(IClient cl, IEmail e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void isReaded(IClient cl, IEmail e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void filtrar(IClient cl, List<IEmail> emails) throws NoLoggedUserException {
		for(IEmail email : emails){
			this.filtrar(cl, email);
		}
		
	}

	@Override
	public boolean contains(IClient cl, IEmail e, IFolder f) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addToList(IClient cl, IPerson c, IList list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromList(IClient cl, IContact c, IList list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void includesOnList(IClient cl, IContact c, IList list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IAccesType getAccesType() throws NoLoggedUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void filtrar(IClient cl, IEmail es) throws NoLoggedUserException {
		boolean exclusive = false;
		for(Filter filter : cl.getFilters()){
			
			exclusive = filter.filter(es, cl);
			if(exclusive){
				break;
			}
		}
		
	}

	

}
