package filtersTest;


import org.junit.Before;
import org.junit.Test;
import interfaces.IEmail;
import client.*;
import filter.Countain;
import filter.Subject;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OtroContainTest {
	Countain con;
	IEmail email;
	Header head;
    boolean res;

	@Before
	public void setUp() throws Exception {
		
		//head=mock(Header.class);
		//when(head.getSubject()).thenReturn("TrabajoPractico");
		
		email=mock(Email.class);
		//when(email.getHead()).thenReturn(head);
		Subject sub=mock(Subject.class);
		when(sub.getField(email)).thenReturn("TrabajoPractico");
		
		Countain con =new Countain("Trabajo",sub);
		res=con.satisfy(email);
		

	}

	@Test
	public void equalTest(){
		assertTrue(res);
	}
	
	
	
}
