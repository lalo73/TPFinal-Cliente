package filtersTest;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.junit.Before;
import org.junit.Test;
import client.*;
import filter.MarkRead;

//CORRE

public class MarkReadTest {

    Email email;
	MarkRead mr;
	Client cl;
	
	
	@Before
	public void setUp() throws Exception {
		
		cl=mock(Client.class);
		email=mock(Email.class);//Email 1
		when(email.isReaded()).thenReturn(false);
		mr=new MarkRead(false);
	}

	@Test
	public void testMarkRead(){
		mr.act(email,cl);
		verify(email).setReaded(true);
		
	}
	
	
}
