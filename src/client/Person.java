package client;

import interfaces.IEmail;
import interfaces.IPerson;

import java.util.ArrayList;
import java.util.List;

public class Person implements IPerson {

	private String name;
	private List<IEmail> emails;
	
	public Person(String name, IEmail email){
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
	public List<IEmail> getEmails() {
		return emails;
	}
	
	@Override
	public IEmail getEmail(){
		return this.getEmails().get(0);
	}

	@Override
	public void setEmail(IEmail email) {
		emails = new ArrayList<IEmail>();
		emails.add(email);
	}

}
