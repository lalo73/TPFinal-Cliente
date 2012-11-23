package client;

import java.util.List;

import server.Server;

public interface IClient {
	//Protocolo de logueo y deslogueo
	public void logIn(String user, String password, Server e, IAccesType at);
	public void logOut();
	//Protocolo de pedido de Emails
	public void askEmails();
	//Protocolo de manejo de personas o lista de personas
	public void addContact(String name, String userEmail);
	public void addList(String listName);
	public void addToList(IContact c, String listName);
	public void remove(IContact c);
	public void includes(IContact c);
	//Protocolo de manejo de carpetas
	public void addFolder(String name);
	public void remove(IFolder f);
	public void addToFolder(IFolder f, IEmail e);
	public void removeFrom(IFolder f, IEmail e);
	public List<IFolder> getFolders();
	//Protocolo de manejo de filtros
	public void addFilter(Filter f);
	public void addFilter(Filter f,boolean exclusive);
	public void remove(Filter f);
	public List<Filter> getFilters();
	public boolean isExclusive(Filter f);
	//Protocolo de manejo de Emails
	public void makeEmail(IHeader h, IBody b, IAttachment a);
	public void makeEmail(IHeader h,IBody b);
	public void makeEmail(IHeader h,IAttachment a);
	public void makeEmail(IHeader h);
	public void sendEmail(IEmail e);
	public void includes(IEmail e);
	public void remove(IEmail e);
	public void isReaded(IEmail e);
	// Protocolo de manejo del usuario
	public IUser getUser();
	//Protocolo interno de manejo de filtros
	public void filtrar(List<IEmail> es);
	
	
	
	
	
}
