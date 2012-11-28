package test;


import org.junit.Before;
import org.junit.Test;
import interfaces.IEmail;
import client.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class OtroEqualTest {
	Equal eq;
	IEmail email;
    boolean res;
    Date date;

    
	
	@Before
	public void setUp() throws Exception {
		
		email=mock(Email.class);
		date=mock(Date.class);
		when(date.getField(email)).thenReturn("12/12/12");
		
		eq =new Equal("12/12/12",date);
		res=eq.satisfy(email);
	    }

	@Test
	public void equalTest(){
		assertTrue(res);
	}
	
	
	
}
