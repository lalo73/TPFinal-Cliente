package filtersTest;


import org.junit.Before;
import org.junit.Test;

import client.*;
import exceptions.NoLoggedUserException;
import filter.MoveToFolder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


//CORRE
public class MoveToFolderTest {

	MoveToFolder mtf;
	Folder folder;
	Email email;
	Client client;
	
	@Before
	public void setUp() throws Exception {
		
		folder=mock(Folder.class);
		email=mock(Email.class);
		client=mock(Client.class);
		
		mtf=new MoveToFolder(folder,false);
		
	}

	
	@Test
	public void testMoveToFolder() throws NoLoggedUserException{
		mtf.act(email,client);
		verify(client).addToFolder(folder,email);
		
	}
	
}
