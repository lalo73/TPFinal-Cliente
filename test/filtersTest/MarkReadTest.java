package filtersTest;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import client.*;
import filter.MarkRead;

public class MarkReadTest {

    Email email;
	MarkRead mr;
	Client cl;
	
	
	@Before
	public void setUp() throws Exception {
		//Mock de client.
		cl=mock(Client.class);
		//Mock de email.
		email=mock(Email.class);
		when(email.isReaded()).thenReturn(false);
		
		mr=new MarkRead(false);
	}

	@Test
	public void testMarkRead(){
		//Se verifica que se mande el msj para marcar como leido al mail.
		mr.act(email,cl);
		verify(email).setReaded(true);
		
	}
	
	
}
