package client;

import java.util.List;

import exceptions.AlreadyLoggedException;

import server.Server;

public class Client implements IClient {

	private ClientState clientState;
	private List<IFolder> folders;
	private List<IContact> contancts;
	private IUser loggedUser;
	private List<Filter> filters;
	private List<IEvent> events;
	

	public Client(ClientState state) {
		this.setClientState(state);
	}

	public void askEmails() {
		this.getClientState().askEmails(this);

	}

	public void createList(String listName) {
		this.getClientState().createList(this, listName);
	}

	public void addToList(IContact c, List<IContact> contacts) {
		this.getClientState().addToList(this, c, contacts);
	}

	public List<IFolder> getFolders() {
		return this.getClientState().getFolders(this);
	}

	public void sendEmail(IEmail e) {
		this.getClientState().sendEmail(this, e);
	}

	public IUser getUser() {
		return this.getClientState().getUser(this);
	}

	public ClientState getClientState() {
		return clientState;
	}

	public void setClientState(ClientState clientState) {
		this.clientState = clientState;
	}

	@Override
	public void logIn(String user, String password, Server e, IAccesType at) throws AlreadyLoggedException {
		this.getClientState().logIn(this, user, password, e, at);
		
	}

	@Override
	public void logOut() {
		this.getClientState().logOut(this);
		
	}

	@Override
	public void addContact(String name, String userEmail) {
		
		this.getClientState().addContact(this, name, userEmail);
	}

	@Override
	public void addList(String listName) {
		this.getClientState().addList(this, listName);
		
	}

	@Override
	public void addToList(IContact c, String listName) {
		this.getClientState().addToList(this,c,listName);
	}

	@Override
	public void remove(IContact c) {
		this.getClientState().remove(this,c);
	}

	@Override
	public void includes(IContact c) {
		this.getClientState().includes(this,c);
		
	}

	@Override
	public void addFolder(String name) {
		this.getClientState().addFolder(this, name);
	}

	@Override
	public void remove(IFolder f) {
		this.getClientState().remove(this, f);
	}

	@Override
	public void addToFolder(IFolder f, IEmail e) {
		this.getClientState().addToFolder(this, f, e);
	}

	@Override
	public void removeFrom(IFolder f, IEmail e) {
		this.getClientState().removeFrom(this, f, e);
	}

	@Override
	public void addFilter(Filter f) {
		this.getClientState().addFilter(this, f);
	}

	@Override
	public void addFilter(Filter f, boolean exclusive) {
		this.getClientState().addFilter(this, f, exclusive);
	}

	@Override
	public void remove(Filter f) {
		this.getClientState().remove(this, f);
	}

	@Override
	public List<Filter> getFilters() {
		return this.getClientState().getFilters(this);
	}

	@Override
	public boolean isExclusive(Filter f) {
		return this.getClientState().isExclusive(this, f);
	}

	@Override
	public void makeEmail(IHeader h, IBody b, IAttachment a) {
		this.getClientState().makeEmail(this, h, b, a);
	}

	@Override
	public void makeEmail(IHeader h, IBody b) {
		this.getClientState().makeEmail(this, h, b);
	}

	@Override
	public void makeEmail(IHeader h, IAttachment a) {
		this.getClientState().makeEmail(this, h, a);	
		}

	@Override
	public void makeEmail(IHeader h) {
		this.getClientState().makeEmail(this, h);
	}

	@Override
	public void includes(IEmail e) {
		this.getClientState().includes(this, e);
	}

	@Override
	public void remove(IEmail e) {
		this.getClientState().remove(this, e);
	}

	@Override
	public void isReaded(IEmail e) {
		this.getClientState().isReaded(this, e);
	}

	@Override
	public void filtrar(List<IEmail> es) {
		this.getClientState().filtrar(this, es);
	}
	/**
	 * Getters and Setters
	 */

	public List<IContact> getContancts() {
		return contancts;
	}

	public void setContancts(List<IContact> contancts) {
		this.contancts = contancts;
	}

	public IUser getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(IUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public List<IEvent> getEvents() {
		return events;
	}

	public void setEvents(List<IEvent> events) {
		this.events = events;
	}

	public void setFolders(List<IFolder> folders) {
		this.folders = folders;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}
	
	
	
	

}
