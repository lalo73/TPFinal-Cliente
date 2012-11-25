package client;

import java.util.ArrayList;

public interface IFolder {
	
	public void add(IEmail e);
	public void remove(IEmail e);

	public boolean includes(IEmail e);
	public void clearList();
	public IEmail getEmail(IEmail e) throws Exception;
	public void setFolderName(String folderName);
	public void setEmail(ArrayList<IEmail> email);

}
