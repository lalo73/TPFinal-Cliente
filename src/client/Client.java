package client;

import interfaces.IAccesType;
import interfaces.IAttachment;
import interfaces.IClient;
import interfaces.IContact;
import interfaces.IEmail;
import interfaces.IEvent;
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
import filter.Filter;

import server.Server;
import servers.SMS;
import servers.SMTP;

public class Client implements IClient {

	private ClientState clientState;
	private ArrayList<IFolder> folders;
	private List<IContact> contancts;
	private IUser loggedUser;
	private List<Filter> filters;
	private List<IEvent> events;
	private ArrayList<IEmail> emails;
	private SMS sms;
	private SMTP smtp;

	public Client() {
		this(new NoLoggedUserClientState());
	}

	public Client(ClientState state) {
		this.setClientState(state);
		this.setContancts(new ArrayList<IContact>());
		this.setEvents(new ArrayList<IEvent>());
		this.setFilters(new ArrayList<Filter>());
		this.setFolders(new ArrayList<IFolder>());
	}

	public void askEmails() throws Exception {
		this.getClientState().askEmails(this);

	}

	public void createList(String listName) throws NoLoggedUserException {
		this.getClientState().createList(this, listName);
	}

	public void addToList(IContact c, IList contacts)
			throws NoLoggedUserException {
		this.getClientState().addToList(this, c, contacts);
	}

	public ArrayList<IFolder> getFolders() throws NoLoggedUserException {
		return this.getClientState().getFolders(this);
	}

	public void sendEmail(IEmail e) throws NoLoggedUserException {
		this.getClientState().sendEmail(this, e);
	}

	public boolean sendMessage(int number, String text) throws NoLoggedUserException {
		return this.getClientState().sendMessage(this, number, text);
	}

	public IUser getUser() throws NoLoggedUserException {
		return this.getClientState().getUser(this);
	}

	public IAccesType getAccesType() throws NoLoggedUserException {
		return this.getClientState().getAccesType(this);
	}

	public ClientState getClientState() {
		return clientState;
	}

	public void setClientState(ClientState clientState) {
		this.clientState = clientState;
	}

	@Override
	public void logIn(String user, String password, Server e, IAccesType at)
			throws AlreadyLoggedException {
		this.getClientState().logIn(this, user, password, e, at);

	}

	@Override
	public void logOut() throws NoLoggedUserException {
		this.getClientState().logOut(this);

	}

	@Override
	public void addContact(String name, String userEmail)
			throws NoLoggedUserException {

		this.getClientState().addContact(this, name, userEmail);
	}

	@Override
	public void addList(String listName) throws NoLoggedUserException {
		this.getClientState().addList(this, listName);

	}

	@Override
	public void addToList(IContact c, String listName)
			throws NoLoggedUserException {
		this.getClientState().addToList(this, c, listName);
	}

	@Override
	public void remove(IContact c) throws NoLoggedUserException {
		this.getClientState().remove(this, c);
	}

	@Override
	public void includes(IContact c) throws NoLoggedUserException {
		this.getClientState().includes(this, c);

	}

	@Override
	public void addFolder(String name) throws NoLoggedUserException {
		this.getClientState().addFolder(this, name);
	}

	@Override
	public void remove(IFolder f) throws NoLoggedUserException {
		this.getClientState().remove(this, f);
	}

	@Override
	public void addToFolder(IFolder f, IEmail e) throws NoLoggedUserException {
		this.getClientState().addToFolder(this, f, e);
	}

	@Override
	public void removeFrom(IFolder f, IEmail e) throws NoLoggedUserException {
		this.getClientState().removeFrom(this, f, e);
	}

	@Override
	public void addFilter(Filter f) throws NoLoggedUserException {
		this.getClientState().addFilter(this, f);
	}

	@Override
	public void addFilter(Filter f, boolean exclusive)
			throws NoLoggedUserException {
		this.getClientState().addFilter(this, f);
	}

	@Override
	public void remove(Filter f) throws NoLoggedUserException {
		this.getClientState().remove(this, f);
	}

