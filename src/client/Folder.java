package client;

import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;

import java.util.*;

import exceptions.CannotFindEmailException;

public class Folder implements IFolder {
	String folderName;
	ArrayList<IEmail> emails = new ArrayList<IEmail>();

	public void setName(String name) {
		this.setFolderName(name);
	}

	public String getName() {
		return this.getFolderName();
	}

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

	public IEmail getEmail(IEmail e) throws Exception {
		for (IEmail ie : this.getEmails()) {
			if (e == ie) {
				return ie;
			}
		}
		throw new CannotFindEmailException("Email doesn't exist");
	}

	public void clearList() {
		this.getEmails().removeAll(this.getEmails());
	}

	@Override
	public boolean includes(IHeader header) {
		for (IEmail email : this.getEmails()) {
			if (email.getHead().equals(header)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public IEmail find(IHeader header) throws CannotFindEmailException {
		for (IEmail email : this.getEmails()) {
			if (email.getHead().equals(header)) {
				return email;
			}
		}

		throw new CannotFindEmailException();
	}

	@Override
	public void removeEmailByHeader(IHeader header) throws CannotFindEmailException, Exception {
		this.getEmail(this.find(header));

	}

}
