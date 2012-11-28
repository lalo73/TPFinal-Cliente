package test;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import interfaces.IClient;
import interfaces.IEmail;
import client.*;
import exceptions.NoLoggedUserException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ContainTest {
	Calendar d;
	IEmail email;
	Filter f1;
	IClient client;
	
	
	@Before
	public void setUp() throws NoLoggedUserException{
		
		d = Calendar.getInstance();
		d.set(Calendar.YEAR,2012);
		d.set(Calendar.MONTH, 12);
		d.set(Calendar.DAY_OF_MONTH,12);
		
		
		//Mock de Cliente
	    client=mock(Client.class);
		
		
		//Mocks de header 
		ClientEmailHead head =mock(ClientEmailHead.class);//Para email
		when(head.getSubject()).thenReturn("TrabajoPractico");
		when(head.getSender()).thenReturn("TPI");
		when(head.getDate()).thenReturn(d);
		
		//Mocks de Email
		email=mock(ClientEmail.class);//Email 1
		when(email.getHead()).thenReturn(head);
		when(email.isReaded()).thenReturn(false);
		
	
		
//Si el sender contiene TPI marcar como leido
		
	  	Sender s = new Sender();
	  	Countain cont=new Countain("T",s);
	  	MarkRead mark=new MarkRead(false);
		f1= new Filter(false,cont,mark);
		
		
	}

@Test
public void ContainMarkRead() throws NoLoggedUserException{
	f1.filter(email,client);
	assertTrue("el mail debe ser marcado como leido",email.isReaded());
	}

}