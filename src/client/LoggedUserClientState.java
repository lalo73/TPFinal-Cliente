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

import exceptions.AlreadyLoggedException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;
import filter.Action;
import filter.Filter;
import filter.Rule;

import server.Server;

public class LoggedUserClientState extends ClientState {

	@Override
	public void askEmails(IClient cl) throws Exception {
		List<IEmail> emails = this.getAccesType(cl).askEmails(cl, false);
		
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

		if (cl.getSmtp().logIn(cl.getLoggedUser().getName(),
				cl.getLoggedUser().getPassword(), "Multi-SMKTP Server")) {
			cl.getSmtp().send(e);

		}
		cl.getSmtp().logOut();

	}

	@Override
	public IUser getUser(IClient cl) {
		return cl.getRealUser();
	}

	@Override
	public void logIn(IClient cl, String user, String password, Server e,
			IAccesType at) throws AlreadyLoggedException {
		throw new AlreadyLoggedException();

	}

	@Override
	public void logOut(IClient cl) {
		cl.setClientState(new NoLoggedUserClientState());

	}

	@Override
	public void addContact(IClient cl, String name, String userEmail) {
		cl.getContancts().add(new Person(name, userEmail));
	}

	@Override
	public void addList(IClient cl, String listName) {
		cl.getContancts().add(new ContactList(listName));

	}

	@Override
	public void remove(IClient cl, IContact c) {
		cl.getContancts().remove(c);
	}

	@Override
	public void includes(IClient cl, IContact c) {
		cl.getContancts().contains(c);
	}

	@Override
	public void addFolder(IClient cl, String name) throws NoLoggedUserException {
		cl.getFolders().add(new Folder(name));
	}

	@Override
	public void remove(IClient cl, IFolder f) throws NoLoggedUserException {
		cl.getFolders().remove(f);
	}

	@Override
	public void addToFolder(IClient cl, IFolder f, IEmail e) {
		f.add(e);
	}

	@Override
	public void removeFrom(IClient cl, IFolder f, IEmail e) {
		f.removeEmail(e);
	}

	@Override
	public void addFilter(IClient cl, Filter f) throws NoLoggedUserException {
		cl.getFilters().add(f);

	}

	@Override
	public void makeFilter(IClient cl, Action a, Rule r, boolean exclusive)
			throws NoLoggedUserException {
		this.addFilter(cl, new Filter(r, a));

	}

	@Override
	public void remove(IClient cl, Filter f) throws NoLoggedUserException {
		cl.getFilters().remove(f);

	}

	@Override
	public List<Filter> getFilters(IClient cl) {
		return cl.getRealFiltesr();
	}

	@Override
	public boolean isExclusive(IClient cl, Filter f) {
		return f.getExclusive();
	}

	@Override
	public IEmail makeEmail(IClient cl, IHeader h, String b, IAttachment a) {
		IEmail email = this.makeEmail(cl, h, a);
		email.setBody(b);
		return email;

	}

	@Override
	public Email makeEmail(IClient cl, IHeader h, String b) {
		return new Email(h, b, false);

	}

	@Override
	public Email makeEmail(IClient cl, IHeader h, IAttachment a) {
		ArrayList<IAttachment> attachments = new ArrayList<IAttachment>();
		attachments.add(a);
		return new Email(h, attachments, false);

	}

	@Override
	public IEmail makeEmail(IClient cl, IHeader h) {
		return new Email(h, false);

	}

	@Override
	public boolean includes(IClient cl, IEmail e) throws NoLoggedUserException {
		for (IFolder folder : cl.getFolders()) {
			if (folder.includes(e)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void remove(IClient cl, IEmail e) throws NoLoggedUserException,
			CannotFindEmailException {
		for (IFolder folder : cl.getFolders()) {
			if (folder.includes(e)) {
				folder.removeEmail(e);
			}
		}
		throw new CannotFindEmailException();

	}

	@Override
	public boolean isReaded(IClient cl, IEmail e) {
		return e.isReaded();

	}

	@Override
	public void filtrar(IClient cl, List<IEmail> emails)
			throws NoLoggedUserException, CannotFindEmailException {
		for (IEmail email : emails) {
			this.filtrar(cl, email);
		}

	}

	@Override
	public boolean contains(IClient cl, IEmail e, IFolder f) {
		return f.includes(e);
	}

	@Override
	public void addToList(IClient cl, IPerson c, IList list) {
		list.add(c);

	}

	@Override
	public void removeFromList(IClient cl, IContact c, IList list) {
		list.remove(c);

	}

	@Override
	public boolean includesOnList(IClient cl, IContact c, IList list) {
		return list.includes(c);

	}

	@Override
	public IAccesType getAccesType(IClient cl) throws NoLoggedUserException {
		return cl.getUser().getAccesType();
	}

	@Override
	public void filtrar(IClient cl, IEmail es) throws NoLoggedUserException, CannotFindEmailException {
		boolean exclusive = false;
		for (Filter filter : cl.getFilters()) {

			exclusive = filter.filter(es, cl);
			if (exclusive) {
				break;
			}
		}

	}

	@Override
	public IEmail find(Client client, IHeader header)
			throws CannotFindEmailException, NoLoggedUserException {
		IEmail email = null;
		for (IFolder folder : client.getFolders()) {
			if (folder.includes(header)) {
				email = folder.find(header);
				break;
			}
		}
		if (email == null) {
			throw new CannotFindEmailException();
		}
		return email;
	}

	@Override
	public List<IEmail> getEmails(Client client) {
		return client.getRealEmails();
	}

	@Override
	public void addToList(Client cl, IContact c, String listName)
			throws NoLoggedUserException {
		for (IList list : cl.getLists()) {
			if (list.getName().equals(listName))
				;
			list.add(c);
			return;
		}

	}

	@Override
	public List<IList> getLists(Client client) {
		List<IList> lists = new ArrayList<IList>();
		for (IContact contact : client.getContancts()) {
			if (contact.getClass() == ContactList.class) {
				lists.add((ContactList) contact);
			}
		}
		return lists;
	}

	@Override
	public boolean sendMessage(Client client, int number, String text) {
		return client.getSms().send(number, text);
	}

}
