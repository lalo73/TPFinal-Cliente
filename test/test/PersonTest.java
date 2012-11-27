package test;

import interfaces.IEmail;
import interfaces.IPerson;

import org.junit.Before;
import org.junit.Test;

import client.Person;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class PersonTest {

	IPerson person;
	IEmail mockEmail;

	@Before
	public void setUp() {
		mockEmail = mock(IEmail.class);
		person = new Person("UserName", mockEmail);

	}

	@Test
	public void testWhenCreateAPersonContacThenItHasOnlyAEmail() {

		assertEquals(person.getEmails().size(), 1);

	}

	@Test
	public void testAPersonContactHasOnlyAEmail() {
		assertEquals(person.getEmail(), mockEmail);
		assertEquals(person.getEmails().get(0), mockEmail);

	}

}
