package client;

import interfaces.IContact;
import interfaces.IEmail;
import interfaces.IList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactList implements IList {
	
	String name;
	List<IContact> contacts;

	public ContactList(String listName) {
		this.setName(listName);
	}

	@Override
	public boolean includes(IContact c){
		return contacts.contains(c);
	}
	
	public boolean contains(IContact c){
		return contacts.contains(c);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String newName) {
		name = newName;
		
	}

	@Override
	public List<IContact> getContacts(){
		return contacts;
	}
	
	@Override
	public List<IEmail> getEmails() {
		ArrayList<IEmail> allEmails = new ArrayList<IEmail>();
		for (IContact contact : this.getContacts()){
			allEmails.addAll(contact.getEmails());
		}
		Set<IEmail> setEmail = new HashSet<IEmail>(allEmails);
		allEmails.clear();
		allEmails.addAll(setEmail);
		return allEmails;
	}

	@Override
	public void add(IContact c) {
		this.getContacts().add(c);
		
	}

	@Override
	public void remove(IContact c) {
		this.getContacts().remove(c);
	}

}
