package test;

import java.util.ArrayList;
import java.util.List;

import interfaces.IEmail;
import interfaces.IPerson;
import client.Person;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPerson {

	IEmail email;
	IPerson person;

	@Before
	public void SetUp() {
		person = new Person("name", "email");
	}

	@Test
	public void testWhenAPersonIsCreatedThenItHasAName() {
		assertEquals(person.getName(), "name");

	}

	@Test
	public void testWhenAPersonIsCreatedThenItHasAEmailListWithJustOneEmail() {
		List<String> emails_list = new ArrayList<String>();
		emails_list.add("email");
		assertEquals(person.getEmails(), emails_list);
	}

	@Test
	public void testWhenSetAEmailThenItSetsAEmailList() {
		List<String> emails_list = new ArrayList<String>();
		emails_list.add("email");
		
		assertEquals(person.getEmails(), emails_list);
		String second_email = "SecondEmail";
		person.setEmail(second_email);
		List<String> second_emails_list = new ArrayList<String>();
		second_emails_list.add(second_email);
		assertEquals(second_emails_list , person.getEmails());

	}

}
