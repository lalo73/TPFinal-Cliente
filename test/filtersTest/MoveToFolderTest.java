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
		//Mock de folder
		folder=mock(Folder.class);
		
		//Mock de email
		email=mock(Email.class);
		
		//Mock de client
		client=mock(Client.class);
		
		mtf=new MoveToFolder(folder,false);
		
	}

	
	@Test
	public void testMoveToFolder() throws NoLoggedUserException{
		//Se verifica que se mande el metodo para que el email sea movido a otra carpeta.
		mtf.act(email,client);
		verify(client).addToFolder(folder,email);
		
	}
	
}
