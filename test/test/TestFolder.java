package test;



import static org.junit.Assert.*;
import interfaces.IAttachment;
import interfaces.IEmail;
import interfaces.IHeader;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import client.*;
import exceptions.CannotFindEmailException;
import static org.mockito.Mockito.*;

public class TestFolder {
	  IEmail e2;
      IEmail e;
      IHeader eh;
      IAttachment at;
      Folder f;
  	
	@Before
	public void setUp() throws Exception {
		ArrayList<IAttachment> atts = new ArrayList<IAttachment>();
		at = mock(IAttachment.class);
		atts.add((IAttachment) at);
		eh = mock(IHeader.class);
		e = mock(Email.class);
		e2 = mock (Email.class);
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
