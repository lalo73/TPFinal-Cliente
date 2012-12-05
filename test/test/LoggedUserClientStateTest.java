package test;

import java.util.ArrayList;

import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IUser;

import org.junit.Before;
import org.junit.Test;

import client.AccessType;
import client.LoggedUserClientState;
import client.Pop3;
import exception.CannotFindUserException;
import static org.mockito.Mockito.*;

public class LoggedUserClientStateTest {

	LoggedUserClientState state;
	IClient client;
	IUser user;
	AccessType type;
	ArrayList<IEmail> emails;

	@Before
	public void setUp() throws CannotFindUserException, Exception {
		state = new LoggedUserClientState();
		client = mock(IClient.class);
		user = mock(IUser.class);
		type = mock(Pop3.class);
		emails = new ArrayList<IEmail>();
		when(client.getLoggedUser()).thenReturn(user);
		when(user.getAccesType()).thenReturn(type);
		when(type.askEmails(client, false)).thenReturn(emails);

	}

	@Test
	public void testAskEmails() throws CannotFindUserException, Exception {
		state.askEmails(client);
		verify(type).askEmails(client, false);
		verify(client).filtrar(emails);

	}
	
	@Test
	public void test

}
