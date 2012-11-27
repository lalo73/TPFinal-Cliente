package test;

import org.junit.Before;
import org.junit.Test;

import client.ContactList;
import client.IEmail;
import client.IList;
import client.IPerson;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListContacTest {
	
	IList contactList;
	
	@Before
	public void setUp(){
		contactList  = new ContactList("listName");
	}
	
	@Test
	public void testAnewListHasOnlyItsName(){
		
		assertEquals(contactList.getName(),"listName");
		assertEquals(contactList.getEmails().size(),0);
		
	}
	
	@Test
	public void testAddPersonContact(){
		
		IPerson mockPerson = mock(IPerson.class);
		contactList.add(mockPerson);
		contactList.includes(mockPerson);
		
	}
	
	

}
