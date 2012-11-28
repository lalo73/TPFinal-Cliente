package test;


import static org.junit.Assert.*;
import interfaces.IAttachment;
import interfaces.IEmail;
import interfaces.IHeader;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

import client.Email;
import static org.mockito.Mockito.*;

public class TestClientEmail {
	IAttachment a;
	IHeader eh;
	IEmail e;
	
	@Before 
	public void setUp(){
		a = mock(IAttachment.class);
		when(a.getFile()).thenReturn("aFile");
		when(a.getFileName()).thenReturn("aFileName");
		eh = mock(IHeader.class);
		when(eh.getDate()).thenReturn(Calendar.getInstance());
		when(eh.getReciver()).thenReturn("Jfflores90@gmail.com");
		when(eh.getSender()).thenReturn("lalo73@gmail.com");
		when(eh.getSubject()).thenReturn("aSubject");
		ArrayList<IAttachment>at = new ArrayList<IAttachment>();
		at.add(a);
		e = new Email(eh,"aBody",at,false);
		
	}

	@Test
	public void testisReaded() {
		assertTrue(e.isReaded() == false);
	}

	@Test
	public void testgetBody(){
		assertEquals(e.getBody(),"aBody");
	}
	@Test
	public void testgetHead(){
		assertEquals(e.getHead().getReciver(),"Jfflores90@gmail.com");
		assertEquals(e.getHead().getSender(),"lalo73@gmail.com");
		assertEquals(e.getAttachment().get(0),a);
		assertEquals(e.getHead().getDate(),eh.getDate());
	}
}