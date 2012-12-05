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

	@Before
	public void setUp() throws Exception {
		

	}

	@Test
	public void equalTest(){
		//Al no contener el mismo subject no satisfy debe dar False
		email=mock(Email.class);
		Subject sub=mock(Subject.class);
		when(sub.getField(email)).thenReturn("TrabajoPractico");
		
		Countain con =new Countain("Spam",sub);
		
		assertFalse(con.satisfy(email));
	}
	
	
	
}
