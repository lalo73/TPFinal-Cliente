package test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import client.*;

public class MarkReadTest {

    Email email;
	MarkRead mr;
	Client cl;
	
	
	@Before
	public void setUp() throws Exception {
		
		cl=mock(Client.class);
		email=mock(Email.class);//Email 1
		when(email.isReaded()).thenReturn(false);
		mr=new MarkRead(false);
		mr.act(email,cl);
		
		
		
	}

	@Test
	public void testMarkRead(){
		assertTrue(email.isReaded());
		
	}
	
	
}
