package filtersTest;


import org.junit.Before;
import org.junit.Test;
import interfaces.IEmail;
import client.*;
import filter.Countain;
import filter.Subject;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ContainTest {
	Countain con;
	IEmail email;
    boolean res;
    Subject sub;

	@Before
	public void setUp() throws Exception {
		email=mock(Email.class);
		Subject sub=mock(Subject.class);
		when(sub.getField(email)).thenReturn("TrabajoPractico");
		con =new Countain("Spam",sub);
		
	}

	@Test
	public void equalTest(){
	 //Al no contener el mismo subject no satisfy debe dar False
	 assertFalse(con.satisfy(email));
	}
	
	
	
}
