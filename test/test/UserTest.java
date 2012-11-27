package test;

import interfaces.IAccesType;
import interfaces.IUser;

import org.junit.Test;

import client.User;

import server.Server;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class UserTest {
	
	@Test
	public void testWhenTwoUserAreEqualThentheirUserNameAndServerAndPasswordAreToo(){
		Server mockServer = mock(Server.class);
		IAccesType mockAccesType = mock(IAccesType.class);
		IUser userOne = new User("userName", "password", mockServer, mockAccesType);
		IUser userTwo = new User("userName", "password", mockServer, mockAccesType);
		when(mockServer.equals(mockServer)).thenReturn(true);
		assertTrue(userTwo.equals(userOne));
	}

}
