package test;

import org.junit.Before;
import org.junit.Test;

import interfaces.IList;
import interfaces.IPerson;
import client.ContactList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ContactListTest {

	IList contactList;

	@Before
	public void setUp() {
		contactList = new ContactList("listName");
	}

	@Test
	public void testAddContanct() {
		IPerson person = mock(IPerson.class);
		contactList.add(person);
		assertTrue(contactList.includes(person));
	}

	@Test
	public void testRemoveContact() {
		IPerson person = mock(IPerson.class);
		contactList.add(person);
		assertTrue(contactList.includes(person));
		contactList.remove(person);
		assertFalse(contactList.includes(person));
	}

	@Test
	public void testRemoveOnlyAContact() {
		IPerson person = mock(IPerson.class);
		contactList.add(person);
		for (int i = 0; i < 3; i++) {
			contactList.add(mock(IPerson.class));
		}
		assertEquals(4, contactList.size());
		assertTrue(contactList.includes(person));
		contactList.remove(person);
		assertFalse(contactList.includes(person));
	}

	@Test
	public void testAContactListHasAName() {
		assertEquals("listName", contactList.getName());
	}

	@Test
	public void testSetTheNameOfAList() {
		contactList.setName("newListName");
		assertEquals("newListName", contactList.getName());
	}

	@Test
	public void testAQListwithoutElementIsEmpty() {
		assertTrue(contactList.empty());
	}

	@Test
	public void testAListWithAElementIsNotEmpty() {
		IPerson person = mock(IPerson.class);
		contactList.add(person);
		assertFalse(contactList.empty());
	}

	@Test
	public void testwhenAListhasNotAnyElementThenItsSizeIsZero() {
		assertEquals(0, contactList.size());
	}

	@Test
	public void testWhenAListHasAElementThenIstSizeItsOne() {
		IPerson person = mock(IPerson.class);
		contactList.add(person);
		assertEquals(1, contactList.size());
	}

	@Test
	public void testWhenAListHasThreeElementThenIstSizeItsThree() {
		for (int i = 0; i < 3; i++) {
			contactList.add(mock(IPerson.class));
		}
		assertEquals(3, contactList.size());
	}
}
