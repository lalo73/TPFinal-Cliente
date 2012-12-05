package test;

import java.util.ArrayList;

import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;
import interfaces.IUser;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import client.AccessType;
import client.Imap;
import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;
import server.Server;
import server.ServerEmail;
import server.ServerEmailHead;

public class ImapTest {

	IClient client;
	IUser user;
	Server server;
	Imap imap;
	IHeader head;
	IEmail email;
	ServerEmail server_email;
	ServerEmailHead server_head;
	ArrayList<ServerEmailHead> server_emails;

	@Before
	public void setUp() throws CannotFindUserException, NoLoggedUserException,
			exception.CannotFindEmailException {
		client = mock(IClient.class);
		server = mock(Server.class);
		user = mock(IUser.class);
		server_emails = new ArrayList<ServerEmailHead>();
		for (int i = 0; i < 3; i++) {
			server_emails.add(mock(ServerEmailHead.class));
		}
		email = mock(IEmail.class);
		head = mock(IHeader.class);
		server_email = mock(ServerEmail.class);
		server_head = mock(ServerEmailHead.class);
		when(email.getHead()).thenReturn(head);
		when(client.getLoggedUser()).thenReturn(user);
		when(client.getFolders()).thenReturn(new ArrayList<IFolder>());
		when(user.getServer()).thenReturn(server);
		when(user.getName()).thenReturn("mock_user");
		when(server.sendEmailWithIMAP("mock_user")).thenReturn(server_emails);
		when(server.sendEmail(server_head, "mock_user")).thenReturn(
				server_email);
		when(server_email.getHead()).thenReturn(server_head);
		imap = new Imap();

	}

	@Test
	public void testAskEmails() throws CannotFindUserException, Exception {
		ArrayList<IEmail> emails = imap.askEmails(client, false);
		for (ServerEmailHead head : server_emails) {
			verify(head).getDate();
			verify(head).getReciver();
			verify(head).getSender();
			verify(head).getSubject();
		}

		assertFalse(emails.size() == 0);

	}

	@Test
	public void testDeleteByHead() throws NoLoggedUserException,
			CannotFindEmailException, Exception {
		imap.delete(client, head);

		verify(server).removeEmailByHeader(user.getName(),
				AccessType.changeToServerEmailHead(head));

	}

	@Test
	public void testDeleteByEmail() throws Exception {
		imap.delete(client, email);

		verify(server).removeEmailByReader(user.getName(),
				AccessType.changeToServerEmail(email));

	}

}
