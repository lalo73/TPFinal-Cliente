package test;

import org.junit.Test;

import server.Server;

import client.Client;
import client.ClientState;
import client.IAccesType;
import client.IClient;
import static org.mockito.Mockito.*;

public class ClientTest {
	
	@Test
	public void testWhenLogInThenAUserIsCreatedByState(){
		
		ClientState mockClientState = mock(ClientState.class);
		Server mockServer = mock(Server.class);
		IAccesType mockAccesType = mock(IAccesType.class);
		IClient client = new Client(mockClientState);
		
		
		
		
	}
	
	
}
