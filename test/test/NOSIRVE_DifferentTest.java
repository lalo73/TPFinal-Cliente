package test;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import interfaces.IClient;
import interfaces.IEmail;

import client.Client;
import client.Email;
import client.Header;

import client.Different;

import client.Filter;
import client.Folder;
import client.MoveToFolder;
import client.Subject;
import exceptions.NoLoggedUserException;
import static org.mockito.Mockito.*;


public class NOSIRVE_DifferentTest {

	Calendar d;
	IEmail email;
	IClient client;
	Folder folder;
	Filter f3;
	
	
	@Before
	public void setUp() throws NoLoggedUserException{
		
		d = Calendar.getInstance();
		d.set(Calendar.YEAR,2012);
		d.set(Calendar.MONTH, 12);
		d.set(Calendar.DAY_OF_MONTH,12);
		
		
		//Mock de Cliente
		client=mock(Client.class);
		
		
		//Mocks de header 
		Header head =mock(Header.class);//Para email
		when(head.getSubject()).thenReturn("TrabajoPractico");
		when(head.getSender()).thenReturn("TPI");
		when(head.getDate()).thenReturn(d);
		
		//Mocks de Email
		email=mock(Email.class);//Email 1
		when(email.getHead()).thenReturn(head);
		when(email.isReaded()).thenReturn(false);
		
		//Mocks de Folder
		folder= mock(Folder.class);
		
		
		//Si el subject es distinto a Java mover a carpeta spam
		Subject sub =new Subject();
		Different dif =new Different("Java",sub);
		MoveToFolder mtf = new MoveToFolder(folder,false);
		f3 = new Filter(dif,mtf);
		
	
	}
	
  @Test
  public void differentSubjectTest() throws NoLoggedUserException{
	  f3.filter(email,client);
	  verify(client).addToFolder(folder,email);
	  
  }


	
	
}
	
	
	
	
	
	
