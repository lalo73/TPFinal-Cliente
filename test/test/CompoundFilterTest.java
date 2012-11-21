package test;

import java.util.ArrayList;

import client.*;


public class CompoundFilterTest {

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
	IEmail email=mock(Email.class);//Email 
	when(email.getSubject()).thenReturn("TrabajoPractico");
	when(email.getSender()).thenReturn("TPI");
	when(email.getDate()).thenReturn("19/11/2012");
	when(email.isReaded()).thenReturn(false);
	
	
	//Compuesto AND - Devuelve True
	Sender s = new Sender();
	Equal eq=new Equal("Tpi",s);//Regla
	Subject sub =new Subject();
	Countain coun =new Countain("TrabajoPractico",sub);//Regla
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
	Countain coun =new Countain("TrabajoPractico",sub);//Regla
	ArrayList<Rule>listrules =new ArrayList<Rule>();
	listrules.add(eq);
	listrules.add(coun);
	CompoundAnd cAnd=new CompoundAnd(listrules);
	Delete delete=new Delete();
	Filter f4 =new Filter(false,cAnd,delete);
	
	
	}
	
	
	
	
}
