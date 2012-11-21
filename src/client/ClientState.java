package client;

import java.util.List;

import server.Server;

public abstract class ClientState{
	
	public abstract void logIn(IClient client, String user, String password, Server e, AccesType at);

	public abstract void askEmails(IClient client);

	public abstract void createList(IClient client, String listName);

	public abstract void addToList(IClient client, IContact c, List<IContact> contacts);

	public abstract List<IFolder> getFolders(IClient client);

	public abstract void sendEmail(IClient client, IEmail e);
	
	public abstract IUser getUser(IClient client);
	
	public static void main(String[] args) {
		System.out.println("Hello");
	}

}
