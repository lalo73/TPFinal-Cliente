package test;


import org.junit.Before;

import org.junit.Test;


import interfaces.IEmail;

import client.Client;
import client.Different;

import client.Countain;
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

public class OtroCountainTest {
	Countain con;
	IEmail e;
    boolean res;

	@Before
	public void setUp() throws Exception {
		Subject sub=mock(Subject.class);
		when(sub.getField(e)).thenReturn("TrabajoPractico");
		
		Countain con =new Countain("Trabajo",sub);
		res=con.satisfy(e);
		
		
	}

	@Test
	public void equalTest(){
		assertTrue(res);
	}
	
	
	
}
