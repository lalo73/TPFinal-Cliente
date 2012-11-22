package test.test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

import src.client.*;


public class SimpleFilterTest {

	public void setUp(){
	
		
	//Mock de Cliente
	IClient client=mock(Client.class);
	when(client.getFolders()).thenReturn(folder);
	
	
	//Mocks de Folder
	Folder folder= mock(Folder.class);
	when(folder.getName()).thenReturn("spam");
	Folder folder1 = mock(Folder.class),
	when(folder1.getName()).thenReturn("GranDt");
	
	
	//Mocks de Email
	IEmail email=mock(Email.class);//Email 1
	when(email.getSubject()).thenReturn("TrabajoPractico");
	when(email.getSender()).thenReturn("TPI");
	when(email.getDate()).thenReturn("19/11/2012");
	when(email.isReaded()).thenReturn(false);
	
	IEmail email=mock(Email.class);//Email 2
	when(email.getSubject()).thenReturn("Puntaje");
	when(email.getSender()).thenReturn("GranDt");
	when(email.getDate()).thenReturn("19/11/2012");
	when(email.isReaded()).thenReturn(false);
	
	
	
	//Escenarios 
	
	
		//Si el sender contiene TPI marcar como leido
		
	  	Sender s = new Sender();
	  	Countain cont=new Countain("Tpi",s);
	  	MarkRead mark=new MarkRead();
		Filter f1= new Filter(false,cont,mark);
		f1.filter(email,client);
		
		//Si la fecha es igual a 12/12/12 eliminar mail
		Date d=new Date();
		Equal e=new Equal("12/12/12",d);
		Delete del=new Delete();
		Filter f2 = new Filter(false,d,del);
		f2.filter(email,client);
		
		//Si el subject es distinto a Java mover a carpeta spam
		Subject sub =new Subject();
		Different dif =new Different("Java",sub);
		MoveToFolder mtf = new MoveToFolder();
		Filter f3 = new Filter(false,dif,mtf);
		
		
		
		
		
	}
	
	
	@Test
	public void test(){
	
	assertTrue("el email debe estar marcado como leido",email.isReaded());
	assertEquals("el mail no debe estar",false,includesEmail(email));
	assertTrue("la carpeta spam debe contener el mail",client.contain(email,folder));
	
	
	
	
	
	
}
