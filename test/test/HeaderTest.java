package test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import client.Header;

import interfaces.IHeader;

public class HeaderTest {

	IHeader head;

	@Before
	public void setUp() {
		head = new Header("sender", "reciver", "subject",
				Calendar.getInstance());
	}

	@Test
	public void testGetSender() {
		assertEquals("sender", head.getSender());

	}

	@Test
	public void testGetReciver(){
		assertEquals("reciver", head.getReciver());
	}
	
	@Test
	public void testGetSubject()
	{
		assertEquals("subject", head.getSubject());
	}
}
