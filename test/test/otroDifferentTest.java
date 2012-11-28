package test;


import org.junit.Before;
import org.junit.Test;

import interfaces.IClient;
import interfaces.IEmail;

import client.*;
import client.Different;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class otroDifferentTest {
	
	Different dif;
	IEmail e;
    boolean res;
	
    @Before
	public void setUp() throws Exception {
		//Mock de Sender
		Sender sen =mock(Sender.class);
		when(sen.getField(e)).thenReturn("Google");
		
		Different dif =new Different("TPI",sen);
		res=dif.satisfy(e);
	}

	
	@Test
	public void DifferentTest(){
		assertTrue(res);
	}
	
}