	@Override
	public List<Filter> getFilters() throws NoLoggedUserException {
		return this.getClientState().getFilters(this);
	}

	@Override
	public boolean isExclusive(Filter f) throws NoLoggedUserException {
		return this.getClientState().isExclusive(this, f);
	}

	@Override
	public void makeEmail(IHeader h, String b, IAttachment a)
			throws NoLoggedUserException {
		this.getClientState().makeEmail(this, h, b, a);
	}

	@Override
	public void makeEmail(IHeader h, String b) throws NoLoggedUserException {
		this.getClientState().makeEmail(this, h, b);
	}

	@Override
	public void makeEmail(IHeader h, IAttachment a)
			throws NoLoggedUserException {
		this.getClientState().makeEmail(this, h, a);
	}

	@Override
	public void makeEmail(IHeader h) throws NoLoggedUserException {
		this.getClientState().makeEmail(this, h);
	}

	@Override
	public void includes(IEmail e) throws NoLoggedUserException {
		this.getClientState().includes(this, e);
	}

	@Override
	public void remove(IEmail e) throws Exception {
		this.getClientState().remove(this, e);
	}

	@Override
	public void isReaded(IEmail e) throws NoLoggedUserException {
		this.getClientState().isReaded(this, e);
	}

	@Override
	public void filtrar(List<IEmail> es) throws Exception {
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

	public void setFolders(ArrayList<IFolder> folders) {
		this.folders = folders;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public boolean contains(IEmail e, IFolder f) throws NoLoggedUserException {

		return this.getClientState().contains(this, e, f);
	}

	public boolean includesEmail(IEmail e) throws NoLoggedUserException {

		return this.getClientState().includes(this, e);
	}

	@Override
	public void addToList(IPerson c, IList list) throws NoLoggedUserException {
		this.getClientState().addToList(this, c, list);
	}

	@Override
	public void removeFromList(IContact c, IList list)
			throws NoLoggedUserException {
		this.getClientState().removeFromList(this, c, list);

	}

	@Override
	public void includesOnList(IContact c, IList list)
			throws NoLoggedUserException {
		this.getClientState().includesOnList(this, c, list);

	}

	public List<IEmail> getEmails() throws NoLoggedUserException {

		return this.getClientState().getEmails(this);
	}

	public void setEmails(ArrayList<IEmail> emails) {
		this.emails = emails;
	}

	@Override
	public void filtrar(IEmail es) throws Exception {
		this.getClientState().filtrar(this, es);

	}

	public ArrayList<IFolder> getRealFolders() {
		return folders;
	}

	@Override
	public IEmail find(IHeader header) throws CannotFindEmailException,
			NoLoggedUserException {
		return this.getClientState().find(this, header);
	}

	@Override
	public List<Filter> getRealFiltesr() {
		return filters;
	}

	@Override
	public ArrayList<IEmail> getRealEmails() {
		return emails;
	}

	@Override
	public List<IList> getLists() throws NoLoggedUserException {
		return this.getClientState().getLists(this);
	}

	@Override
	public IUser getRealUser() {
		return loggedUser;
	}

	@Override
	public SMS getSms() {
		return sms;
	}

	@Override
	public void setSms(SMS sms) {
		this.sms = sms;
	}

	@Override
	public SMTP getSmtp() {
		return smtp;
	}

	@Override
	public void setSmtp(SMTP smtp) {
		this.smtp = smtp;
	}

	public void sendNotifySMS(int i, String string) {
		this.getSms().send(i, string);
	}

	@Override
	public void changeToHolidayState(int number) throws NoLoggedUserException {
		this.getClientState().changeToHolidayState(this,number);
		
	}
	@Override
	public void changeToHolidayState(String email) throws NoLoggedUserException {
		this.getClientState().changeToHolidayState(this,email);
		
	}

	@Override
	public void changeToOnlineState() throws NoLoggedUserException {
		this.getClientState().changeToOnlineState(this);
		
	}


	

}
