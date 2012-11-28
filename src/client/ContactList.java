package client;

import interfaces.IContact;
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
		this.setContacts(new ArrayList<IContact>());
	}
	
	public void setContacts(List<IContact> new_contacts){
		contacts = new_contacts; 
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
	public List<String> getEmails() {
		List<String> allEmails = new ArrayList<String>();
		for (IContact contact : this.getContacts()){
			allEmails.addAll(contact.getEmails());
		}
		Set<String> setEmail = new HashSet<String>(allEmails);
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
	
	@Override
	public boolean empty(){
		return this.getContacts().isEmpty();
	}
	
	@Override
	public int size(){
		return this.getContacts().size();
	}

}
