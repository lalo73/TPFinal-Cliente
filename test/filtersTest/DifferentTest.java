package filtersTest;


import org.junit.Before;
import org.junit.Test;
import interfaces.IEmail;
import interfaces.IHeader;
import client.*;
import filter.Different;
import filter.Sender;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//Corre
public class DifferentTest {

	Different dif;
	IEmail e;
	IHeader head;
	
	@Before
	public void setUp() throws Exception {
		// Mock de Sender
		e = mock(Email.class);
		Sender sen = mock(Sender.class);
		when(sen.getField(e)).thenReturn("Google");
		dif = new Different("TPI", sen);
	}

	@Test
	public void differentTest() {
		// Al ser el sender diferente al que yo quiero("TPI"),satisfy debe ser
		// True
		assertTrue(dif.satisfy(e));
	}

}
