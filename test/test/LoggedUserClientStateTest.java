package test;

import java.util.ArrayList;
import java.util.Calendar;

import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IHeader;
import interfaces.IList;
import interfaces.IUser;

import org.junit.Before;
import org.junit.Test;

import server.Server;
import servers.SMTP;

import client.AccessType;
import client.Email;
import client.Header;
import client.LoggedUserClientState;
import client.NoLoggedUserClientState;
import client.Pop3;
import exception.CannotFindUserException;
import exceptions.AlreadyLoggedException;
import exceptions.NoLoggedUserException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoggedUserClientStateTest {

	LoggedUserClientState state;
	IClient client;
	IUser user;
	IEmail email;
	IHeader head;
	AccessType type;
	ArrayList<IEmail> emails;
	ArrayList<IList> list_contanct;
	SMTP smtp;

	@Before
	public void setUp() throws CannotFindUserException, Exception {
		state = new LoggedUserClientState();
		client = mock(IClient.class);
		head = new Header("sender", "reciver", "subject",
				Calendar.getInstance());
		email = new Email(null, false);
		user = mock(IUser.class);
		type = mock(Pop3.class);
		emails = new ArrayList<IEmail>();
		list_contanct = new ArrayList<IList>();
		smtp = mock(SMTP.class);

		when(client.getLoggedUser()).thenReturn(user);
		when(user.getAccesType()).thenReturn(type);
		when(type.askEmails(client, false)).thenReturn(emails);
		when(client.getContancts()).thenReturn(list_contanct);
		when(user.getName()).thenReturn("user_name");
		when(user.getPassword()).thenReturn("password");
		when(client.getSmtp()).thenReturn(smtp);
		when(smtp.logIn("user_name", "password", "Multi-SMKTP Server"))
				.thenReturn(true);

	}

	@Test
	public void testAskEmails() throws CannotFindUserException, Exception {
		state.askEmails(client);
		verify(type).askEmails(client, false);
		verify(client).filtrar(emails);

	}

	@Test
	public void testCreateList() {
		state.addList(client, "list_name");
		verify(client).getContancts();
		assertTrue(list_contanct.size() > 0);
	}

	@Test
	public void testgetFolders() {
		state.getFolders(client);
		verify(client).getRealFolders();
	}

	@Test
	public void testgetUser() {
		state.getUser(client);
		verify(client).getRealUser();
	}

	@Test
	public void testLogIn() {
		try {
			state.logIn(client, "user", "password", new Server(), type);
			fail("Exception dont catched");
		} catch (AlreadyLoggedException e) {
		}
	}
	

}
