package interfaces;

import java.util.ArrayList;

import exceptions.CannotFindEmailException;
import interfaces.IEmail;

public interface IFolder {

	public void add(IEmail e);

	public void removeEmail(IEmail e);

	public boolean includes(IEmail e);

	public void clearList();

	public IEmail getEmail(IEmail e) throws Exception;
	
	public IEmail getEmail(IHeader head) throws Exception;

	public void setFolderName(String folderName);

	public boolean includes(IHeader header);

	public IEmail find(IHeader header) throws CannotFindEmailException;

	public String getName();

	public void setName(String name);

	public void removeEmailByHeader(IHeader header) throws CannotFindEmailException, Exception;

	void setEmails(ArrayList<IEmail> email);

	ArrayList<IEmail> getEmails();

	String getFolderName();

}
