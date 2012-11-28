package test;


import org.junit.Before;


import org.junit.Test;


import interfaces.IEmail;

import client.Client;
import client.Different;

import client.Countain;
import client.Date;
import client.Email;
import client.Equal;
import client.Filter;
import client.Folder;
import client.Header;
import client.MoveToFolder;
import client.Sender;
import client.Subject;
import exceptions.NoLoggedUserException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class otroEqualTest {
	Equal eq;
	IEmail e;
    boolean res;
    Date date;

    
	
	@Before
	public void setUp() throws Exception {
		date=mock(Date.class);
		when(date.getField(e)).thenReturn("12/12/12");
		
		eq =new Equal("12/12/12",date);
		res=eq.satisfy(e);
	    }

	@Test
	public void equalTest(){
		assertTrue(res);
	}
	
	
	
}
