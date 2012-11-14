package client;

import java.util.List;

public interface IClient {
	public void logIn(String user, String password, IServer e, IAccesType at);
	public void askEmails();
	public void createList(String listName);
	public void addToList(IContact c, List<IContact> contacts);
	public List<IFolder> getFolders();
	public void sendEmail(IEmail e);
	public IUser getUser();
}
