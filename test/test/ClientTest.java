package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.HashMap;
import org.junit.Test;
import client.*;


public class ClientTest {
	
	@Test
	public void testWhenLogInAUserThenIsCreatedAUser()
	{
		IClient c = new Client();
		c.logIn("user", "password", new Server(), new Pop());
		IUser u = c.getUser();
		IUser p = mock(User.class);
		when(p.getName()).thenReturn("user");
		assertEquals(p, u);
	}
}
