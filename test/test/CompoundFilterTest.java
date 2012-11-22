package test;

import java.util.ArrayList;

import org.junit.Test;

import src.client.*;


public class CompoundFilterTest {

	public void setUp(){
	
	//Mock de Cliente
	IClient client=mock(Client.class);
	when(client.getFolders()).thenReturn(folder);
	
	
	//Mocks de Folder
	Folder spam= mock(Folder.class);
	when(spam.getName()).thenReturn("spam");
	Folder granDt = mock(Folder.class),
	when(granDt.getName()).thenReturn("GranDt");
	Folder bandejaDeEntrada= mock(Folder.class);
	when(bandejaDeEntrada.getName()).thenReturn("BandejaDeEntrada");
	
	
	//Mocks de Email
	IEmail email=mock(Email.class);//Email 
	when(email.getSubject()).thenReturn("TrabajoPractico");
	when(email.getSender()).thenReturn("TPI");
	when(email.getDate()).thenReturn("19/11/2012");
	when(email.isReaded()).thenReturn(false);
	
	
	//Compuesto AND - Devuelve True
	Sender s = new Sender();
	Equal eq=new Equal("Tpi",s);//Regla
	Subject sub =new Subject();
	Countain coun =new Countain("Trabajo",sub);//Regla
	ArrayList<Rule>listrules =new ArrayList<Rule>();
	listrules.add(eq);
	listrules.add(coun);
	CompoundAnd cAnd=new CompoundAnd(listrules);
	Delete delete=new Delete();
	Filter f4 =new Filter(false,cAnd,delete);
	
	
	//Compuesto OR - Devuelve True
	Date date = new Date();
	Different diff= new Different("14/10/2011",date);//Regla
	Sender sen = new Sender();
	Equal equ = new Equal("GranDT",sen);
	MoveToFolder move = new MoveToFolder(folder1);//Regla
	ArrayList<Rule>listrules1 =new ArrayList<Rule>();
	listrules1.add(diff);
	listrules.add(equ);

	
	//Compuesto AND - Devuelve False
	Sender send = new Sender();
	Equal equ=new Equal("MarioBros",send);//Regla
	Subject sub =new Subject();
	Countain coun =new Countain("Tra",sub);//Regla
	ArrayList<Rule>listrules =new ArrayList<Rule>();
	listrules.add(eq);
	listrules.add(coun);
	CompoundAnd cAnd=new CompoundAnd(listrules);
	Delete delete=new Delete();
	Filter f4 =new Filter(false,cAnd,delete);
	
	
	
	//Compuesto OR -Devuelve False
	
	Sender send1 = new Sender();
	Equal equ1=new Equal("MarioBros",send1);//Regla
	Subject sub1 =new Subject();
	Countain coun1 =new Countain("Taringa",sub1);//Regla
	ArrayList<Rule>listrules1 =new ArrayList<Rule>();
	listrules.add(equ1);
	listrules.add(coun1);
	CompoundAnd cAnd1=new CompoundAnd(listrules1);
	Delete delete1=new Delete();
	Filter f5 =new Filter(false,cAnd1,delete1);
	
	
	}
	
	@Test
	public void testCompoundAnd(){
	   assertEqual("El mail debe ser eliminado"false,client.includesEmail(email));
	   assertTrue("El mail debe estar en la bandeja de entrada"client.contain(email,bandejaDeEntrada));
	
	}
	
	
	@Test
	public void testCompoundOr(){
		assertTrue("El mail debe estar en la carpeta GranDr",client.contain(email,granDt));
		assertTrue("El mail debe estar en bandeja de entrada"client.contain(email,bandejaDeEntrada));
		
		
	}
	
	
}