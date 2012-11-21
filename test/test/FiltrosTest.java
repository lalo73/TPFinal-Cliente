package test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

import client.*;


public class FiltrosTest {

	public void setUp(){
	IEmail email=mock(Email.class);
	IClient client=mock(Client.class);
	Folder folder= mock(Folder.class);
	
	when(email.getSubject()).thenReturn("TrabajoPractico");
	when(email.getSender()).thenReturn("TPI");
	when(email.getDate()).thenReturn("19/11/2012");
	when(email.isReaded()).thenReturn(false);
	
	when(client.getFolders()).thenReturn(folder);
	
	when(folder.getName()).thenReturn("spam");
	
		//Si el sender contiene TPI marcar como leido
		Countain cont=new Countain("Tpi");
	  	Sender s = new Sender();
	  	MarkRead mark=new MarkRead();
		Filter f1= new Filter(false,cont,s,mark);
		f1.filter(email,cliente);
		
		//Si la fecha es igual a 12/12/12 eliminar mail
		Equal e=Equal("12/12/12");
		Date d=new Date();
		Delete del=new Delete();
		Filter f2 = new Filter(false,e,d,del);
		f2.filter(email,client);
		
		//Si el subject es distinto a Java mover a carpeta spam
		Different dif =new Different("Java");
		Subject sub =new Subject();
		MoveToFolder mtf = new MoveToFolder();
		Filter f3 = new Filter(false,dif,sub,mtf);
		
		//Compuesto AND
		Equal eq=new Equal("Tpi");
		Countain coun =new Countain("Juegos");
		ArrayList<Rule>listrules =new ArrayList<Rule>();
		listrules.add(eq);
		listrules.add(coun);
		CompoundAnd cAnd=new CompoundAnd(listrules);
		Sender sender=new Sender();
		Delete delete=new Delete();
		
		
	}
	
	
	@Test
	public void test(){
	
	assertEquals("el email debe estar marcado como leido",true,email.isReaded());
	assertEquals("el mail no debe estar");
	assertTrue("la carpeta spam debe contener el mail",client.contain(email,folder));
	
	
	
	
	
	
}
