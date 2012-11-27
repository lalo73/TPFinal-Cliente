package test;

import client.*;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Before;
import org.junit.Test;

import exceptions.CannotFindEmailException;
import static org.mockito.Mockito.*;

public class TestFolder {
	  ClientEmail e2;
      ClientEmail e;
      ClientEmailHead eh;
      ClientEmailAttachment at;
      Folder f;
  	
	@Before
	public void setUp() throws Exception {
		ArrayList<ClientEmailAttachment> atts = new ArrayList<ClientEmailAttachment>();
		at = mock(ClientEmailAttachment.class);
		atts.add(at);
		eh = mock(ClientEmailHead.class);
		e = mock(ClientEmail.class);
		e2 = mock (ClientEmail.class);
		when(e.getBody()).thenReturn("aBody");
		when(e.getAttachment()).thenReturn(atts);
		when(e.getHead()).thenReturn(eh);	
		f = new Folder("FolderName");
		f.getEmails().add(e);
	}
	@Test
	public void testAdd() {
		assertEquals(f.getEmails().get(0),e);
		assertEquals(f.getEmails().size(), 1);
		
	}
	@Test
	public void removeEmail(){
		f.removeEmail(e);
		assertEquals(f.getEmails().size(),0);
	}
	@Test
	public void testIncludes(){
		assertTrue(f.includes(e));
	}
	
	@Test
	public void testClearList(){
		assertEquals(f.getEmails().size(),1);
		f.clearList();
		assertEquals(f.getEmails().size(),0);
	}
	
	@Test
	public void testGetEmail() throws Exception{
		assertEquals(f.getEmail(e),e);
		try{
			f.getEmail(e2);
		}catch (CannotFindEmailException e){
			
		}
	}

}
