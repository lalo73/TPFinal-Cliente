package test;


import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Test;

import client.*;
import filter.Subject;


public class SubjectTest {

	Subject s;
	Header head;
	Email email;
	String res;
	
	
	@Before
	public void setUp() throws Exception {
		
		//Mocks de header 
	    head =mock(Header.class);
		when(head.getSubject()).thenReturn("Trabajo");
		
		email=mock(Email.class);//Mock de Email 
		when(email.getHead()).thenReturn(head);
		
		
		s=new Subject();
		res=s.getField(email);
	}
		
	@Test
	public void senderTest(){
		
		assertEquals("Trabajo",res);
	}	
	
}
