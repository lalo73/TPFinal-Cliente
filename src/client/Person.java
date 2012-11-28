package client;

import interfaces.IPerson;

import java.util.ArrayList;
import java.util.List;

public class Person implements IPerson {

	private String name;
	private List<String> emails;
	
	public Person(String name, String email){
		this.setName(name);
		this.setEmail(email);
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
	public List<String> getEmails() {
		return emails;
	}
	
	@Override
	public String getEmail(){
		return this.getEmails().get(0);
	}

	@Override
	public void setEmail(String email) {
		emails = new ArrayList<String>();
		emails.add(email);
	}

}
