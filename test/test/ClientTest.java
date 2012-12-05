package test;

import interfaces.IClient;
import interfaces.IContact;
import interfaces.IEmail;
import interfaces.IFolder;
import interfaces.IList;
import interfaces.IPerson;

import org.junit.Before;
import org.junit.Test;
import server.Server;
import client.AccessType;
import client.Client;
import client.ClientState;
import client.Pop3;
import exception.CannotFindUserException;
import exceptions.AlreadyLoggedException;
import exceptions.NoFolderException;
import exceptions.NoLoggedUserException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ClientTest {

	Server server;
	AccessType type;
	IClient client;
	IClient settedStateClient;
	ClientState mock_state;

	@Before
	public void setUp() {
		server = mock(Server.class);
		type = mock(Pop3.class);
		client = new Client();
		mock_state = mock(ClientState.class);
		settedStateClient = new Client(mock_state);

	}

	@Test
	public void testWhenLogInWithNoLoggedUserStateThenIsCreatedAUser()
			throws AlreadyLoggedException {

		client.logIn("user_name", "password", server, type);

		assertNotNull(client.getLoggedUser());

	}

	@Test
	public void testWhenLogInThenchangeTheState() throws AlreadyLoggedException {
		ClientState original_state = client.getClientState();
		client.logIn("user_name", "password", server, type);
		assertNotSame(original_state, client.getClientState());

	}

	@Test
	public void testLogInFailAfterAPreviousLogIn()
			throws AlreadyLoggedException {
		client.logIn("user", "password", server, type);
		try {
			client.logIn("anotherUser", "password", server, type);
			fail("Exception don't catched");
		} catch (AlreadyLoggedException e) {
		}
	}

	@Test
	public void testLogOutFailBeforeALogIn() {
		try {
			client.logOut();
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {

		}
	}

	@Test
	public void testLogOutChangeTheStateAfterALogIn()
			throws AlreadyLoggedException, NoLoggedUserException {
		ClientState original_state = client.getClientState();
		client.logIn("user_name", "password", server, type);
		client.logOut();
		assertNotSame(original_state, client.getClientState());
	}

	@Test
	public void testAskEmailsFailOnNoLoggedUserState()
			throws CannotFindUserException, Exception {
		try {
			client.askEmails();
			fail("exception don't catched");
		} catch (NoLoggedUserException e) {
		}

	}

	@Test
	public void testAskEmailIsSendedToState() throws NoLoggedUserException,
			CannotFindUserException, Exception {
		settedStateClient.askEmails();
		verify(mock_state).askEmails(settedStateClient);
	}

	@Test
	public void testAddContactFailOnNoLoggedUserState()
			throws NoFolderException {
		try {
			client.addContact("contanct_name", "contanct_email");
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {
		}
	}

	@Test
	public void testAddContactIsSendedToState() throws NoLoggedUserException,
			NoFolderException {
		settedStateClient.addContact("contanct_name", "contanct_email");
		verify(mock_state).addContact(settedStateClient, "contanct_name",
				"contanct_email");
	}

	@Test
	public void testAddListFailOnNoLoggedUserState() {
		try {
			client.addList("list_name");
		} catch (NoLoggedUserException e) {
		}
	}

	@Test
	public void testAddListIsSendedToClientState()
			throws NoLoggedUserException, NoFolderException {
		settedStateClient.addList("list_name");
		verify(mock_state).addList(settedStateClient, "list_name");
	}

	@Test
	public void testAddToListFailOnNoLoggedUserState() {
		IPerson person = mock(IPerson.class);
		IList list = mock(IList.class);
		try {
			client.addToList(person, list);
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {
		}
	}

	@Test
	public void testAddToListIsSendedToState() throws NoLoggedUserException {
		IPerson person = mock(IPerson.class);
		IList list = mock(IList.class);
		settedStateClient.addToList(person, list);
		verify(mock_state).addToList(settedStateClient, person, list);

	}

	@Test
	public void testAddToListByNameFailOnNoLoggedUserState() {
		IPerson person = mock(IPerson.class);
		try {
			client.addToList(person, "listName");
			fail("exception don't catched");
		} catch (NoLoggedUserException e) {
		}
	}

	@Test
	public void testAddTiListByNameIsSendedToState()
			throws NoLoggedUserException {
		IPerson person = mock(IPerson.class);
		settedStateClient.addToList(person, "listName");
		verify(mock_state).addToList(settedStateClient, person, "listName");
	}

	@Test
	public void testRemoveAListFailOnNoLoggeedUserState() {
		IList list = mock(IList.class);
		try {
			client.remove(list);
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {
		}

	}

	@Test
	public void testREmoveAListIsSendedToState() throws NoLoggedUserException {
		IList list = mock(IList.class);
		settedStateClient.remove(list);
		verify(mock_state).remove(settedStateClient, list);
	}

	@Test
	public void testIncludesOnListFailOnNoLoggedUserState() {
		IPerson person = mock(IPerson.class);
		IList list = mock(IList.class);
		try {
			client.includesOnList(person, list);
			fail("Exception don't catched");

		} catch (NoLoggedUserException e) {
		}

	}

	@Test
	public void testIncludesInListIsSendedToState()
			throws NoLoggedUserException {
		IPerson person = mock(IPerson.class);
		IList list = mock(IList.class);
		settedStateClient.includesOnList(person, list);
		verify(mock_state).includesOnList(settedStateClient, person, list);
	}

	@Test
	public void testAddFolderFailOnNoLoggedUserState() {
		try {
			client.addFolder("folder_name");
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {
		}
	}

	@Test
	public void testAddFolderIsSendedToState() throws NoLoggedUserException {
		settedStateClient.addFolder("folder_name");
		verify(mock_state).addFolder(settedStateClient, "folder_name");
	}

	@Test
	public void testRemoveFolderFailOnNoLoggedUserState() {
		IFolder folder = mock(IFolder.class);
		try {
			client.remove(folder);
			fail("Exception don't carched");
		} catch (NoLoggedUserException e) {
		}
	}

	@Test
	public void testRemoveFolderIsSendedToState() throws NoLoggedUserException {
		IFolder folder = mock(IFolder.class);
		settedStateClient.remove(folder);
		verify(mock_state).remove(settedStateClient, folder);
	}

	@Test
	public void testRemoveFromFolderFailOnNoLoggedUserState() {
		IFolder folder = mock(IFolder.class);
		IEmail email = mock(IEmail.class);
		try {
			client.removeFrom(folder, email);
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {
		}

	}

	@Test
	public void testRemoveFromFolderIsSendedToState()
			throws NoLoggedUserException {
		IFolder folder = mock(IFolder.class);
		IEmail email = mock(IEmail.class);
		settedStateClient.removeFrom(folder, email);
		verify(mock_state).removeFrom(settedStateClient, folder, email);
	}

	@Test
	public void testGetFoldersFailOnNoLoggedUserState() {
		try {
			client.getFolders();
			fail("Exception don't catched");
		} catch (NoLoggedUserException e) {
		}

	}
	
}
