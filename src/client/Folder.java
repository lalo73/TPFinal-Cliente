package client;

import java.util.*;

import exceptions.CannotFindEmailException;

public class Folder implements IFolder {
      String folderName;
      ArrayList<IEmail> email = new ArrayList<IEmail>();
      
      

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public ArrayList<IEmail> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<IEmail> email) {
		this.email = email;
	}

	
	
	public Folder(String folderName) {
		super();
		this.folderName = folderName;
	}

	@Override
	public void add(IEmail e) {
		this.getEmail().add(e);
		
	}

	@Override
	public void remove(IEmail e) {
	   this.getEmail().remove(e);
	}
	@Override
	public boolean includes(IEmail e) {
		return this.getEmail().contains(e);
		
	}

	public IEmail getEmail(IEmail e) throws Exception{
		for (IEmail ie : this.getEmail()){
			if (e == ie) {
				return ie;
			}
		}
		throw  new CannotFindEmailException ("Email doesn't exist");
	}
	
	public void clearList(){
		this.getEmail().removeAll(this.getEmail());
	}
}

	
