package test;

import java.util.ArrayList;
import java.util.List;

import interfaces.IEmail;
import interfaces.IPerson;
import client.Person;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class TestPerson {

	IEmail email;
	IPerson person;

	@Before
	public void SetUp() {
		email = mock(IEmail.class);
		person = new Person("name", email);
	}

	@Test
	public void testWhenAPersonIsCreatedThenItHasAName() {
		assertEquals(person.getName(), "name");

	}

	@Test
	public void testWhenAPersonIsCreatedThenItHasAEmailListWithJustOneEmail() {
		List<IEmail> emails_list = new ArrayList<IEmail>();
		emails_list.add(email);
		assertEquals(person.getEmails(), emails_list);
	}

	@Test
	public void testWhenSetAEmailThenItSetsAEmailList() {
		List<IEmail> emails_list = new ArrayList<IEmail>();
		emails_list.add(email);
		
		assertEquals(person.getEmails(), emails_list);
		IEmail second_email = mock(IEmail.class);
		person.setEmail(second_email);
		List<IEmail> second_emails_list = new ArrayList<IEmail>();
		second_emails_list.add(second_email);
		assertEquals(second_emails_list , person.getEmails());

	}

}
