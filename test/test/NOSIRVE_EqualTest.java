package test;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import interfaces.IClient;
import interfaces.IEmail;
import client.Client;
import client.ClientEmail;
import client.ClientEmailHead;
import exceptions.NoLoggedUserException;
import filter.Date;
import filter.Delete;
import filter.Equal;
import filter.Filter;
import static org.mockito.Mockito.*;



public class NOSIRVE_EqualTest {

		Calendar d;
		IEmail email;
		IClient client;
		Filter f2;
		
		
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
	
	
	//Si la fecha es igual a 12/12/12 eliminar mail
	Date d=new Date();
	Equal e=new Equal("12/12/12",d);
	Delete del=new Delete();
	f2 = new Filter(e,del);
	
	}
	
	
	@Test
	public void equalDate() throws NoLoggedUserException{
		f2.filter(email,client);
		verify(client).remove(email);
		}
	
	
}	
	
	
	