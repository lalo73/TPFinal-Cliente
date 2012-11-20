package test;
import static org.mockito.Mockito.*;
import client;
import client.Countain;



public class FiltrosTest {

	//IUser u = c.getUser();
	//IUser p = mock(User.class);
	//when(p.getName()).thenReturn("user");
	
	IEmail email=mock(Email.class);
	when(e.getSubject()).thenReturn("TrabajoPractico");
	when(e.getSender()).thenReturn("Mario");
	when(e.getDate()).thenReturn("19/11/2012");
	
	public void setUp(){
		//Si el sender contiene TPI marcar como leido
		Countain cont=new Countain("TPI");
	  	Sender s = new Sender();
	  	MarkRead mark=new MarkRead();
		Filter f1= new Filter(false,cont,s,mark);
		
		//Si la fecha es igual a 12/12/12 eliminar mail
		Equal e=Equal("12/12/12");
		Date d=new Date();
		Delete d=new Delete();
		Filter f2 = new Filter(false,e,d,d);
		
		//Si el subject es distinto a Java mover a carpeta spam
		Different dif =new Different("Java");
		Subject sub =new Subject();
		MoveToFolder mtf = new MoveToFolder();
		
		//Regla compuesta and
		
		
	}
	
	
	@Test
	public void test
	
	
	
	
	
	
	
	
	
}
