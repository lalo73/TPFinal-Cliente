package client;

import interfaces.IEmail;
import interfaces.IFolder;

import java.util.*;

import exceptions.CannotFindEmailException;

public class Folder implements IFolder {
      String folderName;
      ArrayList<IEmail> emails = new ArrayList<IEmail>();
      
      

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public ArrayList<IEmail> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<IEmail> email) {
		this.emails = email;
	}

	
	
	public Folder(String folderName) {
		super();
		this.folderName = folderName;
	}

	@Override
	public void add(IEmail e) {
		this.getEmails().add(e);
		
	}

	@Override
	public void removeEmail(IEmail e) {
	   this.getEmails().remove(e);
	}
	@Override
	public boolean includes(IEmail e) {
		return this.getEmails().contains(e);
		
	}

	public IEmail getEmail(IEmail e) throws Exception{
		for (IEmail ie : this.getEmails()){
			if (e == ie) {
				return ie;
			}
		}
		throw  new CannotFindEmailException ("Email doesn't exist");
	}
	
	public void clearList(){
		this.getEmails().removeAll(this.getEmails());
	}
}

	
