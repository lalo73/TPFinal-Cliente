package filtersTest;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import client.*;
import filter.Sender;

public class SenderTest {
	
	Sender s;
	Header head;
	Email email;
	String res;
	
	@Before
	public void setUp() throws Exception {
		
		//Mocks de header 
	    head =mock(Header.class);//Para email
		when(head.getSender()).thenReturn("TPI");
		
		email=mock(Email.class);//Email 1
		when(email.getHead()).thenReturn(head);
		
		
		s=new Sender();
		res=s.getField(email);
	}

	
	@Test
	public void senderTest(){
		
		assertEquals("Tpi",res);
	}
	
}
