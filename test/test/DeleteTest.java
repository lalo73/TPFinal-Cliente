package test;
import org.junit.Before;
import org.junit.Test;
import client.*;
import exceptions.NoLoggedUserException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


//CORRE
public class DeleteTest {
	
	Delete d;
	Client cl;
	Email em;
	

	@Before
	public void setUp() throws Exception {
		
		cl=mock(Client.class);
		em=mock(Email.class);
		
		d=new Delete();
	}

	@Test
	public void testDelete() throws NoLoggedUserException{
	    d.act(em,cl);
		verify(cl).remove(em);
		
		
	}
	
}
