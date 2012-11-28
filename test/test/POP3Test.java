package test;

import java.util.ArrayList;
import java.util.List;

import interfaces.IAccesType;
import interfaces.IClient;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IHeader;
import interfaces.IUser;

import org.junit.Before;
import org.junit.Test;

import client.Folder;
import client.Pop3;
import exception.CannotFindUserException;
import exceptions.CannotFindEmailException;
import exceptions.NoLoggedUserException;

import server.Server;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class POP3Test {

	IUser user;
	Server server;
	IClient client;
	IAccesType pop3;

	@Before
	public void SetUp() {
		user = mock(IUser.class);
		server = mock(Server.class);
		client = mock(IClient.class);
		when(user.getServer()).thenReturn(server);
		when(user.getName()).thenReturn("user");
		when(client.getLoggedUser()).thenReturn(user);
		pop3 = new Pop3();

	}

	@Test
	public void testAskEmailsAndNotDelete() throws Exception {

		pop3.askEmails(client, false);

		verify(server).sendEmailWithPOP3("user", false);

	}

	@Test
	public void testAskEmailsAndDelete() throws Exception {

		pop3.askEmails(client, true);

		verify(server).sendEmailWithPOP3("user", true);

	}

	@Test
	public void testDeleteEmailByHeader() throws CannotFindEmailException,
			Exception {
		IHeader head = mock(IHeader.class);
		IFolder folder = mock(Folder.class);
		List<IFolder> folders = new ArrayList<IFolder>();
		folders.add(folder);

		when(client.getFolders()).thenReturn(folders);
		when(folder.includes(head)).thenReturn(true);
		pop3.delete(client, head);
		verify(folder).removeEmailByHeader(head);

	}

	@Test
	public void testdeleteEmail() throws NoLoggedUserException,
			CannotFindEmailException {
		IEmail email = mock(IEmail.class);
		IFolder folder = mock(Folder.class);
		List<IFolder> folders = new ArrayList<IFolder>();
		folders.add(folder);

		when(client.getFolders()).thenReturn(folders);
		when(folder.includes(email)).thenReturn(true);
		pop3.delete(client, email);
		verify(folder).removeEmail(email);

	}

	@Test
	public void testReadEmail() {
		IEmail email = mock(IEmail.class);
		assertEquals(email, pop3.read(client, email));

	}

	@Test
	public void testReadEmailbyHeader() throws CannotFindEmailException,
			NoLoggedUserException, exception.CannotFindEmailException, CannotFindUserException {
		IEmail email = mock(IEmail.class);
		IHeader header = mock(IHeader.class);
		when(client.find(header)).thenReturn(email);

		assertEquals(email, pop3.read(client, header));
		verify(client).find(header);

	}

}
