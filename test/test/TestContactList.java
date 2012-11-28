package test;

import interfaces.IList;
import interfaces.IPerson;

import org.junit.Before;
import org.junit.Test;

import client.ContactList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TestContactList {
	
	IList contact_list;
	
	@Before
	public void SetUp(){
		
		contact_list = new ContactList("list_name");
	}
	
	@Test
	public void testWhenAContactListIsCreatedItIsEmpty(){
		
		assertTrue(contact_list.empty());
		
	}
	
	@Test
	public void testWhenAddAContactToAContacListItHasJustOneElement(){
		
		IPerson person = mock(IPerson.class);
		contact_list.add(person);
		assertTrue(contact_list.includes(person));
		assertTrue(contact_list.size() == 1);
		
	}
	
	@Test
	public void testRemoveContact(){
		
		IPerson person = mock(IPerson.class);
		contact_list.add(person);
		assertTrue(contact_list.includes(person));
		contact_list.remove(person);
		assertFalse(contact_list.includes(person));
		assertTrue(contact_list.size() == 0);
	}
	
	@Test
	public void testAddSomeContacts(){
		
		for (int i = 0; i < 3; i++) {
			contact_list.add(mock(IPerson.class));
		}
		
		assertTrue(contact_list.size() == 3);
		
	}

}
