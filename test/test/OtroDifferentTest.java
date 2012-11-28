package test;


import org.junit.Before;
import org.junit.Test;
import interfaces.IEmail;
import client.*;
import filter.Different;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//Corre
public class OtroDifferentTest {
	
	Different dif;
	IEmail e;
    boolean res;
	
    @Before
	public void setUp() throws Exception {
		//Mock de Sender
		
    	e=mock(Email.class);
    	Sender sen =mock(Sender.class);
		when(sen.getField(e)).thenReturn("Google");
		
		Different dif =new Different("TPI",sen);
		res=dif.satisfy(e);
	}

	
	@Test
	public void DifferentTest(){
		assertTrue(res);
	}
	
}
